--ex01
create or replace view v_view1
as select employee_id, last_name, salary, department_id from employees
where department_id = '90';

select*from v_view4;
delete from v_view1;

--Q01
create or replace view v_view2
as select employee_id as �����ȣ, last_name, salary as �޿�, department_id from employees
where salary between 5000 and 10000;
--ex02
update v_view2 set �޿� = 12000 where �����ȣ = 104;

--Q02
create or replace view v_view3 (�����ȣ, �����, �μ���ȣ, �μ���)
as select employee_id, last_name, department_id, department_name from employees
join departments using (department_id)
where department_id in (10, 90)
order by employee_id asc;

--Q03
create or replace view v_view4 (�����ȣ, �����, �޿�, �Ի���, �μ���, �μ�����)
as select employee_id, last_name, to_char(trunc(salary, -3), '9,999,999')||'��', 
to_char(hire_date, 'YYYY"��" MM"��" DD"��"'), department_name, city from employees
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

insert into bookshop values('is001', '�ڹ�3�Ͽϼ�', '���ڹ�', 25000, '�߸޷����ǻ�');
insert into bookshop values('pa002', 'JSP���εǱ�', '�̴���', 28000, '��������');
insert into bookshop values('or003', '����Ŭ�����������ϱ�', '�ڵ���', 23500, '�߸޷����ǻ�');

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
as select title å����, author ����, sum(price*qty) as ���Ǹűݾ� from bookshop
join bookorder using(isbn)
group by (title, author)
with read only;
-- title�θ� group by �� : group by ��Ų �͸� select �ؿ´�.
-- ==> å����, ���� ��� select�ؿ;� �ϹǷ� �� �� ��� group by �Ǿ�� ��. 

select*from bs_view;

--ex05: view / inline
create or replace view v_view7 ("�μ�ID", "�μ����")
as select nvl(department_id, 5000), round(avg(salary),-2) from employees
group by department_id
order by 1 asc;

select*from v_view7;

select �μ�ID, �μ���� from 
(select nvl(department_id, 5000) "�μ�ID", round(avg(salary),-2) "�μ����" from employees
group by department_id
order by 1 asc);

--Q05_[1]: inline���� 
select �μ���, �ִ�޿�
from (select department_name �μ���, max(salary) �ִ�޿� from employees
join departments using(department_id)
group by department_name);

--Q05_[2]: inline���� 
select �̸�, �μ���, �ִ�޿�
from (select last_name �̸�, department_name �μ���, salary �ִ�޿� from employees
join departments using(department_id)
where (department_id, salary) in(select department_id, max(salary) from employees 
                                join departments using(department_id) group by department_id)
);

select last_name �̸�, department_name �μ���, salary �ִ�޿� from employees 
join departments using(department_id)
where department_id = 100 and salary = 12008;

--���� ���� ��Ȳ�� �õ��� 
select last_name �̸�, department_name �μ���, max(salary) �ִ�޿� from employees
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
--rownum �̿��Ͽ� �ְ�޿� �޴� ��� ��������: rownum= 1�ܿ�, rownum=2�� ���� Ư�� ���� ����� �� ����.

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
(select last_name �����, department_name �μ���, to_char(salary*12+salary*12*nvl(commission_pct,0), 'L9,999,999') as "��   ��" from employees
join departments using (department_id) order by 3 asc) temp
where rownum <=5;

select last_name �����, department_name �μ���, to_char(salary*12+salary*12*nvl(commission_pct,0), 'L9,999,999') as "��   ��"
from (select rownum, temp.* 
from (select * from employees 
join departments using (department_id) order by salary asc) temp)
where rownum <=5;

grant all on employees to java;
