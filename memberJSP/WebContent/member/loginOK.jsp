<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
// post 방식
// request.setCharacterEncoding("UTF-8");
// String name = (String)request.getSession().getAttribute("name");
%>
<img src="../image/ni.PNG" width=80 height=80 onclick ="location.href='../main/index.jsp'" style= "cursor:pointer;">
<%=name%> 님 로그인
<br><br>
<input type = "button" value = "로그아웃" onclick="">
<input type = "submit" value = "회원정보수정">