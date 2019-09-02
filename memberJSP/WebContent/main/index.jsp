<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String id = (String)session.getAttribute("memId");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> *** 메인 화면 ***</h3>
<a href="#" style="cursor:pointer;"><abbr title="타이틀"> <img src="../image/main.gif"></abbr></a><br>
<%if(id == null) { %>
	<a href="../member/writeForm.jsp"> 회원가입 </a> <br>
	<a href="../member/loginForm.jsp"> 로그인 </a> <br>
<% } else { %>
<%=id%> 님으로 로그인 하였습니다.  <br>
	<a href="../member/modifyForm.jsp"> 회원정보수정 </a> <br>
	<a href="../member/logout.jsp"> 로그아웃 </a> <br>
	<a href="../board/boardWriteForm.jsp"> 글쓰기 </a> <br>
<% } %>

<a href="../board/boardList.jsp?pg=1"> 목록 </a> <br>

</body>
</html>