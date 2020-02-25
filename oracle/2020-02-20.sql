CREATE TABLE dept3(
    deptno number(3) constraints dept3_no_pk primary key
   ,dname varchar2(30) not null
   ,loc varchar2(30) default '서울'
)



drop table dept3

SELECT deptno,dname,loc from dept3

insert into dept3 values(10,'영업부','부산');

insert into dept3 values(20,'총무부','서울');

insert into dept3 values(30,'개발부','인천');

commit

select deptno from dept3

/*+ 는 힌트문이라고 함

select /*+index_desc(dept3 dept3_no_pk)*/ deptno from dept3

테이블 생성시 pk를 지정하면 unique index를 자동으로 만들어 준다.

SELECT deptno,dname FROM dept3
ORDER BY deptno desc

update dept3 set loc ='대전' where deptno =20

delete from dept3 where dname = '개발부'

만일 힌트문에 오타가 있거나 에러가 있으면 무시된다.

select * from dept3

rollback