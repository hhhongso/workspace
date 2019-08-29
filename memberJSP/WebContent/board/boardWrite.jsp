<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="boardDTO" class="board.bean.BoardDTO"/>
<jsp:setProperty property="*" name="boardDTO"/>

<%BoardDAO.getinstance().write(boardDTO);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
글쓰기 성공! 
<input type="button" value="글목록보기" onclick="boardList.jsp">
</body>
</html>