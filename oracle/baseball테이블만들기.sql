CREATE TABLE baseball(
    game_no number(5)
    ,game_seq number(2)
    ,game_date varchar2(30)
    ,input varchar2(10)
    ,hint varchar2(30)
    ,dap varchar2(10)
    ,score number(3)
    ,mem_id varchar2(30)
    ,constraint bgame_no_seq_pk primary key (game_no,game_seq)
    ,constraint mem_if_fk foreign key(mem_id) references member(mem_id)
)

������


select seq_baseball.nextval from dual


select * from member

edit baseball

insert into baseball(game_no, game_seq, game_date
                  ,input, hint, dap ,score, mem_id)
            values(seq_baseball.nextval,3,to_char(sysdate,'YYYY-MM-DD')
                  ,'267','1��1��',278,10,'apple')

commit
 
select * from baseball

���̵�� ����� ��� �������Ѿ� �Ѵ�.
�׸��� ó���Ѵ�.
and



SELECT mem_name
  FROM member
 WHERE mem_id = 'apple'
   AND mem_pw = '123'
   
select * from member;
   