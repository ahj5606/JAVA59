
SELECT * FROM temp;

SELECT emp_name as "사원 명"
        ,(salary/18) as "홀수급여"
        ,(salary/18)*2 as "짝수급여"
FROM temp

SELECT round(123.567,2),round(123.345,2)
        ,round(123.340,0),round(123.345,-1)
    FROM dual

SELECT emp_name as "사원 명"
        ,round((salary/18),-1)||'원' as "홀수급여"
        ,round((salary/18)*2,-1)||'원' as "짝수급여"
FROM temp
-- round(숫자,자리) 해당 자리에서 반올림 -1 일의자리

SELECT 1||'원','$'||100 FROM dual

SELECT to_char(123456789,'999,999,999') FROM dual -- 9는숫자의 자리보다 크게 적어줘야함

SELECT emp_name as "사원 명"
        ,to_char(round((salary/18)),'999,999,999')||'원' as "홀수급여"
        ,to_char(round((salary/18)*2),'999,999,999')||'원' as "짝수급여"
FROM temp

--Temp자료중 hobby가 등산인 사원의 이름과 취미를 출력하는
--sql문 작성하시오.

SELECT emp_name as "사원이름",hobby as "취미"
    FROM temp
    WHERE hobby in('등산','낚시');
    
/*오라클에서도 제공되는 함수가 있다.
함수는 이름뒤에 괄호가 있다.
함수는 반드시 반환값이 있다.
*/

SELECT round(123.567,1) FROM dual

round(값,자리수) 두번째 자리에서 반올림

그룹함수도 제공된다.

SELECT sum(salary),to_char(sum(salary),'999,999,999')
       ,sum(salary/12),to_char(sum(salary/12),'999,999,999')
        from temp;

SELECT birth_date
FROM temp
WHERE  birth_date LIKE '%'||'15'||'%'

SELECT count(*)
from temp;

SELECT address as "주소", zipcode as "우편번호"
FROM zipcode_t
WHERE dong LIKE '%'||'당산동'||'%'