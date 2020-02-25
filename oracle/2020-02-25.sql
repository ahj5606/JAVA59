SELECT deptno,dname,loc FROM dept


select * from emp

4, SELF JOIN


SELECT e.empno "사원 번호" ,e.ename "사원 명",e.mgr "관리자 번호",m.empno "관리자 사원 번호",m.ename "관리자 이름"
  FROM emp e , emp m
 WHERE E.MGR = m.empno
 
 
select * from tdept;
 
SELECT DEPT_CODE,DEPT_NAME,PARENT_DEPT
  FROM tdept

tdept테이블을 이용하여 부서코드,부서명,상위부서코드,상위부서명을 읽어오는 sql문을 작성하시오.
 
SELECT d.dept_code "부서코드",d.dept_name "부서명",p.dept_code "상위부서코드",p.dept_name "상위부서명"
  FROM tdept d ,tdept p
 WHERE p.dept_code = d.parent_dept 
 
 
temp와 tdept를 이용하여
상위부서가 CA0001인 부서에 소속된 직원을
1,사번,2.성명,3.부서코드.4,부서명,5.상위부서코드,6.상위부서명,7.상위부서장코드,8.상위부서장성명 순으로 출력하는 SQL문을 작성하시오.

SELECT * FROM TEMP

SELECT * FROM TDEPT

SELECT e.emp_id "사번",e.emp_name "성명",e.dept_code "부서코드"
      ,t.dept_name "부서명" ,PT.DEPT_CODE "상위부서코드", pt.dept_name "상위부서명"
      , pe.emp_id "상위부서장코드"
      ,pe.emp_name "상위부서장명"
  FROM temp e ,tdept t ,tdept pt ,temp pe
 WHERE e.dept_code = t.dept_code  
   AND t.parent_dept = pt.dept_code 
   AND pt.dept_code='CA0001' 
   AND  pt.boss_id = pe.emp_id
   
select * from tcom
   

서브쿼리  where절에 select문을 사용함

인라인뷰 from절에 select문을 사용함 

직접적인 조건이 아닌 간접조건을 제시하고 원하는 결과를 찿는 경우 

1.temp에서 연봉이 가장 많은 직원의 row를 찾아서 이 금액과
동일한 금액을 받는 직원의 사번과 이름을 출력하시오.

SELECT emp_id as "사번" ,emp_name as "이름"
 FROM temp
 WHERE salary = (SELECT max(salary) FROM temp);
 
2.temp의 자료를 이용하여 salary의 평균을 구하고 이 보다 큰
금액을 salary로 받는 직원의 사번과 성명, 연봉을 출력하시오.

SELECT emp_id,emp_name,salary
  FROM temp
 WHERE salary >= (SELECT AVG(salary) FROM temp)
 
3.temp의 직원 중 인천에 근무하는 직원의 사번과 성명을
출력하는 sql문 작성하기 

SELECT * FROM TEMP

SELECT * FROM TDEPT

SELECT emp_id,emp_name
  FROM temp 
 WHERE dept_code in(SELECT dept_code FROM tdept WHERE area = '인천')

tcom에 연봉외에 커미션을 받는 직원의 사번이 보관되어 있다.
부서명칭별로 커미션을 받는 인원수를 세는 sql문을 작성하시오.

SELECT t.dept_name , count(e.emp_id)
 FROM temp e , tdept t
WHERE e.dept_code = t.dept_code and  e.emp_id in (SELECT emp_id FROM tcom)
GROUP BY t.dept_name

select * from tcom


temp에서 부서별 최고 연봉금액을 읽어서 해당 부서와 최고 
연봉금액이 동시에 일치하는 사원의 사번,성명,연봉을 읽어서 출력해 보시오.


SELECT emp_id , emp_name, salary
 FROM temp
WHERE (dept_code,salary) IN (SELECT dept_code,max(salary) from temp group by dept_code) --in을이용해서 비교할떄 2가지 비교 가능.
 



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

ceil 결과값 올림

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