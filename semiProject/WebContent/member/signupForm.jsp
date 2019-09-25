<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>

div#signupForm{
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
<div id="signupForm"align="center">
 <h2> 회원가입 </h2>
  <table >
	  <tr>
	   <th width = 120> 이름  </th>
	   <td> <input type = "text" id = "irum" name = "name" size = 20 placeholder = "이름 입력"> </td>
	  </tr>
	  
	  <tr>
	   <th> 아이디 </th>
	   <td> 
	   	<input type = "text" name = "id" size = 25 placeholder = "아이디 입력"> 
	   	<input type = "button"  value = "중복체크" onclick = "checkId();"> 
	   	<input type = "hidden" name = "sw" value = "">
	   </td>
	  </tr>
	  
	  <tr>
	   <th> 비밀번호  </th>
	   <td> <input type = "password" name = "pwd" size = 30> </td>
	  </tr>
	  
	  <tr>
	   <th> 비밀번호 확인  </th>
	   <td> <input type = "password" name = "repwd" size = 30> </td>
	  </tr>
	
	  <tr>
	   <th> 이메일  </th>
	   <td> 
	    <input type = "text" name = "email1" size = 15> @
		<input list = "mailaddr" name = "email2" size = 15 placeholder ="직접입력">
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
	    <select name = "birthday">
	     <option value = "year"> 1990 </option>
	    </select>
	    
	    <select name = "month">
	     <option value = "month"> 01 </option>
	    </select>
	    
	    <select name = "day">
	     <option value = "day"> 31 </option>
	    </select> 
	   </td>   
	  </tr>  
	  
	  <tr>
	   
	   <td colspan = 2 align = "center"> 
	    <input type = "button" name ="sign" value = "회원가입" onclick = "checkWrite()">
	    <input type = "reset" value = "다시작성">     
	   </td>   
	  </tr>    
  </table>
 </div>