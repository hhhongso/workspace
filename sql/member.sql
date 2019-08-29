create table member(
name varchar2(30) not null,
id varchar2(30) primary key, --기본키, unique, not null, 무결성 제약 조건
pwd varchar2(30) not null,
gender varchar2(3),
email1 varchar2(20),
email2 varchar2(20),
tel1 varchar2(10),
tel2 varchar2(10),
tel3 varchar2(10),
zipcode varchar2(10),
addr1 varchar2(100),
addr2 varchar2(100),
logtime date);

select name from member where id = 'a' and pwd = '123';
select *from member;
commit;
drop table member;

CREATE TABLE board(
seq NUMBER NOT NULL, -- 글번호
id VARCHAR2(20) NOT NULL, -- 아이디
name VARCHAR2(40) NOT NULL, -- 이름
email VARCHAR2(40), -- 이메일
subject VARCHAR2(255) NOT NULL, -- 제목
content VARCHAR2(4000) NOT NULL, -- 내용
 
ref NUMBER NOT NULL, -- 그룹번호: ref는 seq와 같은 값을 준다.
lev NUMBER DEFAULT 0 NOT NULL, -- 단계
step NUMBER DEFAULT 0 NOT NULL, -- 글순서
pseq NUMBER DEFAULT 0 NOT NULL, -- 원글번호
reply NUMBER DEFAULT 0 NOT NULL, -- 답변수
 
hit NUMBER DEFAULT 0, -- 조회수
logtime DATE DEFAULT SYSDATE
);

CREATE SEQUENCE seq_board NOCACHE NOCYCLE;

delete from board;
commit;
select*from board;
