select round(months_between('95-10-21', '94-10-20')) from dual;

select last_name, to_char(salary, 'L99,999.0') from employees where last_name = 'King';

--ex16
select to_char(to_date('97/9/30', 'YY-MM-DD'), 'YYYY-MON-DD') from dual;
select to_char(to_date('97/9/30', 'RR-MM-DD'), 'RRRR-MON-DD') from dual;

select to_char(to_date('17/9/30', 'YY-MM-DD'), 'YYYY-MON-DD') from dual;
select to_char(to_date('17/9/30', 'RR-MM-DD'), 'RRRR-MON-DD') from dual;

--Q4
select last_name, hire_date from employees where hire_date <= to_date('05/01/01', 'RR-MM-DD') order by 2 desc;
select last_name, to_char(hire_date,'dd-mon-yyyy') as �Ի��� from employees where hire_date < '2005-01-01' order by 2 desc;
                             --mm: ���ڷ�. mon: ��(Local) ���� ǥ��
--ex17
select last_name, hire_date from employees where hire_date = '05/09/30';
select to_char(sysdate, 'YYYY-MM-DD') from dual;
select to_char(sysdate, 'YYYY-fmMM-DD') from dual;

select to_char(to_date('2011-03-01', 'YYYY-MM-DD'), 'YYYY-fmMM-DD') from dual;

--ex18
select salary from employees order by 1 asc;
select count(salary), max(salary), min(salary), trunc(avg(salary), 0), to_char(sum(salary), 'L9,999,999') from employees;

--Q05
select employee_id from employees order by 1 asc;
select count(employee_id) from employees where commission_pct is null;
select count(*) from employees where commission_pct is null;
select count(nvl(commission_pct, 0)) from employees where commission_pct is null;

--ex19
select department_id from employees order by 1 asc;
select count(department_id) from employees; -- null�� ī��Ʈ ���� ����
select count(*) from employees; -- null�� ī��Ʈ 

select count(distinct department_id) from employees; -- null�� ī��Ʈ ���� ����
select count(distinct nvl(department_id, 0)) from employees; -- null���� 0(Ư�� ����. ���ںҰ�)�� ä��
select distinct nvl(department_id, 0) from employees;

--ex20
select job_id, decode(job_id, 'SA_MAN', 'Sales Dept', 'SA_REP', 'Sales Dept', 'Another') �з� from employees order by �з� asc; 
select job_id, case job_id when 'SA_MAN' then 'Sales Dept' when 'SA_REP' then 'Sales Dept' else 'Another' end �з� from employees order by �з� desc;
select job_id, case when job_id = 'SA_MAN' then 'Sales Dept' when job_id = 'SA_REP' then 'Sales Dept' else 'Another' end �з� from employees order by 2 asc;

--Q06
select employee_id as �����ȣ, last_name as �����, salary �޿�, case when salary < 10000 then '�ʱ�' when salary < 20000 then '�߱�' else '���' end ���� from employees order by 4, 2 asc;