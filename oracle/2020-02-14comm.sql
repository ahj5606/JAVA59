select * from tcom

select * from temp


SELECT temp.emp_id,temp.salary,tcom.comm
FROM temp,tcom
where temp.emp_id = tcom.emp_id

SELECT emp_id,salary,comm
    FROM(
        SELECT emp_id,salary,0 comm
        FROM temp
          UNION ALL
        SELECT emp_id,0 salary,comm
        FROM tcom
)order by emp_id asc

--교집합
SELECT emp_id from temp
intersect
SELECT emp_id from tcom

--차집합
SELECT emp_id from temp
minus
SELECT emp_id from tcom

SELECT emp_id,salary,0 comm FROM temp
UNION
SELECT emp_id,0 salary,comm FROM TCOM

select * from t_giftmem

select * from t_giftpoint

select * from emp,dept 


SELECT gm.name_vc as 이름,gm.point_nu as 보유포인트,gp.point_nu as 사용포인트,gm.point_nu-gp.point_nu as 남은포인트,gp.name_vc as 상품명
  FROM t_giftmem gm ,t_giftpoint gp 
 WHERE gp.name_vc='영화티켓' AND SIGN(gm.point_nu-gp.point_nu)>=0 --AND gm.point_nu>=gp.point_nu;

-선생님---------------------------------------------------------------------------------------------------------------
SELECT gm.name_vc as 이름,gm.point_nu as 보유포인트,gp.point_nu as 사용포인트,gm.point_nu-gp.point_nu as 남은포인트
  FROM t_giftmem gm ,
                    (SELECT point_nu
                       FROM t_giftpoint
                      WHERE name_vc='영화티켓') gp
 WHERE gm.point_nu>=gp.point_nu;  





SELECT name_vc as 상품평 , point_nu as 포인트
  FROM t_giftpoint
  WHERE point_nu =(SELECT  max(gp.point_nu)
                    FROM t_giftmem gm ,t_giftpoint gp 
                   WHERE gm.name_vc ='김유신' AND SIGN(gm.point_nu-gp.point_nu)>=0 )
                   
-------------------------------------------------------------------------------------------------------

SELECT name_vc
  FROM t_giftpoint
 WHERE point_nu = 50000




SELECT name_vc,point_nu from t_giftpoint 

SELECT dept.dname
FROM emp,dept
WHERE emP.ename='ADAMS' and emp.deptno = dept.deptno 

SELECT * FROM TEST11

SELECT grade as 학년,coll as 소속,dept as 학과,person as 인원수
FROM(
SELECT '1학년' as grade,coll,dept,fre as person
FROM test11
UNION ALL
SELECT '2학년' as grade,coll,dept,sup as person
FROM test11
UNION ALL
SELECT '3학년' as grade,coll,dept,jun as person
FROM test11
UNION ALL
SELECT '4학년' as grade,coll,dept,sen as person
FROM test11
)ORDER BY dept asc , grade asc

select decode(rno,1,'1학년',2,'2학년',3,'3학년',4,'4학년') as 학년,
        coll as 소속,dept as 학과,
       decode(rno,1,fre
                ,2,sup
                ,3,jun
                ,4,sen) as 인원수
                      from test11,(SELECT rownum rno FROM emp where rownum<5)
                     order by dept asc, rno asc
                



select rno,coll,dept
  from test11,(SELECT rownum rno FROM dept)
  order by dept asc, rno asc




SELECT rownum rno FROM dual




select rno,coll,dept,fre,sup,jun,sen
                      from test11,(SELECT rownum rno FROM dept)
                     order by dept asc, rno asc



select name_vc
from t_giftpoint
where point_nu= (select max(point_nu))