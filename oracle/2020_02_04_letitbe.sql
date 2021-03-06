--한글가사 출력
SELECT * FROM t_letitbe WHERE mod(seq_vc,2)=0;

SELECT * FROM t_letitbe WHERE REGEXP_LIKE (words_vc, '[가-힣]');

SELECT * FROM t_letitbe WHERE NOT REGEXP_LIKE (words_vc, '[a-z]|[A-Z]');


--영어가사만 출력 하세요
MOD(파라미터1,파라미터2)

SELECT MOD(5,2),MOD(600,2),MOD(50) FROM dual

SELECT * FROM t_letitbe WHERE mod(TO_NUMBER(seq_vc),2)=1;

SELECT rownum rno , words_vc FROM t_letitbe WHERE NOT REGEXP_LIKE (words_vc, '[가-힣]');

SELECT rownum rno , words_vc FROM t_letitbe WHERE REGEXP_LIKE (words_vc, '[a-z]|[A-Z]');

--rownum번호붙이기 UNION ALL 중복제거 안함UNION 중복제거

SELECT rownum rno , words_vc
  FROM t_letitbe
WHERE MOD(TO_NUMBER(seq_vc),2)=1
UNION 
SELECT rownum rno , words_vc
  FROM t_letitbe
WHERE MOD(TO_NUMBER(seq_vc),2)=1

SELECT seq_vc , decode(mod(seq_vc,2),1,words_vc,null)
  FROM t_letitbe
union all
SELECT seq_vc , decode(mod(seq_vc,2),0,words_vc,null)
  FROM t_letitbe

SELECT
        seq_vc ,MAX(A)
    FROM (
SELECT seq_vc , decode(mod(seq_vc,2),1,words_vc,null) A
FROM t_letitbe
union all
SELECT seq_vc , decode(mod(seq_vc,2),0,words_vc,null) A
FROM t_letitbe
)
GROUP BY seq_vc ORDER BY TO_NUMBER(seq_vc) asc



SELECT deptno,sum(sal),count(deptno) FROM emp
GROUP BY deptno




seq_vd = varchar2타입 
문자 > 숫자 

SELECT TO_NUMBER(seq_vc) FROM t_letitbe ORDER BY TO_NUMBER(seq_vc) asc

SELECT TO_NUMBER(seq_vc) FROM t_letitbe ORDER BY LPAD(seq_vc,2,'0') asc --한자리를 2자리로만들어서 왼쪽에 0 붙이기 

SELECT * FROM t_letitbe

--자동 형변환이 지원된다.
SELECT ename FROM emp WHERE empno ='7566'

