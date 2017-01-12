/*

structured Query Language
구조적       문의  언어

비절차적
대화식 질의어를 사용
범용 프로그램과 혼용해서 사용

DDL(DATA DEFINITION LANGUAGE)
  스키마의 객체생성, 변경, 삭제
  CREATE, ALTER, DROP

DML(DATA MANIPULATION LANGUAGE)
  데이터의 조회, 추가, 수정, 삭제 == DAO(DATA ACCESS OBJECT)
  SELECT  INSERT  UPDATE  DELETE


TRANSACTION / SESSION
  COMMIT(적용)  ROLLBACK(되돌림) CONN  DISC
  CONSTRAINT (제약조건) NOT NULL

DCL(DATA CONTROL LANGUAGE  
  권한 관리
  GRANT REVOKE
  
 SQL PASING //원하는 데이터만 산출하는 걸 PASING이라 한다. -> 번역 -> ROW SOURCE -> SQL ENGINE
 
 1-홍길동-24-서울시
 <번호> 1
 <이름> 홍길동
  .
  . 
  .
  --컬럼 전체를 찾고싶을 때 : *
  SELECT 컬럼(*)
  FROM 테이블명
  WHERE 조건(AND, OR, NOT)
  GROUP BY
  HAVING 그룹에 대한 조건
  STARTJ WITH
  CONNECT BY 조인(JOIN)시에 사용
  ORDER BY 정렬
  
  */














