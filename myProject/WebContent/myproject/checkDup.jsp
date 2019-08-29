<%@page import="myProject.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% String checkId = request.getParameter("id");
boolean isDup = MemberDAO.getinstance().isDuplicate(checkId); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복검사</title>
</head>
<body>
<form action="checkDup.jsp">
	<% if(isDup) { %>
		<%=checkId%> 는 이미 사용 중인 아이디입니다. <br>
		 다른 아이디를 입력해주세요. <br>
		 <input type="text" name="id" size =10>
		 <input type="submit" value="중복체크"> 
	<%} else {%>
		<%=checkId%> 는 사용 가능한 아이디입니다. <br>
		해당 아이디를 사용하시겠습니까? <br>
		<input type="button" value="사용하기" onclick ="checkDupClose('<%=checkId%>')">
	<% } %>
</form>
</body>

<script src="../js/member.js"></script>
</html>