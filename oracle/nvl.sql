SELECT mem_id,mem_pw    
  FROM member     
 WHERE mem_id =:id
 


SELECT NVL((select 1 
from member where mem_id= :id),-1)
FROM dual

SELECT  DECODE((NVL((select 1 from member where mem_id= :id),-1)),1
            ,DECODE(select NVL((SELECT 2 FROM member where mem_id='apple' and mem_pw=:'123'),0),2,'ȯ���մϴ�.','�ٽ� Ȯ���ϼ���'),'���̵� �������� �ʽ��ϴ�')
 FROM dual


select NVL((SELECT 2 FROM member where mem_id=:id and mem_pw=:pw),0)
from dual






SELECT emp_name,hobby,NVL(hobby,'����') FROM temp

select 1 from dual

SELECT NVL((select 1      from member where mem_id= :id),-1)     FROM dual

�� ���� ����� ���ٸ� � �ǹ̰� �Ǵ°���?
����� ���� ���� �����

SELECT 
     NVL((SELECT mem_name
           FROM member
          WHERE mem_id=:id
            AND mem_pw=:pw),0) mem_name
  FROM dual
  
 