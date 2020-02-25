SELECT sysdate +1 , sysdate-1 ,sysdate+2 FROM dual

날짜 타입이면 더하기와 뺴기 연산이 가능하다.

날짜와 총계라는 문자가 같이 와야한다.

타입을 맞춰야 할 때는 두 타입을 모두 수용할 수 있는 타입으로 해야한다.

계산식 오라클 , 자바 어디가 효율적일까? 

자원이 어디에 있는지

데이터가 오라클에 있으므로 어차피 select문으로 꺼내야하고
그 꺼낸 정보를 가공하는 것도 오라클 안에서 가능하니깐 처리된 결과를
한 번에 꺼내 화면에 출력하는 것이 더 효율적이다.

조인
0.카타시안의 곱 

1.equals 조인 -- 같은걸 찿아감

temp테이블에서 사원번호(temp) 사원명(temp) 부서명을(tdept)
함께 보고싶다. (tdept) 어떡하지?

select * from temp

select * from tdept

-- 부적합한 식별자 = select 문

SELECT e.emp_id , e.emp_name ,d.dept_name
  FROM temp e , tdept d               --카타시안의 곱 -경우의수가 모두 조회, 사실이 아닌값도 존재함. 모든 경우의 수가 나옴.
 WHERE e.dept_code = d.dept_code

SELECT e.emp_id , e.emp_name ,d.dept_name
  FROM temp e JOIN tdept d  
  ON e.dept_code = d.dept_code
             

2. non-equals조인
조인 조건이 '='이 아닌 다른 연산기호로 주어지는 경우

temp와 emp_leve을 이용해서 emp_level의 과장 직급의 연봉산한 연봉하한
범위 내에 드는 직원의 사번과 성명, 직급, salary를 출력하는
select문을 작성하시오.

SELECT * FROM emp_level

select * from temp

SELECT e.emp_name ,e.lev ,e.salary
 FROM temp e , emp_level l 
 WHERE  l.lev='과장' and  e.salary >=l.from_sal and e.salary<=l.to_sal

SELECT e.emp_name ,e.lev ,e.salary
 FROM temp e , emp_level l 
 WHERE  l.lev='과장' and e.salary between l.from_sal and l.to_sal

SELECT e.emp_name ,e.lev ,e.salary
 FROM temp e JOIN emp_level l 
 ON  l.lev='과장' and  e.salary >=l.from_sal and e.salary<=l.to_sal

3. outer조인
두 개 이상의 테이블 조인시 한쪽 테이블의 행에 대해서 다른쪽
테이블의 일치하는 행이 없더라도 다른 쪽 테이블의 행을 NULL로 하여
행을 리턴한다.
<-> equals-join 두 개이상의 집합에서 양쪽 모두에 있는 로우를 보여주세요.

select 컬럼1 , 컬럼2 from 테이블1 ,테이블2
where 테이블1.컬럼 = 테이블2.컬럼(+) -- null값이 존재하는곳에 (+)를 사용 

select * from emp

select * from dept

select e.ename , d.deptno 
  from emp e , dept d 
 where e.deptno(+)=d.deptno

없는값 null로 처리하기

아래에서 두 집합을 사용한 이유는 사원집합안에 부서명이 없기 때문이다.
그러나 조인조건이 없으면 모든 경우의 수가 조회되니까 ...
가지의 경우의 수가 나온다. - 카타시안곱 :묻지마 조인
카타시안의 곱에는 의미 없는 값들이 들어 있다.
그래서 보통 데이터를 복제하는데 사용하거나 소계, 총계를 구하는
코드에서 사용되는 경우가 많다.

select e.ename , d.deptno 
  from emp e , dept d 
 where e.deptno(+)=d.deptno

각 사원의 이름 , salary, 연봉상한금액 , 연봉하한금액을
보고자 한다.
temp와 emp_leve을 조인하여 결과를 보여주되
만일 연봉의 상하한이 등록되어 있지  않은 '수습'사원은 
성명,salary 까지만 이라도 나올 수 있도록 sql 문을 작성하시오.

SELECT e.emp_name ,e.salary,e.lev , le.to_sal , le.from_sal 
  FROM temp e, emp_level le 
 WHERE e.lev = le.lev(+)



4. self 조인
    



SELECT e.emp_id , e.emp_name ,d.dept_name
  FROM temp e , tdept d 
 WHERE e.dept_code = d.dept_code