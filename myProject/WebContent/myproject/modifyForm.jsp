<%@page import="myProject.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="memberDTO" class="myProject.bean.MemberDTO"></jsp:useBean>
<% 
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	
	memberDTO = MemberDAO.getinstance().getInfo(id);
%>
<%-- <jsp:getProperty property="*" name="memberDTO"/> --%>
<% if(memberDTO != null) { %> <%} %> 
<jsp:getProperty property="name" name="memberDTO"/>
<jsp:getProperty property="id" name="memberDTO"/>
<jsp:getProperty property="pwd" name="memberDTO"/>
<jsp:getProperty property="gender" name="memberDTO"/>
<jsp:getProperty property="email1" name="memberDTO"/>
<jsp:getProperty property="email2" name="memberDTO"/>
<jsp:getProperty property="tel1" name="memberDTO"/>
<jsp:getProperty property="tel2" name="memberDTO"/>
<jsp:getProperty property="tel3" name="memberDTO"/>
<jsp:getProperty property="zipcode" name="memberDTO"/>
<jsp:getProperty property="addr1" name="memberDTO"/>
<jsp:getProperty property="addr2" name="memberDTO"/>
<jsp:getProperty property="logtime" name="memberDTO"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name = "modifyForm" method = "post" action="modify.jsp">
  <h2> 회원정보 수정 </h2>
  <table border = 3 cellspacing = "2" cellpadding = "2">
	  <tr>
	   <th width = 120> 이름  </th>
	   <td> <input type = "text" id = "irum" name = "name" size = 20 value="<%=memberDTO.getName()%>"> </td>
	  </tr>
	  
	  <tr>
	   <th> 아이디 </th>
	   <td> 
	   	<input type = "text" name = "id" size = 25 value="<%=memberDTO.getId()%>" readonly>
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
	   <th> 성별  </th>
	   <td> 
	    <input type = "radio" name = "gender" value = "0"> 여성
	    <input type = "radio" name = "gender" value = "1"> 남성
	   </td>   
	  </tr>
	
	  <tr>
	   <th> 이메일  </th>
	   <td> 
	    <input type = "text" name = "email1" size = 15 value="<%=memberDTO.getEmail1()%>"> @
		<input list = "mailaddr" name = "email2" id="email2" size = 15 placeholder ="직접입력">
			<datalist id = "mailaddr">
			 <option value = "gmail.com"> </option>
			 <option value = "naver.com"> </option>
			 <option value = "hotmail.com"> </option>
			</datalist>
		<br>
		인증번호 입력: <input type = 'text' size = 5> 
		<input type = 'button' value = '인증번호받기'>
	   </td>  
	  </tr>  
	
	  <tr>
	   <th> 핸드폰  </th>
	   <td> 
	    <select name = "tel1">
	     <option value = "010"> 010 </option>
	     <option value = "019"> 019 </option>
	     <option value = "011"> 011 </option> </select>
	    <input type = "text" name = "tel2" size = 5 value="<%=memberDTO.getTel2()%>">
	    <input type = "text" name = "tel3" size = 5 value="<%=memberDTO.getTel3()%>">    
	   </td>   
	  </tr>  
	  
	
	  <tr>
	   <th> 주소  </th>
	   <td> 
	    <input type = "text" id = "daum_zipcode" name = "zipcode" size = 5 readonly  value="<%=memberDTO.getZipcode()%>"> 
	    <input type = "button" value = "우편번호검색" onclick = "checkPost()"> <br>
	    <input type = "text" id = "daum_addr1" name = "addr1" size = 40 placeholder = "주소 " readonly value="<%=memberDTO.getAddr1()%>"><br>
	    <input type = "text" id = "daum_addr2" name = "addr2" size = 40 placeholder = "상세 주소 " value="<%=memberDTO.getAddr2()%>">    
	   </td>   
	  </tr>  
	
	  <tr>
	   
	   <td colspan = 2 align = "center"> 
	    <input type = "submit" value = "회원정보수정">
	    <input type = "reset" value = "다시작성">     
	   </td>   
	  </tr>    
  </table>
 </form>

</body>
</body>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="../js/member.js"></script>
<script>
window.onload = function (){
	document.modifyForm.gender[<%=memberDTO.getGender()%>].checked = true;
	document.getElementById("email2").value = '<%=memberDTO.getEmail2()%>';
	document.modifyForm.tel1.value = '<%=memberDTO.getTel1()%>';
	console.log(document.modifyForm.email2.value);
}
</script>
</html>