--�α��� ó���� ���� �������ν��� �ۼ��� ����
--�����ϰ� ��������

create or replace procedure proc_login(u_id IN varchar2
                                    , u_pw IN varchar2
                                    , r_name OUT varchar2)
is
    r_status number; --��������(�̸� Ÿ�� ��)
begin
    SELECT NVL((SELECT 1 FROM member
                WHERE mem_id=u_id),-1) INTO r_status --������� r_status�� ����
    FROM dual;
    if r_status=1 then
        SELECT NVL((SELECT mem_name||'�� ȯ���մϴ�.'
                     FROM member
                    WHERE mem_id=u_id AND mem_pw=u_pw)
                    ,'��й�ȣ�� Ʋ���ϴ�.') INTO r_name
        FROM dual;
    elsif r_status=-1 then
         r_name:='���̵� �������� �ʽ��ϴ�.';
    end if;
       -- r_name:=r_status;
end; 

