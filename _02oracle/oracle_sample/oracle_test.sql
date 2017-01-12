--����1)EMP ���̺��� �̸�, �޿�, ���ʽ�, ������ ����Ͽ���

SELECT LAST_NAME AS �̸�, SALARY AS �޿�, NVL(commission_pct*salary,0) AS ���ʽ�, salary*12  AS ����
FROM EMPLOYEES;

--����2) EMP�� DEPT ���̺��� ������ MANAGER�� ����� ������ �̸�, ����, �μ���, �ٹ����� ����Ͽ���

SELECT A.EMPLOYEE_ID, A.LAST_NAME, A.JOB_ID, B.DEPARTMENT_NAME, B.LOCATION_ID
FROM EMPLOYEES A, DEPARTMENTS B
WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID
AND A.EMPLOYEE_ID IN (SELECT MANAGER_ID FROM EMPLOYEES);

--����3) EMP ���̺��� �̸��� ù���ڰ� 'K'���� ũ�� 'Y'���� ���� ����� ������ �����ȣ, �̸�, ����, �޿�, �μ���ȣ�� ����Ͽ���. �� �̸������� ����!

SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE LAST_NAME > 'Kz'  AND LAST_NAME < 'Y'
ORDER BY LAST_NAME;

--����4) EMP ���̺��� �Ի��Ϻ��� ������� �ٹ��ϼ��� ����Ͽ���. �� �ٹ��ϼ��� ���� ��� ������ ����Ͽ���.

SELECT LAST_NAME, ROUND(SYSDATE-HIRE_DATE)
FROM EMPLOYEES
ORDER BY ROUND(SYSDATE-HIRE_DATE) DESC;

--����5) EMP ���̺��� 10�� �μ� ������� ��������� �ٹ� ������������ ����Ͽ� ����Ͽ���.
SELECT DEPARTMENT_ID, ROUND(SUM(MONTHS_BETWEEN(SYSDATE, HIRE_DATE))) AS �ٹ�������
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING DEPARTMENT_ID = 10;

--����6) EMP���̺����� �μ� 20�� �޿� �տ� $�� �����ϰ� 3�ڸ�����,�� ����Ͽ���
SELECT DEPARTMENT_ID, TO_CHAR(SALARY, '$999,999')
FROM EMPLOYEES
WHERE DEPARTMENT_ID = 20;

--����7) EMP���̺��� ��� SALESMAN�� ���Ͽ� �޿��� ���, �ְ��, ������, �հ踦 ���Ͽ� ����Ͽ���.
SELECT JOB_ID, AVG(SALARY), MAX(SALARY), MIN(SALARY), SUM(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING JOB_ID = 'SA_MAN';

--����8) EMP ���̺��� �μ����� �ο���, ���, �޿�, �����޿�, �ְ�޿�, �޿��� ���� ���Ͽ� ����Ͽ���.
SELECT DEPARTMENT_ID, COUNT(*), AVG(SALARY), MIN(SALARY), MAX(SALARY), SUM(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID;

--����9) EMP���̺��� �μ� �ο��� 4�� ���� ���� �μ��� �μ���ȣ, �ο���, �޿��� ���� ���Ͽ� ����Ͽ���.
SELECT DEPARTMENT_ID, COUNT(*), SUM(SALARY)
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING COUNT(*) > 4;

--����10) �� ����� ���ʽ��� 0 �Ǵ� NULL�̰� �μ��� 'ING'�� ������ ����� ������ ���ʹ�ȣ, ����̸�, ���ʽ�, �μ���ȣ, �μ���, �μ���ġ�� ����Ͽ���.
-- ��, ���ʽ��� NULL�̸� 0���� ����Ͽ���!

SELECT A.EMPLOYEE_ID, A.LAST_NAME, NVL(A.COMMISSION_PCT, 0), A.DEPARTMENT_ID, B.DEPARTMENT_NAME, B.LOCATION_ID
FROM EMPLOYEES A, DEPARTMENTS B
WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID 
AND A.COMMISSION_PCT IS NULL
AND B.DEPARTMENT_NAME LIKE '%ing';








KTX 144 16:35 13ȣ�� 11A
