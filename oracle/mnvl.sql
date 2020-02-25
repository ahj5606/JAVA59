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
     NVL2((SELECT mem_name 
           FROM member
          WHERE mem_id=:id
            AND mem_pw=:pw)
                ,(select mem_id from member where mem_id=:id and mem_pw=:pw)
                ,0) mem_name
  FROM dual
  
  
SELECT * FROM BASEBALL

select seq_baseball.currval from dual

select seq_baseball.nextval from dual


select nvl(hobby,emp_name,'없음') from temp

사용자 정의함수
오라클 제공되는 함수

nvl() : 함수 - 오라클 제공함수로 파라미터는 결정되어 있음
NVL함수는 해당 컬럼의 널 체크를 해서 널이 아니면 해당 값을 반환
널이면 두번째 파라미터를 반환함.

SELECT NVL('안녕','null일때'),NVL(NULL,'null일때') from dual

select * from baseball


delete from basebaGAME_NOGAME_NOll where game_no=48

select * from member

commit


