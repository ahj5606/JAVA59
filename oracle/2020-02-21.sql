SELECT * FROM test02 

--9��3�� ���� �޷� ������ ȯ���� ���

SELECT  rownum main_rno, cdate,amt FROM test02
  
SELECT rownum sub_rno,cdate,crate FROM test02

SELECT rownum rno FROM emp 
  
SELECT m.cdate as "����",m.amt as "�޷��ݾ�" , s.crate as "ȯ��" ,TO_CHAR((m.amt*s.crate),'999,999,999')||'��' as "��ȭ�ݾ�"
  FROM (SELECT  rownum main_rno, cdate,amt FROM test02) m ,(SELECT rownum sub_rno,cdate,crate FROM test02) s
 WHERE s.sub_rno = m.main_rno-1
 
 
SELECT * FROM T_ORDERBASKET
  
SELECT indate_vc as "�Ǹų�¥",sum(qty_nu)||'��' as "�ǸŰ���",sum(qty_nu*price_nu)||'��' as "�ǸŰ���"
  FROM t_orderbasket
 GROUP BY indate_vc
UNION ALL
SELECT '�Ѱ�', sum(qty_nu)||'��',sum(qty_nu*price_nu)||'��'
 FROM t_orderbasket
 
���̺� ���� �״���� ����� ������ �ʴ´� - ���� ����ڵ���

�ζ��� ��(InLine View) -FROM �� �Ʒ� SELECT�� ������
�� : ��� ���̺��� �ƴϴ�.
��� SELECT���̴�.
���� ����ұ��? - ����� �䱸�ϴ� �������� ����ؾ� �Ѵٸ�?
������ �������� ���Ǳ⵵ �մϴ�.
�÷����� �״�� �������� �ʱ� ���ؼ� .....
���� �÷����� Ȥ�� ��Ī������ ��ġ ������ �����ϴ� �÷����ΰ�ó�� ����� �� �ִ�.

--distinct�� ����Ŭ �����Լ� �̹Ƿ� �ǵ����̸� group by ������� 
SELECT indate_vc "�Ǹų�¥"
      ,SUM(DECODE(indate_vc,indate_vc,qty_nu))||'��' "�ǸŰ���"
      ,SUM(DECODE(indate_vc,indate_vc,qty_nu*price_nu))||'��' "�ǸŰ���"
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

īŸ�þȰ� - �����͸� �����ϰ� ���� �� ����غ���.


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
 
 SELECT indate_vc "�Ǹų�¥"
      ,SUM(DECODE(indate_vc,indate_vc,qty_nu))||'��' "�ǸŰ���"
      ,SUM(DECODE(indate_vc,indate_vc,qty_nu*price_nu))||'��' "�ǸŰ���"
    FROM t_orderbasket
  group by indate_vc
  
SELECT decode(rno,1,indate_vc,2,'�Ѱ�')
 FROM t_orderbasket ,(SELECT rownum rno FROM dept WHERE rownum<3) b
GROUP BY decode(rno,1,indate_vc,2,'�Ѱ�')
ORDER BY decode(rno,1,indate_vc,2,'�Ѱ�') ASC

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
SELECT '�Ѱ�',sum(qty_nu),sum(qty_nu*price_nu)
  FROM t_orderbasket
 -------------------------------------------------------------------------------- 
  
  SELECT 
       indate_vc,sum(qty_nu),sum(qty_nu*price_nu)
  FROM t_orderbasket
GROUP BY ROLLUP((indate_vc))

------------------------------------------------------------

SELECT
      decode(b.rno,1,a.indate_vc,2,'�Ѱ�') as "�Ǹų�¥"
     ,sum(a.qty_nu)||'��' as "�ǸŰ���"
     ,sum(a.qty_nu*a.price_nu)||'��'  as "�ǸŰ���"
  FROM t_orderbasket a
      ,(SELECT rownum rno from t_orderbasket where rownum<3) b
  GROUP BY decode(rno,1,indate_vc,2,'�Ѱ�') 
  ORDER BY decode(rno,1,indate_vc,2,'�Ѱ�') ASC
  
 --------------------------------------------------------
 
SELECT indate_vc,gubun_vc,sum(qty_nu),sum(price_nu)
  FROM t_orderbasket
  group by indate_vc,gubun_vc


SELECT decode(rno,1,indate_vc,2,'�Ұ�',3,'�Ѱ�') "�Ǹų�¥"
     ,decode(rno,1,gubun_vc,2,gubun_vc,3,null) "��ǰ����"
     ,sum(qty_nu)||'��' "�ǸŰ���"
     ,sum(price_nu)||'��' "�ǸŰ���"
  FROM t_orderbasket a
      ,(SELECT rownum rno from t_orderbasket where rownum<4) b
GROUP BY decode(rno,1,indate_vc,2,'�Ұ�',3,'�Ѱ�'),decode(rno,1,gubun_vc,2,gubun_vc,3,null)
ORDER BY decode(rno,1,indate_vc,2,'�Ұ�',3,'�Ѱ�')
 



SELECT
      decode(b.rno,1,a.indate_vc,2,'�Ѱ�') as �Ǹų�¥
     ,sum(a.qty_nu)||'��' as �ǸŰ���
     ,sum(a.qty_nu*a.price_nu)||'��'  as �ǸŰ���
  FROM t_orderbasket a
      ,(SELECT rownum rno from t_orderbasket where rownum<3) b
  GROUP BY decode(rno,1,indate_vc,2,'�Ѱ�') 
  ORDER BY decode(rno,1,indate_vc,2,'�Ѱ�') ASC   --ORDER BY�� 2�������̹Ƿ� �ӵ��� ���ϵ�

--DECODE ������ FROM���� ������ ��� ������ ��밡����.

SELECT
      decode(b.rno,1,a.indate_vc,2,'�Ѱ�') as "�Ǹų�¥" ,SUM(qty_nu),sum(qty_nu*price_nu)
  FROM t_orderbasket a
      ,(SELECT rownum rno from t_orderbasket where rownum<3) b
  GROUP BY decode(rno,1,indate_vc,2,'�Ѱ�') 
  ORDER BY decode(rno,1,indate_vc,2,'�Ѱ�') ASC   