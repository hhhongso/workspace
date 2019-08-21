--ex05
SELECT EMPLOYEE_ID, EMPLOYEES.DEPARTMENT_ID, DEPARTMENT_NAME FROM EMPLOYEES, DEPARTMENTS 
WHERE EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID;

select e.employee_id, e.department_id, d.department_name from employees e, departments d
where e.department_id = d.department_id;

select employee_id, department_id, department_name from employees join departments using(department_id);
--Q02
select department_id, city from departments join locations using(location_id);

select d.department_id, l.city from departments d, locations l
where d.location_id = l.location_id;
--ex06
select last_name, department_id, department_name from employees left join departments using(department_id);
--ex07
select last_name, department_id, department_name from employees right join departments using(department_id);
--ex08
select last_name, department_id, department_name from employees full join departments using(department_id);
--ex09
select last_name, department_id, manager_id from employees join departments using (department_id, manager_id);

--ex10
create table locations2 as select * from locations;
select * from locations2;
alter table locations2 rename column location_id to loc_id;

select department_id, city from departments join locations2 on (location_id = loc_id);

select d.department_id, l.city from departments d, locations2 l
where d.location_id = l.loc_id;
--ex12
select * from countries cross join locations; -- �����
--ex13
create table salGrade(
salvel varchar2(2),
lowst number, 
highst number);
select * from salgrade;
insert into salgrade values('A', 20000, 29999);
insert into salgrade values('B', 10000, 19999);
insert into salgrade values('C', 0, 9999);

select last_name, salary, salvel from employees join salgrade on (salary between lowst and highst)
order by salary desc;

select last_name, job_title, department_name from employees 
join jobs using (job_id)
join departments using (department_id);

--Q03
select last_name as ����̸�, city as "��   ��" , department_name as �μ��� from employees
join departments using (department_id)
join locations2 on (location_id = loc_id)
where city in ('Seattle', 'Oxford') 
order by city asc;

--Q04
select employee_id as �����ȣ, last_name as �����, department_name as �μ���, city as ����, street_address as �����ּ�, country_name as ���� from employees
left join departments using (department_id)
join locations2 on(location_id = loc_id)
join countries using (country_id)   -- like ~ in : '%' �� �־ �Ұ�
where street_address like '%Ch%' or street_address like '%Sh%' or street_address like '%Rd%'
order by country_name, 3;

--ex11: self join
select e.employee_id, e.last_name as �����, m.last_name as ���Ŵ��� from employees e, employees m
where e.manager_id = m.employee_id;

select e.employee_id, e.last_name as �����, m.last_name as ���Ŵ��� from employees e
join employees m on (m.employee_id = e.manager_id);
