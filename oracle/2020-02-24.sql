SELECT sysdate +1 , sysdate-1 ,sysdate+2 FROM dual

��¥ Ÿ���̸� ���ϱ�� ���� ������ �����ϴ�.

��¥�� �Ѱ��� ���ڰ� ���� �;��Ѵ�.

Ÿ���� ����� �� ���� �� Ÿ���� ��� ������ �� �ִ� Ÿ������ �ؾ��Ѵ�.

���� ����Ŭ , �ڹ� ��� ȿ�����ϱ�? 

�ڿ��� ��� �ִ���

�����Ͱ� ����Ŭ�� �����Ƿ� ������ select������ �������ϰ�
�� ���� ������ �����ϴ� �͵� ����Ŭ �ȿ��� �����ϴϱ� ó���� �����
�� ���� ���� ȭ�鿡 ����ϴ� ���� �� ȿ�����̴�.

����
0.īŸ�þ��� �� 

1.equals ���� -- ������ �O�ư�

temp���̺��� �����ȣ(temp) �����(temp) �μ�����(tdept)
�Բ� ����ʹ�. (tdept) �����?

select * from temp

select * from tdept

-- �������� �ĺ��� = select ��

SELECT e.emp_id , e.emp_name ,d.dept_name
  FROM temp e , tdept d               --īŸ�þ��� �� -����Ǽ��� ��� ��ȸ, ����� �ƴѰ��� ������. ��� ����� ���� ����.
 WHERE e.dept_code = d.dept_code

SELECT e.emp_id , e.emp_name ,d.dept_name
  FROM temp e JOIN tdept d  
  ON e.dept_code = d.dept_code
             

2. non-equals����
���� ������ '='�� �ƴ� �ٸ� �����ȣ�� �־����� ���

temp�� emp_leve�� �̿��ؼ� emp_level�� ���� ������ �������� ��������
���� ���� ��� ������ ����� ����, ����, salary�� ����ϴ�
select���� �ۼ��Ͻÿ�.

SELECT * FROM emp_level

select * from temp

SELECT e.emp_name ,e.lev ,e.salary
 FROM temp e , emp_level l 
 WHERE  l.lev='����' and  e.salary >=l.from_sal and e.salary<=l.to_sal

SELECT e.emp_name ,e.lev ,e.salary
 FROM temp e , emp_level l 
 WHERE  l.lev='����' and e.salary between l.from_sal and l.to_sal

SELECT e.emp_name ,e.lev ,e.salary
 FROM temp e JOIN emp_level l 
 ON  l.lev='����' and  e.salary >=l.from_sal and e.salary<=l.to_sal

3. outer����
�� �� �̻��� ���̺� ���ν� ���� ���̺��� �࿡ ���ؼ� �ٸ���
���̺��� ��ġ�ϴ� ���� ������ �ٸ� �� ���̺��� ���� NULL�� �Ͽ�
���� �����Ѵ�.
<-> equals-join �� ���̻��� ���տ��� ���� ��ο� �ִ� �ο츦 �����ּ���.

select �÷�1 , �÷�2 from ���̺�1 ,���̺�2
where ���̺�1.�÷� = ���̺�2.�÷�(+) -- null���� �����ϴ°��� (+)�� ��� 

select * from emp

select * from dept

select e.ename , d.deptno 
  from emp e , dept d 
 where e.deptno(+)=d.deptno

���°� null�� ó���ϱ�

�Ʒ����� �� ������ ����� ������ ������վȿ� �μ����� ���� �����̴�.
�׷��� ���������� ������ ��� ����� ���� ��ȸ�Ǵϱ� ...
������ ����� ���� ���´�. - īŸ�þȰ� :������ ����
īŸ�þ��� ������ �ǹ� ���� ������ ��� �ִ�.
�׷��� ���� �����͸� �����ϴµ� ����ϰų� �Ұ�, �Ѱ踦 ���ϴ�
�ڵ忡�� ���Ǵ� ��찡 ����.

select e.ename , d.deptno 
  from emp e , dept d 
 where e.deptno(+)=d.deptno

�� ����� �̸� , salary, �������ѱݾ� , �������ѱݾ���
������ �Ѵ�.
temp�� emp_leve�� �����Ͽ� ����� �����ֵ�
���� ������ �������� ��ϵǾ� ����  ���� '����'����� 
����,salary ������ �̶� ���� �� �ֵ��� sql ���� �ۼ��Ͻÿ�.

SELECT e.emp_name ,e.salary,e.lev , le.to_sal , le.from_sal 
  FROM temp e, emp_level le 
 WHERE e.lev = le.lev(+)



4. self ����
    



SELECT e.emp_id , e.emp_name ,d.dept_name
  FROM temp e , tdept d 
 WHERE e.dept_code = d.dept_code