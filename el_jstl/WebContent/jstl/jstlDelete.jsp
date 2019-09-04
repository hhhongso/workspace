<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:requestEncoding value= "UTF-8"/>
<sql:update var="cnt" dataSource="jdbc/oracle">
	delete from usertable where id = ?
	<sql:param value="${param.id }"></sql:param>
</sql:update>
    
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
	alert("삭제완료");
	location.href="jstlList.jsp";
}
</script>

</html>