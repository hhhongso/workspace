<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<strong>구구단을 외자~♬</strong><br>

<font color="#2266ff">
<c:forEach var="i" begin="1" end="9" step="1">
${param.dan } * ${i } = ${ param.dan* i } <br>
</c:forEach>
</font>