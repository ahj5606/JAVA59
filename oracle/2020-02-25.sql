SELECT deptno,dname,loc FROM dept


select * from emp

4, SELF JOIN


SELECT e.empno "��� ��ȣ" ,e.ename "��� ��",e.mgr "������ ��ȣ",m.empno "������ ��� ��ȣ",m.ename "������ �̸�"
  FROM emp e , emp m
 WHERE E.MGR = m.empno
 
 
select * from tdept;
 
SELECT DEPT_CODE,DEPT_NAME,PARENT_DEPT
  FROM tdept

tdept���̺��� �̿��Ͽ� �μ��ڵ�,�μ���,�����μ��ڵ�,�����μ����� �о���� sql���� �ۼ��Ͻÿ�.
 
SELECT d.dept_code "�μ��ڵ�",d.dept_name "�μ���",p.dept_code "�����μ��ڵ�",p.dept_name "�����μ���"
  FROM tdept d ,tdept p
 WHERE p.dept_code = d.parent_dept 
 
 
temp�� tdept�� �̿��Ͽ�
�����μ��� CA0001�� �μ��� �Ҽӵ� ������
1,���,2.����,3.�μ��ڵ�.4,�μ���,5.�����μ��ڵ�,6.�����μ���,7.�����μ����ڵ�,8.�����μ��强�� ������ ����ϴ� SQL���� �ۼ��Ͻÿ�.

SELECT * FROM TEMP

SELECT * FROM TDEPT

SELECT e.emp_id "���",e.emp_name "����",e.dept_code "�μ��ڵ�"
      ,t.dept_name "�μ���" ,PT.DEPT_CODE "�����μ��ڵ�", pt.dept_name "�����μ���"
      , pe.emp_id "�����μ����ڵ�"
      ,pe.emp_name "�����μ����"
  FROM temp e ,tdept t ,tdept pt ,temp pe
 WHERE e.dept_code = t.dept_code  
   AND t.parent_dept = pt.dept_code 
   AND pt.dept_code='CA0001' 
   AND  pt.boss_id = pe.emp_id
   
select * from tcom
   

��������  where���� select���� �����

�ζ��κ� from���� select���� ����� 

�������� ������ �ƴ� ���������� �����ϰ� ���ϴ� ����� �O�� ��� 

1.temp���� ������ ���� ���� ������ row�� ã�Ƽ� �� �ݾװ�
������ �ݾ��� �޴� ������ ����� �̸��� ����Ͻÿ�.

SELECT emp_id as "���" ,emp_name as "�̸�"
 FROM temp
 WHERE salary = (SELECT max(salary) FROM temp);
 
2.temp�� �ڷḦ �̿��Ͽ� salary�� ����� ���ϰ� �� ���� ū
�ݾ��� salary�� �޴� ������ ����� ����, ������ ����Ͻÿ�.

SELECT emp_id,emp_name,salary
  FROM temp
 WHERE salary >= (SELECT AVG(salary) FROM temp)
 
3.temp�� ���� �� ��õ�� �ٹ��ϴ� ������ ����� ������
����ϴ� sql�� �ۼ��ϱ� 

SELECT * FROM TEMP

SELECT * FROM TDEPT

SELECT emp_id,emp_name
  FROM temp 
 WHERE dept_code in(SELECT dept_code FROM tdept WHERE area = '��õ')

tcom�� �����ܿ� Ŀ�̼��� �޴� ������ ����� �����Ǿ� �ִ�.
�μ���Ī���� Ŀ�̼��� �޴� �ο����� ���� sql���� �ۼ��Ͻÿ�.

SELECT t.dept_name , count(e.emp_id)
 FROM temp e , tdept t
WHERE e.dept_code = t.dept_code and  e.emp_id in (SELECT emp_id FROM tcom)
GROUP BY t.dept_name

select * from tcom


temp���� �μ��� �ְ� �����ݾ��� �о �ش� �μ��� �ְ� 
�����ݾ��� ���ÿ� ��ġ�ϴ� ����� ���,����,������ �о ����� ���ÿ�.


SELECT emp_id , emp_name, salary
 FROM temp
WHERE (dept_code,salary) IN (SELECT dept_code,max(salary) from temp group by dept_code) --in���̿��ؼ� ���ҋ� 2���� �� ����.
 



select * from t_worktime

COMMIT

DELETE FROM T_WORKTIME
WHERE ROWNUM <3

SELECT time_nu
  FROM t_worktime
  
SELECT a.time_nu ,b.time_nu
FROM t_worktime a , t_worktime b
 WHERE a.time_nu >= b.time_nu
 
SELECT a.time_nu ,count(b.time_nu)
  FROM t_worktime a , t_worktime b
 WHERE a.time_nu >= b.time_nu
GROUP BY a.time_nu

SELECT time_nu,rank() OVER(order by time_nu asc) as rk
 FROM t_worktime
 
SELECT a.time_nu ,count(b.time_nu)+1
  FROM t_worktime a , t_worktime b
 WHERE a.time_nu > b.time_nu(+)
GROUP BY a.time_nu


SELECT emp_name FROM temp

SELECT rownum rno , emp_name FROM temp

ceil ����� �ø�

SELECT 
       rno,ceil(rno/4) cno
  FROM (SELECT rownum rno , emp_name FROM temp);
  
SELECT 
      ceil(rno/4) cno
FROM (SELECT rownum rno , emp_name FROM temp)
GROUP BY ceil(rno/4)
  
SELECT 
      rno,ceil(rno/4) cno ,mod(rno,4) mno
FROM (SELECT rownum rno , emp_name FROM temp)


SELECT 
      rno,ceil(rno/5) cno ,mod(rno,5) mno
     ,decode(mod(rno,5),1,emp_name) name1
FROM (SELECT rownum rno , emp_name FROM temp)


SELECT  
      rno,ceil(rno/5) cno ,mod(rno,5) mno
     ,decode(mod(rno,5),1,emp_name) name1
     ,decode(mod(rno,5),2,emp_name) name2
     ,decode(mod(rno,5),3,emp_name) name3
     ,decode(mod(rno,5),4,emp_name) name4
     ,decode(mod(rno,5),0,emp_name) name5
FROM (SELECT rownum rno , emp_name FROM temp)


SELECT  
      ceil(rno/5) cno
     ,max(decode(mod(rno,5),1,emp_name)) name1
     ,max(decode(mod(rno,5),2,emp_name)) name2
     ,max(decode(mod(rno,5),3,emp_name)) name3
     ,max(decode(mod(rno,5),4,emp_name)) name4
     ,max(decode(mod(rno,5),0,emp_name)) name5
FROM (SELECT rownum rno , emp_name FROM temp)
GROUP BY ceil(rno/5) 
ORDER BY ceil(rno/5) ASC
     



 SELECT 
        sum(decode(job,'CLERK',sal,null))
       ,sum(decode(job,'SALESMAN',sal,null))
  FROM emp

 SELECT 
        decode(job,'CLERK',sal,null)
       ,decode(job,'SALESMAN',sal,null)
  FROM emp  
  GROUP BY decode(job,'CLERK',sal,null) ,decode(job,'SALESMAN',sal,null)