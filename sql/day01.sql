select * from tab; 
select * from employees;
select count (*) from employees;

select * from user_sequences; -- 시퀀스 목록 확인
desc employees; -- describe : 테이블 구조 확인 (내림차순 아님)

--ex01
select employee_id, last_name, salary from employees;

--ex02
select employee_id as "사원 번호", last_name as 사원명, salary as "급 여" from employees;

--ex03
select employee_id as "사원 번호", last_name as 사원명, salary*12 as "연 봉" from employees;

--ex04
select employee_id as "사원 번호", first_name ||' '|| last_name as 사원명, salary*12||'달러' as "연 봉" from employees;
select last_name|| ' is a ' || job_id as "Employee Detail" from employees;

--ex05
select distinct department_id from employees;

--ex06
select last_name, hire_date, department_id from employees where department_id = 10 or department_id = 90;

--ex07
select last_name, hire_date, salary from employees where salary between 2500 and 3500;
select first_name ||' '|| last_name as 사원명, '$'||salary as 월급, department_id as "부서 코드" from employees where (salary <=2400 or salary>= 3000) and department_id = 90;
                                                                                                            --and, or는 우선순위가 같다
--ex08
select * from employees where last_name = 'King';

--ex09
select last_name, job_id, department_id from employees where job_id like '%MAN%';

--ex10
select last_name, job_id, department_id from employees where job_id like 'IT%';

--ex11
select last_name, salary, commission_pct from employees where commission_pct is not null;
select last_name, salary, commission_pct from employees where commission_pct is null;

--ex12
select employee_id, last_name, job_id from employees where job_id in('FI_MGR', 'FI_ACCOUNT');

--ex13
select employee_id, last_name, salary from employees where salary between 10000 and 20000;

select last_name, job_id, salary||'원' as 급여 from employees where job_id in('SA_REP', 'AD_PRES') and salary > 10000;

select distinct job_id from employees;

select employee_id as 사원번호, last_name as 이름, hire_date as 입사일 from employees where hire_date like '05%';
-- 2005 중 20 은 메모리에 기억되지 않는다. (2000~2099) => 00 ~ 99 만 메모리에 기억됨.