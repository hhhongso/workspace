<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:requestEncoding value= "UTF-8"/>   
<sql:query var="rs" dataSource="jdbc/oracle">
	select*from usertable where id = ? 
	<sql:param value="${param.id }"></sql:param>
</sql:query>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name = "modifyForm" method = "post" action="jstlModify.jsp">
  <h2> 회원정보수정 </h2>
  <c:forEach var="row" items="${rs.rowsByIndex}">
  <table border = 3 cellspacing = "2" cellpadding = "2">
	  <tr>
	   <th width = 120> 이름  </th>
	   <td> <input type = "text" name = "name" size = 20 value="${row[0]}"> </td>
	  </tr>
	  
	  <tr>
	   <th> 아이디 </th>
	   <td> 
	   	<input type = "text" name = "id" size = 25 value="${row[1]}" readonly>
	   </td>
	  </tr>
	  
	  <tr>
	   <th> 비밀번호  </th>
	   <td> <input type = "password" name = "pwd" size = 30> </td>
	  </tr>
	  
	  <tr>
	  	<td colspan=2 align="center">
	  		<input type="submit" value="수정" onclick="check()">
	  		<input type="reset" value="취소">
	  		<input type="button" value="목록" onclick="location.href='jstlList.jsp'">
	  	</td>
	  </tr>
  </table>
  </c:forEach>
</form>
</body>
<script>
function check(){
	if(document.modifyForm.pwd.value== "") alert("비번! ");
	else document.modifyForm.submit();
}
</script>
</html>