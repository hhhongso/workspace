<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>

<script>
window.onload = function(){
	alert("회원가입 완료");
	location.href='/miniProject/main/index.do';
}
</script>
