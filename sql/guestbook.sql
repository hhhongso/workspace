create table guestbook(
seq number primary key,
name varchar2(30),
email varchar2(30),
homepage varchar2(35),
subject varchar2(500) not null,
content varchar2(4000) not null,
logtime date);

create sequence seq_guestbook nocycle nocache;

select to_CHAR(sysdate, 'YYYY.MM.DD') from dual;
select to_CHAR(logtime, 'YYYY.MM.DD') from guestbook;

select * from guestbook;
commit;
