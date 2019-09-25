<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */
	padding: 20px;
	border: 1px solid #888;
	width: 30%; /* Could be more or less, depending on screen size */
}

div#loginForm{
	padding: 30px;
	display:inline; 
	position:absolute; 
	top: 30%; 
	left: 30%;
	/* background: #ebebeb; */
	-webkit-box-shadow: 0 5px 5px rgba(0,0,0,0.2);
	-moz-box-shadow: 0 2px 2px rgba(0,0,0,0.2);
	
}
</style>
 
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<div id="loginForm"align="center">
	<h2>로그인</h2>
	<table>
		<tr>
			<th width="70px"> 아이디 </th>
			<td> <input type="text" placeholder="아이디를 입력하세요" required autofocus></td>		
		</tr>
		
		<tr>
			<th> 비밀번호 </th>
			<td> <input type="password" placeholder="비밀번호를 입력하세요" required></td>		
		</tr>
		
		<tr><td colspan=2><input type="checkbox" value="remember-me"> 로그인 유지</td> 	</tr>
		<tr>
			<td colspan=2 align="center"> 
			<label>아이디/비밀번호 찾기</label> <br>
			<input type="button" value="로그인" style="width:100%;"></td>		
		</tr>
	</table>
</div>


<div id="myModal" class="modal">
	 <div class="modal-content">
                <p id="msg"></p>
            <input type="button" class="btn" value="닫기" onclick="close_pop();">            
      </div>
</div>



    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	$('#myModal').show();
});

function close_pop(){
	$('#myModal').hide();
};
</script>