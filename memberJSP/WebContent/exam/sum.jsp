<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- jsp:useBean>> singleTon으로 디폴트 생성자 생성과 동일 ! 
but, jsp에서는 사라졌으나 [사용 비권장] spring에서 동일 기능을 다른 형태로 사용할 수 있음. 
							클래스명은 풀쿼리네임으로 적는다 -->
							
<!-- scope(유효범위): page(=this), request(내장객체), session(서버의 세션 값(ex로그인 값)이 유효할 때 까지) application(프로그램 전체)-->

<jsp:useBean id="dataDTO" class="exam.bean.DataDTO" scope="session"/>
<jsp:setProperty property="x" name="dataDTO"/>
<jsp:setProperty property="y" name="dataDTO"/>
<!-- 태그<>의 name속성의 이름 = DTO변수명 = DB Table 컬럼명이 동일하여야 매핑 가능 !!-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sum</title>
</head>
<body>
<jsp:getProperty property="x" name="dataDTO"/> +
<jsp:getProperty property="y" name="dataDTO"/> =
<%=dataDTO.getX() + dataDTO.getY() %>
<br>
<!-- submit으로 한다면? input type = hidden 으로 value 값 준다. -->
<input type="button" value="곱 구하기" onclick= "location.href ='mul.jsp'">
</body>
</html>