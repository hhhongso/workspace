create table user1(
idx number primary key, 
id varchar2(10) unique, 
name varchar2(10) not null,
phone   varchar2(15),
address varchar2(50),
score number(6, 2) check (score between 0 and 100),
subject_code number(5),
hire_date date default sysdate, 
marriage char(1) default 'N' check(marriage in ('Y', 'N'))
);

select constraint_name, constraint_type from user_constraints where table_name = 'USER2'; 
--�ҹ��� �ȵ�? constraints �˻������� 

--������ �������� �ִ� �÷��� �������Ǹ� �߰��ϱ� ?
alter table user2 modify id constraint UNIQID unique;
commit;

insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage)
values(1,'aaa','kim','010-000-0000','����',75,100,'2010-08-01','Y');

insert into user1(idx,id,name,phone,address,score,subject_code,hire_date,marriage)
values(2,'bbb','lee','010-000-0000','����',100,100,'2010-08-01','I');

commit;
select*from user2;
desc user1;

alter table user1 rename to user2; 
alter table user2 add tel varchar2(10); 
alter table user2 add constraint TELUNIQ unique(tel);

select constraint_name, constraint_type from user_constraints where table_name='USER2';

alter table user2 modify tel varchar2(2);
--modify  �ϱ� ���� �÷��� �ݵ�� ����־�� �Ѵ�. 

alter table user2 drop column tel;

create sequence idx_seq increment by 2 start with 1 maxvalue 10 nocycle nocache;
select idx_seq.currval from dual;

--ex20
create table book(
no number primary key, 
subject varchar2(50),
price number, 
year date
);

create sequence no_seq increment by 1 start with 1 nocycle nocache;

insert into book(no,subject,price,year)values(no_seq.nextval,'����Ŭ ������ �����ϱ�',10000,sysdate);
select*from book;

create table book2 as select*from book where 1=0;
select*from book3;
select constraint_name, constraint_type, search_condition from user_constraints where table_name = 'BOOK2';

create table book3(no2, subject2, price2, year2)
as select*from book where price = 10000;

create table dept(
deptno number constraint DNO primary key,
dname varchar2(30) constraint DNAME not null
);

create table emp(
empno number constraint ENO primary key, 
ename varchar2(30) constraint ENAME not null,
deptno number, constraint FKNO foreign key(deptno) references dept on delete set null
);

insert into dept(deptno,dname) values(10,'���ߺ�');
insert into dept(deptno,dname) values(20,'������');
insert into dept(deptno,dname) values(30,'������');
insert into dept(deptno,dname) values(40,'�λ��');
select *from dept;

insert into emp(empno, ename, deptno) values(100,'��ȣ��',10);
insert into emp(empno, ename, deptno) values(101,'������',20);
insert into emp(empno, ename, deptno) values(102,'���缮',30); 

insert into emp(empno, ename, deptno) values(103,'��ȿ��',40);
insert into emp(empno, ename) values(105,'�嵿��');
select *from emp;

commit;
rollback;
delete from dept;

delete from dept where deptno = '40';

update emp set ename = '����' where ename = '��ȿ��';