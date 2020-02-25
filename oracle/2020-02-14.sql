SELECT
        sum(sal),ename
   FROM emp

SELECT
        sum(sal),max(ename),min(ename)
   FROM emp
   
의미없다

SELECT
        sum(sal),ename
   FROM emp
GROUP BY ename

그룹함수가 적용되지 않은 ename컬럼을 group by절에 사용해서 문법적인 문제를 해결하였다.
group by 효과가 전혀 없다

문법체크(parsing)
parsing - 실행계회을 세운다 - 옵티마이저에게[일꾼]에게 넘김 
- open~cursor~fetch - 읽어온다.

SELECT ename,dname
  FROM emp ,dept 
 WHERE dept.deptno=emp.deptno

dual은 오라클에서 함수를 테스트할 목적으로 만들어진 가상의 테이블 입ㄴ디ㅏ.
로우 한개 컬럼 한개

SELECT TO_CHAR(sysdate,'yyyy-mm-dd') from dual

SELECT '전체' as zdo FROM dual
UNION ALL
SELECT zdo
  FROM (
SELECT DISTINCT(zdo) 
  FROM zipcode_t 
ORDER BY ZDO ASC
  )
 







FROM절 아래 SELECT 문이 올 수 있다.
인라인뷰를 사용하면  실제 존재하지 않는 컬럼도 바깥쪽에 select문에서
사용이 가능함.

어떤 업무이든지 테이블 형테 그대로 출력을 원하는 시스템은
한개도 없었다.
테이블을 가공해서 업무담당자가 원하는 형태로 출력을 해줘야함