--ex01
select department_name from departments where department_id = 
(select department_id from employees where first_name = 'Neena');

--ex02
select first_name, department_id, salary from employees 
where department_id = (select department_id from employees where first_name = 'Neena')
and salary > (select salary from employees where first_name = 'Neena');

--Q1
select last_name, salary from employees where salary = (select min(salary) from employees);

--Q2
select department_name, sum(salary) from employees 
join departments using (department_id)
group by department_name
having sum(salary) = (select max(sum(salary)) from employees group by department_id);


select department_name, sum(salary) 
from employees 
join departments using (department_id)
where sum(salary) = max(sum(salary))
group by department_name
having department_name = (select department_name from departments where d.department_id = e.department_id);

--ex03
select last_name, department_name, salary from employees
join departments using(department_id)
where department_id = (select department_id from employees where last_name = 'Austin')
and salary = (select salary from employees where last_name = 'Austin');

--ex04
select last_name, job_id, salary from employees where salary > any(select salary from employees where job_id = 'ST_MAN')
and job_id = 'IT_PROG'; 

--Q3
select max(salary) from employees where job_id = 'IT_PROG';

select last_name as 사원명, job_id as 업무ID, to_char(salary*1000, '99,999,999')||'원' as 급여 from employees 
where job_id in('FI_ACCOUNT','SA_REP')
and salary > all(select salary from employees where job_id = 'IT_PROG')
order by salary desc;

--ex05
select last_name, job_id, salary from employees where salary = any(select salary from employees where job_id = 'IT_PROG');

--ex06
select employee_id, last_name, manager_id, '관리자' as 구분 from employees
where employee_id in (select manager_id from employees)
union
select employee_id, last_name, manager_id, '사원' as 구분  from employees
where employee_id not in (select manager_id from employees where manager_id is not null);

select employee_id, last_name,
case 
when employee_id in(select manager_id from employees)
then '관리자' 
else '직원' 
end as 구분 from employees order by 3;
