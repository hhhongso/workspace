<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:requestEncoding value= "UTF-8"/>
<sql:update var="cnt" dataSource="jdbc/oracle">
	insert into usertable values ('${param.name }','${param.id }','${param.pwd }')
</sql:update>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${cnt == 1}"> 회원가입 성공 </c:if>
	<c:if test="${cnt != 1}"> 회원가입 실패 </c:if>
	<br><br>
	<input type="button" value="목록" onclick="location.href='jstlList.jsp'">
</body>
</html>