--ÇÑ±Û°¡»ç Ãâ·Â
SELECT * FROM t_letitbe WHERE mod(seq_vc,2)=0;

SELECT * FROM t_letitbe WHERE REGEXP_LIKE (words_vc, '[°¡-ÆR]');

SELECT * FROM t_letitbe WHERE NOT REGEXP_LIKE (words_vc, '[a-z]|[A-Z]');


--¿µ¾î°¡»ç¸¸ Ãâ·Â ÇÏ¼¼¿ä
MOD(ÆÄ¶ó¹ÌÅÍ1,ÆÄ¶ó¹ÌÅÍ2)

SELECT MOD(5,2),MOD(600,2),MOD(50) FROM dual

SELECT * FROM t_letitbe WHERE mod(TO_NUMBER(seq_vc),2)=1;

SELECT rownum rno , words_vc FROM t_letitbe WHERE NOT REGEXP_LIKE (words_vc, '[°¡-ÆR]');

SELECT rownum rno , words_vc FROM t_letitbe WHERE REGEXP_LIKE (words_vc, '[a-z]|[A-Z]');

--rownum¹øÈ£ºÙÀÌ±â UNION ALL Áßº¹Á¦°Å ¾ÈÇÔUNION Áßº¹Á¦°Å

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




seq_vd = varchar2Å¸ÀÔ 
¹®ÀÚ > ¼ýÀÚ 

SELECT TO_NUMBER(seq_vc) FROM t_letitbe ORDER BY TO_NUMBER(seq_vc) asc

SELECT TO_NUMBER(seq_vc) FROM t_letitbe ORDER BY LPAD(seq_vc,2,'0') asc --ÇÑÀÚ¸®¸¦ 2ÀÚ¸®·Î¸¸µé¾î¼­ ¿ÞÂÊ¿¡ 0 ºÙÀÌ±â 

SELECT * FROM t_letitbe

--ÀÚµ¿ Çüº¯È¯ÀÌ Áö¿øµÈ´Ù.
SELECT ename FROM emp WHERE empno ='7566'

