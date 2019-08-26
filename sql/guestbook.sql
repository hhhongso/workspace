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

select * from 
(select rownum rn, temp.* from 
(select seq, name, email, homepage, subject, content, to_CHAR(logtime, 'YYYY.MM.DD') as logtime from guestbook order by seq desc) temp)
where rn between 1 and 2;
-- seq 와 별개로, 페이지 당 2개씩 가져올 수 있도록 행번호를 부여. between 1 and 2, 3and 4, 5 and 6.... 

select count(*) as totArticle from guestbook;

select * from guestbook;

commit;
