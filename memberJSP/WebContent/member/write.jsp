<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="memberJSP.bean.MemberDTO"%>
<%@ page import="memberJSP.dao.MemberDAO"%>

<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="memberDTO" class="memberJSP.bean.MemberDTO" scope="session"/>
<jsp:setProperty property="*" name="memberDTO"/>

<% int cnt = MemberDAO.getinstance().insert(memberDTO);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공</title>
</head>
<body>
	<% if (cnt != 0) { %>
	<%=cnt%> 건 회원 가입 완료 <br><br>
	<input type = "button"  value = "로그인" onclick ="location.href = '/memberJSP/member/loginForm.jsp'"> 
	<% } else { %>
	회원가입 실패. 다시 진행해주세요. 
	<% } %>
</body>
</html>