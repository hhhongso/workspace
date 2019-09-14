<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO"%>
<%@ page import="member.dao.MemberDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
</head>
<body>
	 회원 가입 완료 <br><br>
	<input type = "button"  value = "로그인" onclick ="location.href = '/mvcMember/member/loginForm.do'"> 
	
</body>

</html>