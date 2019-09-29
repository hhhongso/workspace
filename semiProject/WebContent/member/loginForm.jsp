<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>

div#loginForm{
	height: 300px;
	padding: 100px;
 	position: inherit;
	top: 50%; 
	left: 50%;
/*  	background: #ebebeb;
	-webkit-box-shadow: 0 5px 5px rgba(0,0,0,0.2);
	-moz-box-shadow: 0 2px 2px rgba(0,0,0,0.2);
 */	
}

/* div.loginTb{
	border: 1px solid red;
	position: inherit;
	width: 100%;
	height: 100%;
	
}
 */

div[class$='Div']{
	font-size: 5pt; 
	color: red;
}
</style>
 
<form>
<div id="loginForm" align="center">
	<h2>로그인</h2>
	<table class="loginTb">
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
			<input type="button" class="btnLogin" value="로그인" style="width:100%; padding: 5px 0; margin: 5px 0;">
			<input type="button" value="회원가입" style="width:100%; padding: 5px 0;" onclick="location.href='/semiProject/member/signupForm.do'">
			<div class="isLoginDiv"></div>
			</td>		
		</tr>
	</table>
</div>
</form>


<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$().ready(function(){
	$('.btnLogin').click(function(){		
		if($('.id').val() == ""){
			$('.idDiv').empty();
			$('.idDiv').append('아이디를 입력하세요.');
		}
		else if ($('.pwd').val() == ""){
			$('.idDiv, .pwdDiv').empty();
			$('.pwdDiv').append('비밀번호를 입력하세요');
		}
		else {
			$('.pwdDiv').empty();
			$.ajax({
				type: 'post',
				url: '/semiProject/member/login.do',
				data: {'id': $('.id').val(), 
					'pwd': $('.pwd').val(), 
					'rememberMe' : $('.rememberMe').prop('checked')},
				dataType: 'json',
				success: function(data){
					if(data.result == 'ok'){
						location.href="/semiProject/main/index.do";
						
					}else {
						$('.isLoginDiv').append('아이디 또는 비밀번호가 틀립니다. ');
						$('.id').val('');
						$('.pwd').val('');
						$('.id').focus();
					}
					
				},
				error: function(){
					console.log("실패");
				}
				
			});
		}
	});
	
});
</script>