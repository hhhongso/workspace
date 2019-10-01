<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>

.signupModal{
/*	display: none;  Hidden by default */
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

.signupModalContent{
	border-radius: 1.2em;
	background-color: #fefefe;
	margin: 15% auto; /* 15% from the top and centered */ 
	padding: 20px;
	border: 1px solid #888;
	width: 50%;
	height:50%;
	top: 30%;
}
</style>

<div style="position:inherit; ">
<div class="signupModal">
	<div class="signupModalContent">
		  <p class="msg" style="text-align: center;"> 로그아웃 되었습니다. </p>
		  <input type="button" class="btnClose btn btn-default" value="메인 화면으로">
	</div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$('.btnClose').click(function(){
	$('.signupModal').hide();
	location.href='/semiProject/main/index.do';
});
</script>