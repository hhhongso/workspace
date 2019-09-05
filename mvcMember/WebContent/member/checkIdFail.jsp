<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="checkIdForm" method= "get" action="/mvcMember/member/checkId.do">
${param.id} 는 이미 사용 중입니다.
	<br><br>
	아이디 <input type="text" name="id" size=10>
	<input type = "submit" value = "중복체크">
</form>
</body>
<script src="../js/member.js"></script>
</html>