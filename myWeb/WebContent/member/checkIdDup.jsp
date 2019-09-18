<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/myWeb/member/checkIdDup.do">
	<c:if test="${isDup }">
		이미 사용중인 아이디 입니다. <br>
		다른 아이디를 입력해주세요 : <br>
		<input type="text" name="id" size="10">
		<input type="submit" value="중복확인">
	</c:if>
	
	<c:if test="${!isDup }"> 
		사용 가능한 아이디입니다. <br>
		<input type="button" value="아이디 사용" onclick="location.href='/myWeb/member/checkIdDupClose.do'">
	</c:if>
</form>
