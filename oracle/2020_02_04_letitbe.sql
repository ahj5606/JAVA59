--�ѱ۰��� ���
SELECT * FROM t_letitbe WHERE mod(seq_vc,2)=0;

SELECT * FROM t_letitbe WHERE REGEXP_LIKE (words_vc, '[��-�R]');

SELECT * FROM t_letitbe WHERE NOT REGEXP_LIKE (words_vc, '[a-z]|[A-Z]');


--����縸 ��� �ϼ���
MOD(�Ķ����1,�Ķ����2)

SELECT MOD(5,2),MOD(600,2),MOD(50) FROM dual

SELECT * FROM t_letitbe WHERE mod(TO_NUMBER(seq_vc),2)=1;

SELECT rownum rno , words_vc FROM t_letitbe WHERE NOT REGEXP_LIKE (words_vc, '[��-�R]');

SELECT rownum rno , words_vc FROM t_letitbe WHERE REGEXP_LIKE (words_vc, '[a-z]|[A-Z]');

--rownum��ȣ���̱� UNION ALL �ߺ����� ����UNION �ߺ�����

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




seq_vd = varchar2Ÿ�� 
���� > ���� 

SELECT TO_NUMBER(seq_vc) FROM t_letitbe ORDER BY TO_NUMBER(seq_vc) asc

SELECT TO_NUMBER(seq_vc) FROM t_letitbe ORDER BY LPAD(seq_vc,2,'0') asc --���ڸ��� 2�ڸ��θ��� ���ʿ� 0 ���̱� 

SELECT * FROM t_letitbe

--�ڵ� ����ȯ�� �����ȴ�.
SELECT ename FROM emp WHERE empno ='7566'

