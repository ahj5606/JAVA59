SELECT
        sum(sal),ename
   FROM emp

SELECT
        sum(sal),max(ename),min(ename)
   FROM emp
   
�ǹ̾���

SELECT
        sum(sal),ename
   FROM emp
GROUP BY ename

�׷��Լ��� ������� ���� ename�÷��� group by���� ����ؼ� �������� ������ �ذ��Ͽ���.
group by ȿ���� ���� ����

����üũ(parsing)
parsing - �����ȸ�� ����� - ��Ƽ����������[�ϲ�]���� �ѱ� 
- open~cursor~fetch - �о�´�.

SELECT ename,dname
  FROM emp ,dept 
 WHERE dept.deptno=emp.deptno

dual�� ����Ŭ���� �Լ��� �׽�Ʈ�� �������� ������� ������ ���̺� �Ԥ���.
�ο� �Ѱ� �÷� �Ѱ�

SELECT TO_CHAR(sysdate,'yyyy-mm-dd') from dual

SELECT '��ü' as zdo FROM dual
UNION ALL
SELECT zdo
  FROM (
SELECT DISTINCT(zdo) 
  FROM zipcode_t 
ORDER BY ZDO ASC
  )
 







FROM�� �Ʒ� SELECT ���� �� �� �ִ�.
�ζ��κ並 ����ϸ�  ���� �������� �ʴ� �÷��� �ٱ��ʿ� select������
����� ������.

� �����̵��� ���̺� ���� �״�� ����� ���ϴ� �ý�����
�Ѱ��� ������.
���̺��� �����ؼ� ��������ڰ� ���ϴ� ���·� ����� �������