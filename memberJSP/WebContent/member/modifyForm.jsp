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
<body onload="genderCheck(<%=gender%>); telCheck(<%=tel1%>); emailCheck(<%=email2%>);">

<form name = "modifyForm" method = "post" action = "modify.jsp">

  <h2> 개인정보수정 </h2>
  <table border = 3 cellspacing = "2" cellpadding = "2">
	  <tr>
	   <th width = 120> 이름  </th>
	   <td> <input type = "text" id = "irum" name = "name" size = 20 value = "<%=name%>"> </td>
	  </tr>
	  
	  <tr>
	   <th> 아이디 </th>
	   <td> 
	   	<input type = "text" name = "id" size = 25 value ="<%=id%>" readonly> 
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
	    <input type = "radio" class = "radio" name = "gender" value = "0"> 여성
	    <input type = "radio" class = "radio" name = "gender" value = "1"> 남성 
	   </td>   
	  </tr>
	
	  <tr>
	   <th> 이메일  </th>
	   <td> 
	    <input type = "text" name = "email1" size = 15 value ="<%=email1%>"> @
		<input name = email2 id = "email2" list = "mailaddr" size = 15">
			<datalist id = "mailaddr">
			 <option value = "gmail.com"> </option>
			 <option value = "naver.com"> </option>
			 <option value = "hotmail.com"> </option>
			</datalist>

	   </td>   
	  </tr>  
	
	  <tr>
	   <th> 핸드폰  </th>
	   <td> 
	    <select class = "tel" name = "tel1" id ="tel1">
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
	    <input type = "text" id = "daum_addr2" name = "addr2" size = 40 value="<%=addr2%>">    
	   </td>   
	  </tr>  
	
	  <tr>
	   
	   <td colspan = 2 align = "center"> 
	    <input type = "button" value = "회원정보수정" onclick = "checkModify()">   
	    <input type = "reset" value = "다시작성">   
	    <input type = "button" value = "회원탈퇴">   
	   </td>   
	  </tr>    
  </table>
 </form>
</body>
<script src = "../js/member.js"></script>
<script>
window.onload = function(){
	document.modifyForm.gender['<%=gender%>'].checked = true;
//	document.modifyForm.email2.value= '<%=email2%>';
	document.getElementById("email2").value = '<%=email2%>';
//	document.modifyForm.tel1.value = '<%=tel1%>';
	document.getElementById("tel1").value= '<%=tel1%>';
}
</script>
</html>