SELECT * FROM test02 

--9월3일 결제 달러 이전날 환율로 계산

SELECT  rownum main_rno, cdate,amt FROM test02
  
SELECT rownum sub_rno,cdate,crate FROM test02

SELECT rownum rno FROM emp 
  
SELECT m.cdate as "일자",m.amt as "달러금액" , s.crate as "환율" ,TO_CHAR((m.amt*s.crate),'999,999,999')||'원' as "한화금액"
  FROM (SELECT  rownum main_rno, cdate,amt FROM test02) m ,(SELECT rownum sub_rno,cdate,crate FROM test02) s
 WHERE s.sub_rno = m.main_rno-1
 
 
SELECT * FROM T_ORDERBASKET
  
SELECT indate_vc as "판매날짜",sum(qty_nu)||'개' as "판매개수",sum(qty_nu*price_nu)||'원' as "판매가격"
  FROM t_orderbasket
 GROUP BY indate_vc
UNION ALL
SELECT '총계', sum(qty_nu)||'개',sum(qty_nu*price_nu)||'원'
 FROM t_orderbasket
 
테이블 생긴 그대로의 모습을 원하지 않는다 - 업무 담당자들이

인라인 뷰(InLine View) -FROM 절 아래 SELECT문 있으면
뷰 : 뷰는 테이블이 아니다.
뷰는 SELECT문이다.
언제 사용할까요? - 담당자 요구하는 내용으로 출력해야 한다면?
보안의 목적으로 사용되기도 합니다.
컬럼명을 그대로 노출하지 않기 위해서 .....
사용된 컬럼명을 혹은 별칭까지도 마치 실제로 존재하는 컬럼명인것처럼 사용할 수 있다.

--distinct는 오라클 지원함수 이므로 되도록이면 group by 절을사용 
SELECT indate_vc "판매날짜"
      ,SUM(DECODE(indate_vc,indate_vc,qty_nu))||'개' "판매개수"
      ,SUM(DECODE(indate_vc,indate_vc,qty_nu*price_nu))||'원' "판매가격"
    FROM t_orderbasket
  group by indate_vc

SELECT sum(decode(job,'CLERK',sal,null))
 from emp
 
SELECT deptno from dept

SELECT rownum rno FROM emp
WHERE rownum<3

SELECT deptno ,rno
 FROM dept,(SELECT rownum rno FROM emp
            WHERE rownum<3) b

카타시안곱 - 데이터를 복제하고 싶을 떄 사용해봐요.


SELECT decode(rno,1,deptno,2,0), rno
 FROM dept,(SELECT rownum rno FROM emp
            WHERE rownum<3) b

SELECT decode(rno,1,max(deptno),2,0), rno
 FROM dept,(SELECT rownum rno FROM emp
            WHERE rownum<3) b
GROUP BY rno

SELECT deptno ,rno
 FROM dept,(SELECT rownum rno FROM emp
            WHERE rownum<3) b
 
 SELECT indate_vc "판매날짜"
      ,SUM(DECODE(indate_vc,indate_vc,qty_nu))||'개' "판매개수"
      ,SUM(DECODE(indate_vc,indate_vc,qty_nu*price_nu))||'원' "판매가격"
    FROM t_orderbasket
  group by indate_vc
  
SELECT decode(rno,1,indate_vc,2,'총계')
 FROM t_orderbasket ,(SELECT rownum rno FROM dept WHERE rownum<3) b
GROUP BY decode(rno,1,indate_vc,2,'총계')
ORDER BY decode(rno,1,indate_vc,2,'총계') ASC

SELECT 
       indate_vc,qty_nu,price_nu
  FROM t_orderbasket
 WHERE indate_vc='20040601'
 
 SELECT 
       sum(qty_nu)
  FROM t_orderbasket
 WHERE indate_vc='20040601'
 
SELECT 
       indate_vc,sum(qty_nu)
  FROM t_orderbasket
 WHERE indate_vc='20040601'
GROUP BY indate_vc

SELECT 
       max(indate_vc),sum(qty_nu)
  FROM t_orderbasket
 WHERE indate_vc='20040601'
 
SELECT 
       max(indate_vc),sum(qty_nu),sum(qty_nu*price_nu)
  FROM t_orderbasket
-----------------------------------------------------------
SELECT 
       indate_vc,sum(qty_nu),sum(qty_nu*price_nu)
  FROM t_orderbasket
GROUP BY indate_vc
UNION ALL
SELECT '총계',sum(qty_nu),sum(qty_nu*price_nu)
  FROM t_orderbasket
 -------------------------------------------------------------------------------- 
  
  SELECT 
       indate_vc,sum(qty_nu),sum(qty_nu*price_nu)
  FROM t_orderbasket
GROUP BY ROLLUP((indate_vc))

------------------------------------------------------------

SELECT
      decode(b.rno,1,a.indate_vc,2,'총계') as "판매날짜"
     ,sum(a.qty_nu)||'개' as "판매개수"
     ,sum(a.qty_nu*a.price_nu)||'원'  as "판매가격"
  FROM t_orderbasket a
      ,(SELECT rownum rno from t_orderbasket where rownum<3) b
  GROUP BY decode(rno,1,indate_vc,2,'총계') 
  ORDER BY decode(rno,1,indate_vc,2,'총계') ASC
  
 --------------------------------------------------------
 
SELECT indate_vc,gubun_vc,sum(qty_nu),sum(price_nu)
  FROM t_orderbasket
  group by indate_vc,gubun_vc


SELECT decode(rno,1,indate_vc,2,'소계',3,'총계') "판매날짜"
     ,decode(rno,1,gubun_vc,2,gubun_vc,3,null) "물품구분"
     ,sum(qty_nu)||'개' "판매개수"
     ,sum(price_nu)||'원' "판매가격"
  FROM t_orderbasket a
      ,(SELECT rownum rno from t_orderbasket where rownum<4) b
GROUP BY decode(rno,1,indate_vc,2,'소계',3,'총계'),decode(rno,1,gubun_vc,2,gubun_vc,3,null)
ORDER BY decode(rno,1,indate_vc,2,'소계',3,'총계')
 



SELECT
      decode(b.rno,1,a.indate_vc,2,'총계') as 판매날짜
     ,sum(a.qty_nu)||'개' as 판매개수
     ,sum(a.qty_nu*a.price_nu)||'원'  as 판매가격
  FROM t_orderbasket a
      ,(SELECT rownum rno from t_orderbasket where rownum<3) b
  GROUP BY decode(rno,1,indate_vc,2,'총계') 
  ORDER BY decode(rno,1,indate_vc,2,'총계') ASC   --ORDER BY는 2차가공이므로 속도는 저하됨

--DECODE 문장은 FROM절을 제외한 모든 곳에서 사용가능함.

SELECT
      decode(b.rno,1,a.indate_vc,2,'총계') as "판매날짜" ,SUM(qty_nu),sum(qty_nu*price_nu)
  FROM t_orderbasket a
      ,(SELECT rownum rno from t_orderbasket where rownum<3) b
  GROUP BY decode(rno,1,indate_vc,2,'총계') 
  ORDER BY decode(rno,1,indate_vc,2,'총계') ASC   