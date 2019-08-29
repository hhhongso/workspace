<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input</title>
</head>
<body>
	<form method="post" action="sum.jsp">
		<div style = "display: inline-block; background-color:pink">
			<label><b> X </b></label>
			<input type="text" name = "x" size = 10>
		</div>
		<br>
		<div style = "display: inline-block; background-color:cyan">
			<label> Y </label>
			<input type="text" name = "y" size = 10>
		</div>
		<br>
		<input type="submit" value="합구하기">	
	
	</form>
</body>
</html>