그룹함수

우리회사에 근무하는 사원[집합이름]은 몇 명인가요?

SELECT count(*),count(comm),avg(sal),max(sal),min(sal)
  FROM emp;

SELECT sal FROM emp;

그룹함수는 그룹함수가 없는 컬럼과 같이 쓸 수 없다.
그룹함수를 사용하면 결과는 항상 1개 로우 이다

로우는 관련있는 정보들이다.
컬럼 방항은 서로 다른 사람의 급여,인센티브,입사일자가 된다.
컬럼은 자바의 변수와 비슷한거 같다.

SELECT sum(sal),deptno FROM emp

deptno에 min그룹함수를 씌워서 문법적인 문제는 해결했지만
그 값은 의미 없다.

SELECT sum(sal),min(deptno) FROM emp

부서별 급여의 합을 구하고 싶을땐 어떡하지

SELECT deptno,sum(sal)
 FROM emp 
 GROUP BY deptno

IF문을 사용할 수 있나요?

DECODE(A,B,'T','F')

SELECT decode(1,1,'T','F') FROM dual

우리회사에 근무하는 사원중에서 job salesman의 합
clerk의 합, 나머지는 기타의 합으로 출력하는 sql문을 작성하시오


SELECT sum(decode(job,'CLERK',sal,null)) as "clerk"
      ,sum(decode(job,'SALESMAN',sal,null)) as "salesman"
      ,sum(decode(job,'CLERK',null,decode(job,'SALESMAN',null,sal))) as "etc"
      ,sum(decode(job,null,null,sal)) 
      - (sum(decode(job,'CLERK',sal,null))
      +sum(decode(job,'SALESMAN',sal,null))) as "etc"
      ,sum(decode(job,'CLERK',null,'SALESMAN',null,sal))
    FROM emp
    
문제1:주당 강의시간과 학점이 같으면 '일반과목'을 반환하고
나머지는 '기타과목'이라고 출력하는 sql문을 작성하시오

문제2: 주당 강의시간과 학점이 같은 강의의 숫자를 알고 싶다.
어떡하지?
--반드시 decode로 풀어보세요

문제3:lec_time이 크면 '실험과목',lec_point가 크면 '기타과목' 둘이 같으면'일반'을 출력하는 select문을 작성해 보시오