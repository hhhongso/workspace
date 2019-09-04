<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="aaa" uri="tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>자바 클래스의 메소드를 이용하여 계산</h3>
${param['x']} + ${param['y'] } = ${aaa:sum(param['x'], param['y'])} <br>
${param.x} * ${param.y } = ${aaa:mul(param.x, param.y)} <br>

${param.x} / ${param.y } = ${aaa:divide(param.x, param.y)} <br>

</body>
</html>