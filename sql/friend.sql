CREATE TABLE FRIEND(
seq number primary key, -- �⺻Ű: ��ü ���Ἲ ����
name varchar2(15) not null, -- if null�̸� nullPointerException
tel1 varchar2(5), 
tel2 varchar2(5), 
tel3 varchar2(5), 
sex number, -- ���ڴ� 1 ���ڴ� 0
read number default 0,  -- ������ 1 �������� 0
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
-- insert, update, delete: ���� ���� executeUpdate();
-- select, : ������� resultSet�� �ϳ��ϳ� ��� ���� executeQuery(); !������ ����! .length, size(X)
-- ������ŭ ������ ���Ͽ� : 1. position�� ���߰�, ���ڵ尡 ������ true, ������ false�� �����Ѵ�.  : rs.next();
-- 2. ������ ������: rs.getString("name(�׸�)"); Ȥ�� rs.getString(2(columnNumber)); 

delete friend where seq = 10;