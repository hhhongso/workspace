<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<%
request.setCharacterEncoding("UTF-8");
int seq = Integer.parseInt(request.getParameter("seq")); 
String subject = request.getParameter("subject");
String content = request.getParameter("content");

boardDAO.updateBoard(subject, content, seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script>
window.onload = function(){
	alert("게시글이 수정되었습니다. ");
	location.href="boardList.jsp?pg=1";
}

</script>
</html>