<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form name="loginForm" method="post" action="/miniProject/member/login.do">
  <h2> 로그인 </h2>
		<table class="tab" border=3>
			<tr>
				<th class="idtab">아이디</th>
				<td><input type="text" name="id" size=10></td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" size=20></td>
			</tr>

			<tr>
				<td colspan=2 align="center">
					<input type="button" value="로그인" onclick="checkLogin()"> 
				</td>
			</tr>
		</table>
	</form>

<script src = "../js/member.js"></script>
