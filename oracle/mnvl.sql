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


select nvl(hobby,emp_name,'����') from temp

����� �����Լ�
����Ŭ �����Ǵ� �Լ�

nvl() : �Լ� - ����Ŭ �����Լ��� �Ķ���ʹ� �����Ǿ� ����
NVL�Լ��� �ش� �÷��� �� üũ�� �ؼ� ���� �ƴϸ� �ش� ���� ��ȯ
���̸� �ι�° �Ķ���͸� ��ȯ��.

SELECT NVL('�ȳ�','null�϶�'),NVL(NULL,'null�϶�') from dual

select * from baseball


delete from basebaGAME_NOGAME_NOll where game_no=48

select * from member

commit


