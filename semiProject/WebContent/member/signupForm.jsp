<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="date" class="java.util.Date"/>

<c:set var="now" value="${date }"/>
<fmt:formatDate var="today" value="${now }" pattern="yyyy-MM-dd"/>
<c:set var="year" value="${today.split('-')[0] }"/>
<c:set var="month" value="${today.split('-')[1] }"/>
<c:set var="day" value="${today.split('-')[2] }"/>

<input type="date"/>
<style>

div#signupForm{
	height: 300px;
	padding: 100px;
 	position: inherit;
	top: 50%; 
	left: 50%;	
}

div[class$='Div']{
	font-size: 5pt; 
	color: red;
}


.signupModal{
	display: none;  /*Hidden by default */
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
  
<form method="post" action="#"> <!-- /semiProject/member/signup.do -->
<div id="signupForm"align="center">
 <h2> 회원가입 </h2>
  <table>
	  <tr>
	   <th width = 120> 이름  </th>
	   <td> 
	   <input type = "text" id="name" name="name" size = 20 placeholder = "이름 입력"> 
	   <div class="nameDiv"></div>
	   </td>
	  </tr>
	  
	  <tr>
	   <th> 아이디 </th>
	   <td> 
	   	<input type = "text" id="id" name="id" size = 25 placeholder = "아이디 입력"> 
	   	<input type = "button" class="btnIsExisted" value = "중복체크"><br> 
	   	 <div class="idDiv"></div>
	   </td>
	  </tr>
	  
	  <tr>
	   <th> 비밀번호  </th>
	   <td> 
	   <input type = "password" id="pwd" name="pwd" size = 30> 
	   <div class="pwdDiv"></div>
	   </td>
	  </tr>
	  
	  <tr>
	   <th> 비밀번호 확인  </th>
	   <td>
	   <input type = "password" id="repwd" name = "repwd" size = 30> 
	   <div class="repwdDiv"></div>	
	   </td>
	  </tr>
	
	  <tr>
	   <th> 이메일  </th>
	   <td> 
	    <input type = "text" class = "email1" name="email1" size = 15> @
		<input list = "mailaddr" class = "email2" name="email2" size = 15 placeholder ="직접입력">
			<datalist id = "mailaddr">
			 <option value = "gmail.com"> </option>
			 <option value = "naver.com"> </option>
			 <option value = "hotmail.com"> </option>
			</datalist>

	   </td>   
	  </tr>  
	
	  <tr>
	   <th> 생년월일  </th>
	   <td> 
	    <select class= "birthYear" name="birthYear"></select> 년   
	    <select class="birthMonth" name="birthMonth"></select> 월
	    <select class="birthDay" name="birthDay"></select> 일
	   </td>   
	  </tr>  
	  
	  <tr>
	   
	   <td colspan = 2 align = "center"> 
	    <input type = "button" name ="sign" class="btnSubmit" value = "회원가입">
	    <input type = "reset" value = "다시작성">     
	   </td>   
	  </tr>    
  </table>
 </div>
  </form>


<div class="signupModal">
	<div class="signupModalContent">
		  <p class="msg" style="text-align: center;"></p>
		  <input type="button" class="btnClose" value="메인 화면으로">
	</div>
</div>


<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/member.js"></script>
<script>
var today = new Date();

window.onload = function(){
	for (var i = 1900; i <= today.getFullYear(); i++) {
		$('.birthYear').append('<option>'+i+'</option>');	}
	
	for (var i = 1; i <= 12 ; i++) {
		$('.birthMonth').append('<option>'+i+'</option>');	}
	
	for (var i = 1; i <= 31; i++) {
		$('.birthDay').append('<option>'+i+'</option>');	}
}

$().ready(function(){	
	$('.birthYear, .birthMonth').change(function(){
		var birthday = new Date($('.birthYear').val(), $('.birthMonth').val(), 0);
		lastdate = birthday.getDate();
		$('.birthDay').empty();
		for (var i = 1; i <= lastdate ; i++) {
			$('.birthDay').append('<option>'+i+'</option>');
		}
	});

	$('#name, #id, #pwd, #repwd').keyup(function(){
		checkSignup();
		
	});
	
	$('.btnSubmit').click(function(){
		if(checkSignup()){
			//$('form').submit();
			
			$.ajax({
				type: 'post',
				url: '/semiProject/member/signup.do',
				data: { 'name' : $('#name').val(),					
					'id' : $('#id').val(),
					'pwd' : $('#pwd').val(),
					'email1': $('.email1').val(),
					'email2': $('.email2').val(),
					'birthYear': $('.birthYear').val(),
					'birthMonth': $('.birthMonth').val(),
					'birthDay': $('.birthDay').val()
				
				},
				dataType: 'text',
				success: function(result){
					$('.signupModal').show();
					$('.msg').text(result);
				},
				error: function(){
					console.log('실패');
				}
			});
			 
		}
		
	});
	
	$('.btnIsExisted').click(function(){
		if($('#id').val().length >= 5 && $('#id').val().length <= 10){
			$.ajax({
				type: 'get',
				url: '/semiProject/member/isExistedId.do',
				data: {'id' : $('#id').val() },
				dataType: 'text',
				success: function(result){
					$('.idDiv').empty();
					if(result.trim() == 'able'){
						$('.idDiv').append('사용 가능한 아이디 입니다. ').css('color', 'blue');			
					} else if(result.trim() == 'unable'){
						$('.idDiv').append('중복된 아이디 입니다. ').css('color', 'red');
					}
				},
				error: function(){
					console.log('실패');
				}
			});
			
			 
		 }
	});	
	
	
	$('.btnClose').click(function(){
		$('.signupModal').hide();
		location.href='/semiProject/main/index.do';
	});
	
});
</script>