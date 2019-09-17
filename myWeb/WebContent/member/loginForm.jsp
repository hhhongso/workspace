<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/signStyle.css">
<form>
	<table class="loginForm">
		<tr>
			<th>아이디</th>
			<td><input type="text" size="10"></td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td><input type="password" size="10"></td>
		</tr>
		
		<tr>
			<td colspan=2 align="center">
				<input type="button" value="로그인">
				<input type="button" value="회원가입" onclick="openSignUpForm()">
			</td>
		</tr>
	</table>
</form>
<script src="../js/member.js"></script>