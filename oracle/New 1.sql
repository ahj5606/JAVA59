SELECT deptno,dname,loc
FROM DEPT;

SELECT *
FROM emp;

SELECT e.ename,d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno;

select ZIPCODE,ADDRESS
from zipcode_t 
WHERE DONG='��굿'; --�������ǰ˻�

select address
from zipcode_t;

where dong ='��굿'

select ZIPCODE,address
from zipcode_t
WHERE DONG LIKE '%'||'��굿'||'%'; 
--�������ǰ˻�

select * from zipcode_t;

select * from dept;

DELETE FROM zipcode_t; --���̺����ͻ����ϱ�
COMMIT --���̺� �ݿ��ϱ�

select sysdate
    ,to_char(sysdate,'YYYY')
    ,to_char(sysdate,'HH24')
    ,to_char(sysdate,'YYYY-MM-DD HH24:mm:ss AM')
    ,to_char(sysdate,'HH24:mm:ss')
    from dual;
    
select zipcode,address
from zipcode_t
where DONG='���굿';