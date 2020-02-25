SELECT mem_id,mem_pw    
  FROM member     
 WHERE mem_id =:id
 


SELECT NVL((select 1 
from member where mem_id= :id),-1)
FROM dual

SELECT  DECODE((NVL((select 1 from member where mem_id= :id),-1)),1
            ,DECODE(select NVL((SELECT 2 FROM member where mem_id='apple' and mem_pw=:'123'),0),2,'환영합니다.','다시 확인하세요'),'아이디가 존재하지 않습니다')
 FROM dual


select NVL((SELECT 2 FROM member where mem_id=:id and mem_pw=:pw),0)
from dual






SELECT emp_name,hobby,NVL(hobby,'없음') FROM temp

select 1 from dual

SELECT NVL((select 1      from member where mem_id= :id),-1)     FROM dual

위 실행 결과가 없다면 어떤 의미가 되는거죠?
비번이 맞지 않은 경우임

SELECT 
     NVL((SELECT mem_name
           FROM member
          WHERE mem_id=:id
            AND mem_pw=:pw),0) mem_name
  FROM dual
  
 