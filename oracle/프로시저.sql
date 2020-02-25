--로그인 처리를 위한 저장프로시저 작성해 보기
--생성하고 수정가능

create or replace procedure proc_login(u_id IN varchar2
                                    , u_pw IN varchar2
                                    , r_name OUT varchar2)
is
    r_status number; --변수선언(이름 타입 순)
begin
    SELECT NVL((SELECT 1 FROM member
                WHERE mem_id=u_id),-1) INTO r_status --결과값을 r_status에 대입
    FROM dual;
    if r_status=1 then
        SELECT NVL((SELECT mem_name||'님 환영합니다.'
                     FROM member
                    WHERE mem_id=u_id AND mem_pw=u_pw)
                    ,'비밀번호가 틀립니다.') INTO r_name
        FROM dual;
    elsif r_status=-1 then
         r_name:='아이디가 존재하지 않습니다.';
    end if;
       -- r_name:=r_status;
end; 

