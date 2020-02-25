CREATE TABLE dept3(
    deptno number(3) constraints dept3_no_pk primary key
   ,dname varchar2(30) not null
   ,loc varchar2(30) default '����'
)



drop table dept3

SELECT deptno,dname,loc from dept3

insert into dept3 values(10,'������','�λ�');

insert into dept3 values(20,'�ѹ���','����');

insert into dept3 values(30,'���ߺ�','��õ');

commit

select deptno from dept3

/*+ �� ��Ʈ���̶�� ��

select /*+index_desc(dept3 dept3_no_pk)*/ deptno from dept3

���̺� ������ pk�� �����ϸ� unique index�� �ڵ����� ����� �ش�.

SELECT deptno,dname FROM dept3
ORDER BY deptno desc

update dept3 set loc ='����' where deptno =20

delete from dept3 where dname = '���ߺ�'

���� ��Ʈ���� ��Ÿ�� �ְų� ������ ������ ���õȴ�.

select * from dept3

rollback