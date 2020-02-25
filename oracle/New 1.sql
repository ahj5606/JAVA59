SELECT deptno,dname,loc
FROM DEPT;

SELECT *
FROM emp;

SELECT e.ename,d.dname
FROM emp e,dept d
WHERE e.deptno=d.deptno;

select ZIPCODE,ADDRESS
from zipcode_t 
WHERE DONG='당산동'; --선분조건검색

select address
from zipcode_t;

where dong ='당산동'

select ZIPCODE,address
from zipcode_t
WHERE DONG LIKE '%'||'당산동'||'%'; 
--선분조건검색

select * from zipcode_t;

select * from dept;

DELETE FROM zipcode_t; --테이블데이터삭제하기
COMMIT --테이블에 반영하기

select sysdate
    ,to_char(sysdate,'YYYY')
    ,to_char(sysdate,'HH24')
    ,to_char(sysdate,'YYYY-MM-DD HH24:mm:ss AM')
    ,to_char(sysdate,'HH24:mm:ss')
    from dual;
    
select zipcode,address
from zipcode_t
where DONG='가산동';