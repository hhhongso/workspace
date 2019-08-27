<%@page import="memberJSP.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "memberJSP.dao.MemberDAO"%>
<%
String id = request.getParameter("id");

MemberDTO memberDTO = MemberDAO.getinstance().getInfo(id);
String name = memberDTO.getName();
id = memberDTO.getId();
String gender = memberDTO.getGender();
String email1 = memberDTO.getEmail1();
String email2 = memberDTO.getEmail2();
String tel1 = memberDTO.getTel1();
String tel2 = memberDTO.getTel2();
String tel3 = memberDTO.getTel3();
String zipcode = memberDTO.getZipcode();
String addr1 = memberDTO.getAddr1();
String addr2 = memberDTO.getAddr2();

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="genderCheck(); emailCheck(<%=email2%>); telCheck(); ">

<form name = "modifyForm" method = "" action = "">
  <h2> 개인정보수정 </h2>
  <table border = 3 cellspacing = "2" cellpadding = "2">
	  <tr>
	   <th width = 120> 이름  </th>
	   <td> <input type = "text" id = "irum" name = "name" size = 20 value = "<%=name%>" > </td>
	  </tr>
	  
	  <tr>
	   <th> 아이디 </th>
	   <td> 
	   	<input type = "text" name = "id" size = 25 value ="<%=id%>"> 
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
	    <input type = "radio" name = "gender" value = "1" > 남성
	    <input type = "hidden" name = "gendersw" value = <%=gender%>> 
	   </td>   
	  </tr>
	
	  <tr>
	   <th> 이메일  </th>
	   <td> 
	    <input type = "text" name = "email1" size = 15 value ="<%=email1%>"> @
		<input list = "mailaddr" size = 15">
			<datalist id = "mailaddr">
			 <option name = "email2" value = "gmail.com"> </option>
			 <option name = "email2" value = "naver.com"> </option>
			 <option name = "email2" value = "hotmail.com"> </option>
			</datalist>

	   </td>   
	  </tr>  
	
	  <tr>
	   <th> 핸드폰  </th>
	   <td> 
	    <select name = "tel1">
	     <option hidden name = "tel" value = <%=tel1%>> <%=tel1%></option>
	     <option value = "010"> 010 </option>
	     <option value = "019"> 019 </option>
	     <option value = "011"> 011 </option> </select>
	    <input type = "text" name = "tel2" size = 5 value="<%=tel2%>">
	    <input type = "text" name = "tel3" size = 5 value="<%=tel3%>">    
	   </td>   
	  </tr>  
	  
	
	  <tr>
	   <th> 주소  </th>
	   <td> 
	    <input type = "text" id = "daum_zipcode" name = "zipcode" size = 5 value="<%=zipcode%>" readonly> 
	    <input type = "button" value = "우편번호검색" onclick = "checkPost()"> <br>
	    <input type = "text" id = "daum_addr1" name = "addr1" size = 40 value="<%=addr1%>" readonly><br>
	    <input type = "text" id = "daum_addr2" name = "addr2" size = 40 value="<%=addr2%>" readonly>    
	   </td>   
	  </tr>  
	
	  <tr>
	   
	   <td colspan = 2 align = "center"> 
	    <input type = "button" value = "회원정보수정" onclick = "update()">   
	   </td>   
	  </tr>    
  </table>
 </form>
</body>
<script src = "/memberJSP/js/member.js"></script>
</html>