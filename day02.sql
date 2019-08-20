select last_name, department_id, hire_date from employees order by 2 desc, 3 asc;

--ex01
select last_name as 이름, salary*12 as 연봉 from employees order by 연봉 desc;

--ex01
select employee_id, last_name, department_id from employees where upper(last_name) = 'HIGGINS';

--ex02
select mod(10,3) from dual;
select round(35765.357, -2) from dual;
select trunc(35765.357, 2) from dual;

--ex05
select concat('hello', ' world') from dual;

--ex06
create table text(
str1 char(20),
str2 varchar2(20));

insert into text(str1, str2) values('angel', 'angel');
insert into text(str1, str2) values('사천사', '사천사');
select lengthb(str1), lengthb(str2) from text;
select length(str1), length(str2) from text;

--ex07
select length('korea') from dual;
select lengthB('코리아') from dual;

--ex08
select instr('Hello World', 'W') from dual;
select instr('Hello World', 'W',-1) from dual;

--ex09
select substr('I am so happy', 9, 2) from dual;

--Q02
select last_name, employee_id from employees;
select concat (first_name, last_name) from employees;
select length(last_name) from employees;
select substr(last_name, length(last_name)) from employees;
select concat (first_name, ' ' || last_name) as 이름, employee_id, length(concat (first_name, concat(' ',last_name))) as 이름길이 from employees where substr(last_name, -1, 1) = 'n';

--ex10
select width_bucket(74, 0, 100, 10) from dual;

--ex11
select ltrim('       Hello world') from dual;
select rtrim('test     ') || 'exam' from dual;

--ex12
select sysdate from dual;
select to_char(sysdate, 'YYYY"년" MM"월" DD"일"') as 날짜 from dual;
select to_char(sysdate, 'HH24"시" MI"분" SS"초"') as 시간 from dual;

--ex13
select add_months(sysdate, 4) from dual;

--ex14
select last_day(sysdate) from dual;

--Q3
select (last_day(sysdate) - sysdate) as 남은날짜 from dual;