<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/member.css">

<form>
<div id="loginForm" align="center">
	<h2>로그인</h2>
	<table class="loginTb table table-striped" style="width: 50%;">
		<tr>
			<th width="70px"> 아이디 </th>
			<td> 
			<input type="text" name="id" class="id" placeholder="아이디를 입력하세요" required autofocus>
			<div class="idDiv"></div>
			</td>		
		</tr>
		
		<tr>
			<th> 비밀번호 </th>
			<td> 
			<input type="password" name="pwd" class="pwd" placeholder="비밀번호를 입력하세요" required>
			<div class="pwdDiv"></div>
			</td>		
		</tr>
		
		<tr><td colspan=2><input type="checkbox" class="rememberMe" value="1"> 로그인 유지</td> 	</tr>
		<tr>
			<td colspan=2 align="center"> 
			<label>아이디/비밀번호 찾기</label> <br>
			<input type="button" class="btnLogin btn btn-default" value="로그인" style="width:100%; padding: 5px 0; margin: 5px 0;">
			<input type="button" class="btn btn-default" value="회원가입" style="width:100%; padding: 5px 0;" onclick="location.href='/semiProject/member/signupForm.do'">
			<div class="isLoginDiv"></div>
			</td>		
		</tr>
	</table>
</div>
</form>


<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/member.js"></script>