CREATE TABLE ����(x int, y number, z number(10, 3));
select * from ����;
--������: ������ �Է� ��, ���� �޸𸮸� ��ȯ���� �ʰ� ������ �ִ´�.               int
--������: ������ �Է� ��, ���� �޸𸮴� ��ȯ�Ѵ�.  ==> �޸� ȿ���� ���� ����       number
--���� char        char(������) / varchar2(������)
--���ڿ� String    char(������) / varchar2(������) ** ����Ŭ�� ���ڿ� ���ڿ��� �������� �ʴ´�.('', "" => ���'') 


CREATE TABLE DBTEST(
NAME VARCHAR2(15), AGE NUMBER, HEIGHT NUMBER(10,2), LOGTIME DATE);

insert into DBTEST(name, age, height, logtime) values ('���̸�', 25, 165.567, sysdate);
insert into dbtest(name, age, height, logtime) values('kim', 30, 150.678, sysdate);
insert into dbtest(name, age) values('���̸�', 55);
insert into dbtest(name, height) values('park', 49555.111);
insert into dbtest values('���̸�', 20, 160.018888, sysdate);
insert into dbtest(name) values('���̸�');
insert into dbtest(name) values('����ȫ');
insert into dbtest(name) values('��ȫ��');
insert into dbtest(name) values('ȫ����');

commit;

select * from dbtest;
select * from dbtest where name = '���̸�';
select * from dbtest where age >= 20 and height >= 160; -- ���� ������ ,�� �ȵǰ� and

select * from dbtest where name like '%ȫ%';
select * from dbtest where name like '%ȫ';  -- %�� ����ڰ� ���� �������.
select * from dbtest where name like '_ȫ%'; -- _ �ڸ����� �ѱ��ڸ� �´�. 

select * from dbtest where name = 'kim'; 
select * from dbtest where LOWER(name) = 'kim'; 
select * from dbtest where UPPER(name) = 'KIM'; 
-- ����Ŭ�� ��ҹ��� �������� ������, ������ �ȿ����� �����Ѵ�. ������ kim != KIM; 

select * from dbtest where name like '%ȫ%' order by name desc; -- ����: where�� �ڿ� order by 

update dbtest set age = age+1, height = height+1 where name = '���̸�'; -- ������Ʈ ������ and�� �ȵǰ� ,
update dbtest set age = 1 where age is null;

drop table dbtest; 
select * from tab;
select * from dbtest;
flashback table dbtest to before drop; -- ����ϰ� ���� ���������� �����. => �÷��ù�(����) ����, ���ڵ嵵 �����ȴ�. 
purge recyclebin; -- ������ ����
drop table dbtest purge; -- ������ ��ġ�� �ʰ� �ٷ� ���� => �÷��ù� �Ұ�

--������
create sequence num increment by 2 start with 1 maxValue 9 cycle nocache; 
select num.nextVal from dual; 

create sequence num2 nocycle nocache;
drop sequence num;
drop sequence num2;


select * from dbtest;