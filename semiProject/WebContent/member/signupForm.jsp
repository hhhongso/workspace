<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="../css/member.css">

<form method="post" action="#"> <!-- /semiProject/member/signup.do -->
<div id="signupForm" align="center">
 <h2> 회원가입 </h2>
  <table class="table table-striped" style="width: 50%;">
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
	   	<input type = "button" class="btnIsExisted btn btn-default" value = "중복체크"><br> 
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
	    <input type = "button" name ="sign" class="btn btn-default btnSubmit" value = "회원가입">
	    <input type = "reset" class="btn btn-default"value = "다시작성">     
	   </td>   
	  </tr>    
  </table>
	<div class="signupModal">
		<div class="signupModalContent">
			  <p class="msg" style="text-align: center;"></p>
			  <input type="button" class="btn btn-default btnClose" value="로그인 화면으로">
		</div>
	</div>
 </div>
  </form>


<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/member.js"></script>
