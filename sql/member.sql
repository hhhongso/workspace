create table member(
name varchar2(30) not null,
id varchar2(30) primary key, --�⺻Ű, unique, not null, ���Ἲ ���� ����
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
seq NUMBER NOT NULL, -- �۹�ȣ
id VARCHAR2(20) NOT NULL, -- ���̵�
name VARCHAR2(40) NOT NULL, -- �̸�
email VARCHAR2(40), -- �̸���
subject VARCHAR2(255) NOT NULL, -- ����
content VARCHAR2(4000) NOT NULL, -- ����
 
ref NUMBER NOT NULL, -- �׷��ȣ: ref�� seq�� ���� ���� �ش�.
lev NUMBER DEFAULT 0 NOT NULL, -- �ܰ�
step NUMBER DEFAULT 0 NOT NULL, -- �ۼ���
pseq NUMBER DEFAULT 0 NOT NULL, -- ���۹�ȣ
reply NUMBER DEFAULT 0 NOT NULL, -- �亯��
 
hit NUMBER DEFAULT 0, -- ��ȸ��
logtime DATE DEFAULT SYSDATE
);

CREATE SEQUENCE seq_board NOCACHE NOCYCLE;

delete from board;
commit;
select*from board;
