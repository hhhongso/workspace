CREATE TABLE 연산(x int, y number, z number(10, 3));
select * from 연산;
--고정형: 데이터 입력 후, 남은 메모리를 반환하지 않고 가지고 있는다.               int
--가변형: 데이터 입력 후, 남은 메모리는 반환한다.  ==> 메모리 효율을 위해 권장       number
--문자 char        char(고정형) / varchar2(가변형)
--문자열 String    char(고정형) / varchar2(가변형) ** 오라클은 문자와 문자열을 구분하지 않는다.('', "" => 모두'') 


CREATE TABLE DBTEST(
NAME VARCHAR2(15), AGE NUMBER, HEIGHT NUMBER(10,2), LOGTIME DATE);

insert into DBTEST(name, age, height, logtime) values ('김이름', 25, 165.567, sysdate);
insert into dbtest(name, age, height, logtime) values('kim', 30, 150.678, sysdate);
insert into dbtest(name, age) values('이이름', 55);
insert into dbtest(name, height) values('park', 49555.111);
insert into dbtest values('최이름', 20, 160.018888, sysdate);
insert into dbtest(name) values('진이름');
insert into dbtest(name) values('진분홍');
insert into dbtest(name) values('분홍신');
insert into dbtest(name) values('홍진신');

commit;

select * from dbtest;
select * from dbtest where name = '김이름';
select * from dbtest where age >= 20 and height >= 160; -- 셀렉 조건은 ,가 안되고 and

select * from dbtest where name like '%홍%';
select * from dbtest where name like '%홍';  -- %에 몇글자가 오든 상관없다.
select * from dbtest where name like '_홍%'; -- _ 자리에는 한글자만 온다. 

select * from dbtest where name = 'kim'; 
select * from dbtest where LOWER(name) = 'kim'; 
select * from dbtest where UPPER(name) = 'KIM'; 
-- 오라클은 대소문자 구분하지 않으나, 데이터 안에서는 구분한다. 데이터 kim != KIM; 

select * from dbtest where name like '%홍%' order by name desc; -- 정렬: where절 뒤에 order by 

update dbtest set age = age+1, height = height+1 where name = '최이름'; -- 업데이트 조건은 and가 안되고 ,
update dbtest set age = 1 where age is null;

drop table dbtest; 
select * from tab;
select * from dbtest;
flashback table dbtest to before drop; -- 드롭하고 나면 휴지조각이 생긴다. => 플래시백(복원) 가능, 레코드도 복원된다. 
purge recyclebin; -- 휴지통 비우기
drop table dbtest purge; -- 휴지통 거치지 않고 바로 삭제 => 플래시백 불가

--시퀀스
create sequence num increment by 2 start with 1 maxValue 9 cycle nocache; 
select num.nextVal from dual; 

create sequence num2 nocycle nocache;
drop sequence num;
drop sequence num2;


select * from dbtest;