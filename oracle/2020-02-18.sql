--SELECT * FROM DEPT

--INSERT INTO DEPT VALUES(?,?,?);

--UPDATE DEPT SET DNAME = ?, LOC = ? WHERE DEPTNO = ?

--DELETE FROM dept where deptno = ?

SELECT deptno , dname , loc  
  FROM dept
 WHERE deptno = :deptno
 
INSERT INTO dept values(?,?,?);


UPDATE dept set dname =? ,loc = ?
WHERE deptno = ?

DELETE FROM dept WHERE deptno = 62

INSERT INTO dept values(61,'개발부','서울')

select * from dept


commit

rollback

UPDATE dept set dname ='형상관리부' ,loc = '경기' 
WHERE deptno = 61