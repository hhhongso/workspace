--CAFE_MEMBER 孽府
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
    staff number,
    agreeEssen number,
    agreeSelec number
);

--CAFE_ROOMRESERVATION 孽府 
CREATE TABLE CAFE_ROOMRESERVATION(
    id varchar2(40),
    room_num number,
    room_year number,
    room_month number,
    room_date number,
    inhour number,
    outhour number
);

--CAFE_BOARD 孽府


--CAFE_ORDER 孽府: 林巩郴开 包府
CREATE TABLE CAFE_ORDER(
    seq number primary key,
    id varchar2(40),
    menuName varchar2(40),
    amount number, 
    menuPrice number, 
    totPrice number);
select * from CAFE_ORDER;
SELECT * FROM CAFE_ORDER WHERE SEQ > 26;

delete from CAFE_ORDER;

create sequence seq_order nocycle nocache; 
select seq_order.nextVal from dual;

drop table cafe_order;
drop sequence seq_order;


--CAFE_SALES 孽府: 概免 包府
CREATE TABLE CAFE_SALES(
    seq number primary key,
    menuName varchar2(40),
    amount number, 
    menuPrice number, 
    totPrice number,
    orderDate varchar2(40));
    
select * from cafe_sales;
delete from cafe_sales;

create sequence seq_sales nocycle nocache; 
select seq_sales.nextVal from dual;

drop table cafe_sales;