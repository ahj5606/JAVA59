SELECT sdate FROM SEOULTEMP WHERE SDATE BETWEEN '2010'||'%' AND '2019'||'%' order by sdate DESC

SELECT sysdate +1,sysdate-1 
  FROM dual
  
���ڿ� -> ��¥Ÿ������ ���� ����ȯ �Լ��� �ִ�.

TO_DATE()

SELECT TO_CHAR(sysdate,'YYYY'), TO_CHAR(sysdate,'MM')
  FROM dual
  
���� ���� ���ڿ��� �Ǿ��ִ� ���� ��¥Ÿ������ ��ȯ�ϱ�

SELECT TO_DATE(sdate'YYYY')
    FROM seoultemp
    WHERE sdate ='2019/12/25'
    
SELECT TO_CHAR(TO_DATE(sdate),'YYYY')
    FROM seoultemp
  WHERE sdate ='2019/12/25' OR sdate ='2017/12/25' OR sdate ='2018/12/25'
  
������ : =
�������� : LIKE,BETWEEN A AND B
  
SELECT DISTINCT(TO_CHAR(TO_DATE(sdate),'YYYY')) AS "year"
  FROM seoultemp 
 WHERE sdate >= '2010'||'%' 
   AND TO_CHAR(TO_DATE(sdate),'YYYY') <= '2019'||'%'
ORDER BY "year" asc


SELECT DISTINCT(TO_CHAR(TO_DATE(sdate),'YYYY')) ta_year
  FROM seoultemp 
 WHERE TO_CHAR(TO_DATE(sdate),'YYYY') > TO_CHAR(sysdate,'YYYY') -11
ORDER BY ta_year asc


SELECT DISTINCT(TO_CHAR(TO_DATE(sdate),'MM')) ta_year
  FROM seoultemp 
 WHERE TO_CHAR(TO_DATE(sdate),'YYYY') = :uyear
ORDER BY ta_year asc

select distinct(sdate) 
from seoultemp
where  TO_CHAR(TO_DATE(sdate),'YYYY') >=TO_CHAR(TO_DATE('2010/01/01'),'YYYY')


select sdate,mitemp,matemp 
from seoultemp 
where TO_CHAR(TO_DATE(sdate),'YYYY') = :uyear
 and TO_CHAR(TO_DATE(sdate),'MM') = :umonth
 
 select sdate,mitemp,matemp                      from seoultemp                                  where 1=1 TO_CHAR(TO_DATE(sdate),'YYYY') = '2020'    and TO_CHAR(TO_DATE(sdate),'MM') = '02'     