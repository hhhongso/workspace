create or replace view v_view1
as select employee_id, last_name, salary, department_id from employees
where department_id = '90';

select*from v_view4;
delete from v_view1;

create or replace view v_view2
as select employee_id as �����ȣ, last_name, salary as �޿�, department_id from employees
where salary between 5000 and 10000;

update v_view2 set �޿� = 12000 where �����ȣ = 104;

create or replace view v_view3 (�����ȣ, �����, �μ���ȣ, �μ���)
as select employee_id, last_name, department_id, department_name from employees
join departments using (department_id)
where department_id in (10, 90)
order by employee_id asc;

create or replace view v_view4 (�����ȣ, �����, �޿�, �Ի���, �μ���, �μ�����)
as select employee_id, last_name, to_char(trunc(salary, -3), '9,999,999')||'��', 
to_char(hire_date, 'YYYY"��" MM"��" DD"��"'), department_name, city from employees
left join departments using(department_id)
join locations using(location_id)
where department_id in (10,90)
order by employee_id asc;