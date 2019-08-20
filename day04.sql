-- rank(): ��ü ���� ������� ������ ����. 
-- rank(ǥ����) within group(order by ǥ����): Ư�� �������� ������ ����. 
-- rank() over(���� ��Ƽ��): ���� ��Ƽ�� �� ��ü ������ ����. 

SELECT RANK(3000) WITHIN GROUP(ORDER BY SALARY DESC) "RANK" FROM EMPLOYEES;
SELECT EMPLOYEE_ID, SALARY, RANK() OVER(ORDER BY SALARY DESC) "RANK" FROM EMPLOYEES; 

SELECT EMPLOYEE_ID, SALARY, DEPARTMENT_ID, FIRST_VALUE(SALARY) OVER(PARTITION BY DEPARTMENT_ID ORDER BY SALARY DESC) "HIGH_SAL_DEPTID" FROM EMPLOYEES;

--Q7                                    --null���� nvl���� ��ü��Ų��. 
SELECT EMPLOYEE_ID, LAST_NAME, SALARY, NVL(COMMISSION_PCT,0) as Ŀ�̼�, TO_CHAR(SALARY*12 + SALARY*12* NVL(COMMISSION_PCT, 0), '$9,999,999') AS ���� FROM EMPLOYEES;
--Q8
SELECT EMPLOYEE_ID, LAST_NAME, NVL(MANAGER_ID, 1000) AS �Ŵ���ID FROM EMPLOYEES;

------------------------------------------------------------------------------------------------------------------------------------------------
--Day04
--ex01
SELECT TO_CHAR(TRUNC(AVG(SALARY),0), '9,999,999') AS ����޿���� FROM EMPLOYEES;

--ex02
SELECT DEPARTMENT_ID AS �μ��ڵ�, TO_CHAR(ROUND(AVG(SALARY),0), 'L99,999.0') AS �μ����޿���� FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID HAVING AVG(SALARY) > 5000 ORDER BY department_id ASC; 

--ex03
SELECT LAST_NAME, AVG(SALARY) AS ��ձ޿� FROM EMPLOYEES GROUP BY DEPARTMENT_ID; 
                                                        --error! group by ���� ���� ���� select ��ȸ�� �� ����. 

--Q1
SELECT JOB_ID, SUM(SALARY) AS �޿��հ� FROM EMPLOYEES GROUP BY JOB_ID ORDER BY SUM(SALARY) ASC;

--ex04: ��ȿ������ having��. �ι�° ����� �ӵ��� ���� �� ������. 
SELECT DEPARTMENT_ID, MAX(SALARY) AS �ִ�޿� FROM EMPLOYEES 
GROUP BY DEPARTMENT_ID HAVING DEPARTMENT_ID IN(10, 20) ORDER BY DEPARTMENT_ID ASC;

SELECT DEPARTMENT_ID, MAX(SALARY) AS �ִ�޿� FROM EMPLOYEES 
WHERE DEPARTMENT_ID IN(10, 20) GROUP BY DEPARTMENT_ID ORDER BY DEPARTMENT_ID ASC;