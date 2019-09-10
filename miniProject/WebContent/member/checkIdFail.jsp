<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form name="checkIdForm" method= "get" action="/miniProject/member/checkId.do">
${id} 는 이미 사용 중입니다.
	<br><br>
	아이디 <input type="text" name="id" size=10>
	<input type = "submit" value = "중복체크">
</form>

<script src="../js/member.js"></script>
