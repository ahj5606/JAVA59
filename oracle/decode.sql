IF문을 사용할 수 있나요?

DECODE(A,B,'T','F')

SELECT decode(1,1,'T','F') FROM dual

우리회사에 근무하는 사원중에서 job salesman의 합
clerk의 합, 나머지는 기타의 합으로 출력하는 sql문을 작성하시오


SELECT sum(decode(job,'CLERK',sal,null)) as "clerk"
      ,sum(decode(job,'SALESMAN',sal,null)) as "salesman"
      ,sum(decode(job,'CLERK',null,decode(job,'SALESMAN',null,sal))) as "etc"
      ,sum(decode(job,null,null,sal)) 
      - (sum(decode(job,'CLERK',sal,null))
      +sum(decode(job,'SALESMAN',sal,null))) as "etc"
      ,sum(decode(job,'CLERK',null,'SALESMAN',null,sal))
    FROM emp



문제1:주당 강의시간과 학점이 같으면 '일반과목'을 반환하고
나머지는 '기타과목'이라고 출력하는 sql문을 작성하시오

문제2: 주당 강의시간과 학점이 같은 강의의 숫자를 알고 싶다.
어떡하지?
--반드시 decode로 풀어보세요

문제3:lec_time이 크면 '실험과목',lec_point가 크면 '기타과목' 둘이 같으면'일반'을 출력하는 select문을 작성해 보시오

SELECT *
    FROM LECTURE;
    
SELECT lec_id,decode(lec_time,lec_point,'일반과목','기타과목')
    FROM lecture;

SELECT count(decode(lec_time,lec_point,'참',null))
    FROM lecture;

SELECT 
    count(*)
    FROM lecture
    WHERE lec_time=lec_point;

decode는 크고 작음을 비교할수 없으므로 sign사용

SELECT sign(500-20),sign(20-500),sign(50-50)
FROM dual   
 
SELECT  lec_id,lec_time,lec_point, decode(sign(lec_time-lec_point),1,'실험과목'
                                                            ,-1,'기타과목'
                                                             ,0,'일반')
    FROM lectureT_LETITBE 
    
연습문제 
월요일엔 해당일자에 01을 붙여서 4자리 암호를 만들고,
화요일엔 11,수요일엔 21, 목요일엔 31, 금요일엔 41,
토요일엔 51, 일요일엔 61을 붙여서 4자리 암호를 만든다고 가정할떄
오늘의 암호를 출력하는 sql문 작성하시오.

SELECT CONCAT(to_char(sysdate,'dd'),
       decode(to_char(sysdate,'day'),'월요일',01
                                  ,'화요일',11
                                  ,'수요일',21
                                  ,'목요일',31
                                  ,'금요일',41
                                  ,'토요일',51
                                  ,'일요일',61)) as "오늘암호"
 from dual;
 
SELECT to_char(sysdate,'dd')||decode(to_char(sysdate,'day') ,'월요일',01
                                                        ,'화요일',11
                                                        ,'수요일',21
                                                        ,'목요일',31
                                                        ,'금요일',41
                                                        ,'토요일',51
                                                        ,'일요일',61) as "오늘암호"
from dual;

SELECT decode(to_char(sysdate,'day') ,'월요일',to_char(sysdate,'dd')||01
                                  ,'화요일',to_char(sysdate,'dd')||11
                                  ,'수요일',to_char(sysdate,'dd')||21
                                  ,'목요일',to_char(sysdate,'dd')||31
                                  ,'금요일',to_char(sysdate,'dd')||41
                                  ,'토요일',to_char(sysdate,'dd')||51
                                  ,'일요일',to_char(sysdate,'dd')||61) as "오늘암호"
from dual;