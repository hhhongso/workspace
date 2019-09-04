<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
계산해주세욥
${param['x']} + ${param['y'] } = ${param['x'] + param['y']} <br>
${param['x']} - ${param['y'] } = ${param['x'] - param['y']} <br>
${param.x } * ${param.y } = ${param.x * param.y } <br>
${param.x } div ${param.y } = ${param.x div param.y } <br>
${param.x } mod ${param['y'] } = ${param.x mod param.y } <br>
</body>
</html>