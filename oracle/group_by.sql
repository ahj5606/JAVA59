�׷��Լ�

�츮ȸ�翡 �ٹ��ϴ� ���[�����̸�]�� �� ���ΰ���?

SELECT count(*),count(comm),avg(sal),max(sal),min(sal)
  FROM emp;

SELECT sal FROM emp;

�׷��Լ��� �׷��Լ��� ���� �÷��� ���� �� �� ����.
�׷��Լ��� ����ϸ� ����� �׻� 1�� �ο� �̴�

�ο�� �����ִ� �������̴�.
�÷� ������ ���� �ٸ� ����� �޿�,�μ�Ƽ��,�Ի����ڰ� �ȴ�.
�÷��� �ڹ��� ������ ����Ѱ� ����.

SELECT sum(sal),deptno FROM emp

deptno�� min�׷��Լ��� ������ �������� ������ �ذ�������
�� ���� �ǹ� ����.

SELECT sum(sal),min(deptno) FROM emp

�μ��� �޿��� ���� ���ϰ� ������ �����

SELECT deptno,sum(sal)
 FROM emp 
 GROUP BY deptno

IF���� ����� �� �ֳ���?

DECODE(A,B,'T','F')

SELECT decode(1,1,'T','F') FROM dual

�츮ȸ�翡 �ٹ��ϴ� ����߿��� job salesman�� ��
clerk�� ��, �������� ��Ÿ�� ������ ����ϴ� sql���� �ۼ��Ͻÿ�


SELECT sum(decode(job,'CLERK',sal,null)) as "clerk"
      ,sum(decode(job,'SALESMAN',sal,null)) as "salesman"
      ,sum(decode(job,'CLERK',null,decode(job,'SALESMAN',null,sal))) as "etc"
      ,sum(decode(job,null,null,sal)) 
      - (sum(decode(job,'CLERK',sal,null))
      +sum(decode(job,'SALESMAN',sal,null))) as "etc"
      ,sum(decode(job,'CLERK',null,'SALESMAN',null,sal))
    FROM emp
    
����1:�ִ� ���ǽð��� ������ ������ '�Ϲݰ���'�� ��ȯ�ϰ�
�������� '��Ÿ����'�̶�� ����ϴ� sql���� �ۼ��Ͻÿ�

����2: �ִ� ���ǽð��� ������ ���� ������ ���ڸ� �˰� �ʹ�.
�����?
--�ݵ�� decode�� Ǯ�����

����3:lec_time�� ũ�� '�������',lec_point�� ũ�� '��Ÿ����' ���� ������'�Ϲ�'�� ����ϴ� select���� �ۼ��� ���ÿ�