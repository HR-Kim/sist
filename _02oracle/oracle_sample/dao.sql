/*
  INSERT, DELETE, UPDATE
*/
CREATE TABLE TB_TEST_01(
  KEY_01 VARCHAR2(10),
  COL_01 VARCHAR2(100)
);

INSERT INTO TB_TEST_01(KEY_01, COL_01)
VALUES('AAA', '111');

INSERT INTO TB_TEST_01
VALUES('BBB', '222'); -- 모든 칼럼의 데이터를 넣을때 만 가능

COMMIT;   -- 적용
ROLLBACK; -- 되돌림

--하나의 테이블에 다중행 입력
INSERT INTO TB_TEST_01(KEY_01, COL_01)
SELECT JOB_ID, JOB_TITLE
FROM JOBS;

INSERT INTO TB_TEST_01(KEY_01, COL_01)
SELECT JOB_ID, JOB_TITLE
FROM JOBS
WHERE JOB_ID LIKE 'AD%';

-- 다중테이블 다중행 입력
CREATE TABLE TB_TEST_02(
  KEY_01 VARCHAR2(10),
  KEY_02 VARCHAR2(10),
  COL_01 VARCHAR2(100),
  COL_02 VARCHAR2(100)
);

INSERT ALL
  INTO TB_TEST_01(KEY_01, COL_01)
    VALUES(DEPARTMENT_ID, DEPARTMENT_NAME)
    INTO TB_TEST_02(KEY_01,KEY_02, COL_01,COL_02)
      VALUES(DEPARTMENT_ID, EMPLOYEE_ID, FIRST_NAME, LAST_NAME)
    SELECT A.DEPARTMENT_ID,B.DEPARTMENT_NAME, A.EMPLOYEE_ID, A.FIRST_NAME, A.LAST_NAME 
    FROM EMPLOYEES A, DEPARTMENTS B
    WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID;
    
CREATE TABLE TB_JOBS_BK
AS SELECT * FROM JOBS;

UPDATE TB_JOBS_BK SET MIN_SALARY = NULL, MAX_SALARY = NULL
WHERE JOB_ID LIKE 'AD_%';

ROLLBACK;

--NVL DECODE
UPDATE TB_JOBS_BK
  SET MIN_SALARY = NVL(MIN_SALARY ,0),
      MAX_SALARY = DECODE(MAX_SALARY, NULL, 2, 0)
  WHERE JOB_ID LIKE 'AD_%';
  
DELETE FROM TB_JOBS_BK
WHERE JOB_ID LIKE 'AD_%';

--11
UPDATE EMPLOYEES
   SET DEPARTMENT_ID = 10
 WHERE EMPLOYEE_ID = 7788;
 
--12
UPDATE EMPLOYEES
   SET DEPARTMENT_ID = 20, SALARY = 3500
 WHERE EMPLOYEE_ID = 180;
 
--13
UPDATE EMPLOYEES
   SET JOB_ID = (SELECT JOB_ID FROM EMPLOYEES WHERE LAST_NAME = 'Hall'),
       SALARY = (SELECT SALARY FROM EMPLOYEES WHERE LAST_NAME = 'Hall')
 WHERE LAST_NAME = 'Smith';
--14
UPDATE EMPLOYEES
SET DEPARTMENT_ID = 91
WHERE DEPARTMENT_ID = 100; --DEPARTMET는 외래키라서

--15
ALTER TABLE EMPLOYEES
DISABLE CONSTRAINT EMP_MANAGER_FK;

ALTER TABLE DEPARTMENTS
DISABLE CONSTRAINT DEPT_MGR_FK;

DELETE EMPLOYEES
WHERE EMPLOYEE_ID = 100;

DELETE FROM JOB_HISTORY
WHERE EMPLOYEE_ID = 101;
ROLLBACK;

DELETE JOB_HISTORY
WHERE EMPLOYEE_ID = 102;

DELETE EMPLOYEES
WHERE EMPLOYEE_ID = 102;
