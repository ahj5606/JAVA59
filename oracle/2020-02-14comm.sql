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

--������
SELECT emp_id from temp
intersect
SELECT emp_id from tcom

--������
SELECT emp_id from temp
minus
SELECT emp_id from tcom

SELECT emp_id,salary,0 comm FROM temp
UNION
SELECT emp_id,0 salary,comm FROM TCOM

select * from t_giftmem

select * from t_giftpoint

select * from emp,dept 


SELECT gm.name_vc as �̸�,gm.point_nu as ��������Ʈ,gp.point_nu as �������Ʈ,gm.point_nu-gp.point_nu as ��������Ʈ,gp.name_vc as ��ǰ��
  FROM t_giftmem gm ,t_giftpoint gp 
 WHERE gp.name_vc='��ȭƼ��' AND SIGN(gm.point_nu-gp.point_nu)>=0 --AND gm.point_nu>=gp.point_nu;

-������---------------------------------------------------------------------------------------------------------------
SELECT gm.name_vc as �̸�,gm.point_nu as ��������Ʈ,gp.point_nu as �������Ʈ,gm.point_nu-gp.point_nu as ��������Ʈ
  FROM t_giftmem gm ,
                    (SELECT point_nu
                       FROM t_giftpoint
                      WHERE name_vc='��ȭƼ��') gp
 WHERE gm.point_nu>=gp.point_nu;  





SELECT name_vc as ��ǰ�� , point_nu as ����Ʈ
  FROM t_giftpoint
  WHERE point_nu =(SELECT  max(gp.point_nu)
                    FROM t_giftmem gm ,t_giftpoint gp 
                   WHERE gm.name_vc ='������' AND SIGN(gm.point_nu-gp.point_nu)>=0 )
                   
-------------------------------------------------------------------------------------------------------

SELECT name_vc
  FROM t_giftpoint
 WHERE point_nu = 50000




SELECT name_vc,point_nu from t_giftpoint 

SELECT dept.dname
FROM emp,dept
WHERE emP.ename='ADAMS' and emp.deptno = dept.deptno 

SELECT * FROM TEST11

SELECT grade as �г�,coll as �Ҽ�,dept as �а�,person as �ο���
FROM(
SELECT '1�г�' as grade,coll,dept,fre as person
FROM test11
UNION ALL
SELECT '2�г�' as grade,coll,dept,sup as person
FROM test11
UNION ALL
SELECT '3�г�' as grade,coll,dept,jun as person
FROM test11
UNION ALL
SELECT '4�г�' as grade,coll,dept,sen as person
FROM test11
)ORDER BY dept asc , grade asc

select decode(rno,1,'1�г�',2,'2�г�',3,'3�г�',4,'4�г�') as �г�,
        coll as �Ҽ�,dept as �а�,
       decode(rno,1,fre
                ,2,sup
                ,3,jun
                ,4,sen) as �ο���
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