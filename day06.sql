create table employees_role as select * from employees where 1=0;

insert into employees_role values(101, 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', 17000.00, 0.2, 100, 90);
insert into employees_role values(101, 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', 17000.00, NULL, 100, 90);
insert into employees_role values(101, 'Nee', 'Ko', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', 17000.00, NULL, 100, 90);
insert into employees_role values(200, 'Neena', 'Kochhar', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', 17000.00, 0.15, 100, 90);
insert into employees_role values(200, 'Nee', 'Kochhar', 'NKOCHHAR', '515.123.4568', '1989-09-21', 'AD_VP', 17000.00, 0.25, 100, 90);
insert into employees_role values(300, 'GilDong', 'Conan', 'CONAN', '010-123-4567', '2009-03-01', 'IT_PROG', 23000.00, NULL, 100, 90);

select * from employees_role;
select * from employees;
commit;

--ex01 union: 중복제거
select employee_id, last_name from employees union
select employee_id, last_name from employees_role;

--ex02 union all: 중복 포함
select employee_id, last_name from employees union all
select employee_id, last_name from employees_role;

select salary from employees where department_id = 10;
select salary from employees where department_id = 30;
select salary from employees where department_id = 10 union all
select salary from employees where department_id = 30 order by salary;

--ex03 minus: 차집합
select employee_id, last_name from employees minus
select employee_id, last_name from employees_role;

--ex04 intersect: 교집합
select employee_id, last_name from employees intersect
select employee_id, last_name from employees_role;

--Q01
select last_name as 사원명, job_id as 업무ID, department_id as 부서ID from employees where department_id = 10 union
select last_name, job_id, department_id from employees_role where job_id = 'IT_PROG';