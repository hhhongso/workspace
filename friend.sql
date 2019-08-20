CREATE TABLE FRIEND(
seq number primary key, -- 기본키: 개체 무결성 조건
name varchar2(15) not null, -- if null이면 nullPointerException
tel1 varchar2(5), 
tel2 varchar2(5), 
tel3 varchar2(5), 
sex number, -- 여자는 1 남자는 0
read number default 0,  -- 선택은 1 선택해제 0
movie number default 0, 
music number default 0, 
game number default 0, 
shooping number default 0
);

create sequence seq_friend nocycle nocache; 

select * from friend;
delete friend;
commit;
rollback;

select * from user_sequences;
select seq_friend.nextVal from dual;
select seq_friend.currVal from dual; 

select * from friend order by seq desc;
-- insert, update, delete: 개수 리턴 executeUpdate();
-- select, : 결과물을 resultSet에 하나하나 담아 리턴 executeQuery(); !개수가 없다! .length, size(X)
-- 갯수만큼 돌리기 위하여 : 1. position을 맞추고, 레코드가 있으면 true, 없으면 false를 리턴한다.  : rs.next();
-- 2. 데이터 꺼내기: rs.getString("name(항목)"); 혹은 rs.getString(2(columnNumber)); 

delete friend where seq = 10;