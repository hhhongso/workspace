DROP TABLE CAFE_MEMBER;

CREATE TABLE CAFE_MEMBER(
    id varchar2(40) primary key,
    pw varchar2(100),
    name varchar2(15),
    email1 varchar2(100),
    email2 varchar2(100),
    tel1 varchar2(15),
    tel2 varchar2(15),
    tel3 varchar2(15),
    birthYear number,
    birthMonth number,
    birthDate number,
    staff number
);
INSERT INTO CAFE_MEMBER VALUES('test', '123', '테스트계정', 'test', 'test', '000', '0000', '0000', 1999, 1, 1, 1);
INSERT INTO CAFE_MEMBER VALUES('test2', '123', '테스트계정', 'test', 'test', '000', '0000', '0000', 1999, 1, 1, 0);
SELECT * FROM CAFE_MEMBER;
SELECT COUNT(ID) FROM CAFE_MEMBER WHERE ID = 'tjsdydwn' AND PW = 's123456789';
DELETE FROM CAFE_MEMBER;
SELECT id, name, email1 || '@' || email2 as email, tel1 || '-' || tel2 || '-' || tel3 as tel, birthYear || '년' || birthMonth || '월' || birthDate || '일' as birthday, staff FROM CAFE_MEMBER;

CREATE TABLE CAFE_ROOMRESERVATION(
    seq number,
    id varchar2(40),
    room_num number,
    room_year number,
    room_month number,
    room_date number,
    inhour number,
    outhour number,
    price number
);

CREATE SEQUENCE SEQ_ROOM NOCYCLE NOCACHE;
CREATE SEQUENCE SUBSEQ_ROOM NOCYCLE NOCACHE;

SELECT id, room_num, room_year||'년 '||room_month||'월 '||room_date||'일' as day, inhour, outhour 
FROM CAFE_ROOMRESERVATION
ORDER BY day desc, inhour desc, outhour desc, room_num;

DELETE FROM CAFE_ROOMRESERVATION;
SELECT * FROM CAFE_ROOMRESERVATION;
DROP TABLE CAFE_ROOMRESERVATION;
COMMIT;

CREATE TABLE CAFE_BOARD(
    BOARD_SEQ NUMBER primary key,
    ID VARCHAR2(20),
    BOARD_TEXT VARCHAR2(300),
    BOARD_DATE NUMBER
);

ALTER TABLE CAFE_BOARD MODIFY(BOARD_DATE VARCHAR2(30));
DELETE FROM CAFE_BOARD;
-- create sequence seq_friend nocycle nocache;

CREATE SEQUENCE SEQ_CAFE_BOARD NOCYCLE NOCACHE;
COMMIT;
SELECT * FROM CAFE_BOARD;
drop table cafe_board;

--CAFE_ORDER 쿼리: 주문내역 관리
CREATE TABLE CAFE_ORDER(
    seq number primary key,
    id varchar2(40),
    menuName varchar2(40),
    amount number, 
    menuPrice number, 
    totPrice number
);

CREATE TABLE CAFE_ORDER_TEMP(
    id varchar2(40),
    menuName varchar2(40),
    amount number, 
    menuPrice number, 
    totPrice number
);

select * from CAFE_ORDER;
SELECT * FROM CAFE_ORDER WHERE SEQ > 26;

delete from CAFE_ORDER;
COMMIT;

create sequence seq_order nocycle nocache;
select seq_order.nextVal from dual;

drop table cafe_order;
drop sequence seq_order;


--CAFE_SALES 쿼리: 매출 관리
CREATE TABLE CAFE_SALES(
    seq number primary key,
    menuName varchar2(40),
    amount number, 
    menuPrice number, 
    orderDate varchar2(40)
);
ALTER table CAFE_SALES RENAME COLUMN sebseq to subseq;
create sequence seq_sales nocycle nocache;
select * from cafe_sales;
SELECT seq, menuName, amount, menuPrice, amount * menuPrice as tot, orderDate FROM CAFE_SALES;
delete from cafe_sales;

drop table cafe_sales;