--ex01
create or replace view v_view1
as select employee_id, last_name, salary, department_id from employees
where department_id = '90';

select*from v_view4;
delete from v_view1;

--Q01
create or replace view v_view2
as select employee_id as 사원번호, last_name, salary as 급여, department_id from employees
where salary between 5000 and 10000;
--ex02
update v_view2 set 급여 = 12000 where 사원번호 = 104;

--Q02
create or replace view v_view3 (사원번호, 사원명, 부서번호, 부서명)
as select employee_id, last_name, department_id, department_name from employees
join departments using (department_id)
where department_id in (10, 90)
order by employee_id asc;

--Q03
create or replace view v_view4 (사원번호, 사원명, 급여, 입사일, 부서명, 부서도시)
as select employee_id, last_name, to_char(trunc(salary, -3), '9,999,999')||'원', 
to_char(hire_date, 'YYYY"년" MM"월" DD"일"'), department_name, city from employees
left join departments using(department_id)
join locations using(location_id)
where department_id in (10,90)
order by employee_id asc;

--ex03
select*from v_view6;
delete from v_view6;
create or replace view v_view5
as select employee_id, last_name, job_id from employees where job_id = 'IT_PROG'
with read only;

--ex04
create or replace view v_view6
as select employee_id, last_name, email, hire_date, job_id from employees
where job_id = 'IT_PROG' with check option;

update v_view6 set last_name = 'Austina' where last_name = 'Austin';
insert into v_view6(employee_id, last_name, email, hire_date, job_id)
values(500,'kim','candy','2004-01-01','Sales'); 
update v_view6 set job_id='Sales' where employee_id=103;

--Q04
create table bookshop(
isbn varchar2(10) constraint PISBN primary key,
title varchar2(50) constraint CTIT not null, 
author varchar2(50),
price number, 
company varchar2(30)
);

insert into bookshop values('is001', '자바3일완성', '김자바', 25000, '야메루출판사');
insert into bookshop values('pa002', 'JSP달인되기', '이달인', 28000, '공갈닷컴');
insert into bookshop values('or003', '오라클무작정따라하기', '박따라', 23500, '야메루출판사');

select*from bookshop;

create table bookorder(
idx number primary key, 
isbn varchar2(10), constraint FKISBN foreign key(isbn) references bookshop,
--isbn varchar2(10) constraint FKISBN references bookshop(isbn),
qty number
);

create sequence idx_seq increment by 1 start with 1 nocache nocycle;
drop sequence idx_seq;

insert into bookorder values(idx_seq.nextval, 'is001', 2);
insert into bookorder values(idx_seq.nextval, 'or003', 3);
insert into bookorder values(idx_seq.nextval, 'pa002', 5);
insert into bookorder values(idx_seq.nextval, 'is001', 3);
insert into bookorder values(idx_seq.nextval, 'or003', 10);

select*from bookorder;
commit;

create or replace view bs_view
as select title 책제목, author 저자, sum(price*qty) as 총판매금액 from bookshop
join bookorder using(isbn)
group by (title, author)
with read only;
-- title로만 group by 시 : group by 시킨 것만 select 해온다.
-- ==> 책제목, 저자 모두 select해와야 하므로 두 개 모두 group by 되어야 함. 

select*from bs_view;

--ex05: view / inline
create or replace view v_view7 ("부서ID", "부서평균")
as select nvl(department_id, 5000), round(avg(salary),-2) from employees
group by department_id
order by 1 asc;

select*from v_view7;

select 부서ID, 부서평균 from 
(select nvl(department_id, 5000) "부서ID", round(avg(salary),-2) "부서평균" from employees
group by department_id
order by 1 asc);

--Q05_[1]: inline으로 
select 부서명, 최대급여
from (select department_name 부서명, max(salary) 최대급여 from employees
join departments using(department_id)
group by department_name);

--Q05_[2]: inline으로 
select 이름, 부서명, 최대급여
from (select last_name 이름, department_name 부서명, salary 최대급여 from employees
join departments using(department_id)
where (department_id, salary) in(select department_id, max(salary) from employees 
                                join departments using(department_id) group by department_id)
);

select last_name 이름, department_name 부서명, salary 최대급여 from employees 
join departments using(department_id)
where department_id = 100 and salary = 12008;

--이하 나의 허황된 시도들 
select last_name 이름, department_name 부서명, max(salary) 최대급여 from employees
join departments using(department_id)
group by (department_name, last_name)
having max(salary) in (select max(salary) from employees group by (department_id));

select department_id, max(salary) from employees group by department_id;

--ex06
select rownum, last_name, salary from (select last_name, nvl(salary,0) as salary from employees order by 2 desc)
where rownum <= 3;

--ex07
select rownum, last_name, salary from (select last_name, nvl(salary,0) as salary from employees order by 2 desc)
where rownum = 1;
--rownum 이용하여 최고급여 받는 사원 가져오기: rownum= 1외에, rownum=2와 같은 특정 행은 사용할 수 없음.

--ex08
select * from 
(select rownum, ceil(rownum/3) as page, temp.* 
from (select last_name, nvl(salary, 0) as salary from employees order by salary desc) temp)
where page = 2;

select *from 
(select rownum rn, temp.* 
from (select last_name, nvl(salary, 0) as salary from employees order by 2 desc) temp)
where rn between 4 and 6;

--Q06
select rownum, temp.* from 
(select last_name 사원명, department_name 부서명, to_char(salary*12+salary*12*nvl(commission_pct,0), 'L9,999,999') as "연   봉" from employees
join departments using (department_id) order by 3 asc) temp
where rownum <=5;

select last_name 사원명, department_name 부서명, to_char(salary*12+salary*12*nvl(commission_pct,0), 'L9,999,999') as "연   봉"
from (select rownum, temp.* 
from (select * from employees 
join departments using (department_id) order by salary asc) temp)
where rownum <=5;

grant all on employees to java;
