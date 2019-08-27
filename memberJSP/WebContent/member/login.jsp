<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="memberJSP.dao.MemberDAO"
    import = "memberJSP.bean.MemberDTO"
    import= "java.util.List"%>
    
<% 
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

MemberDTO memberDTO = MemberDAO.getinstance().isLogin(id, pwd);
String name = memberDTO.getName();
id = memberDTO.getId();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	if(name != null) { %>
<%=name%> 님 로그인 <br><br>
<input type = "button" value = "로그아웃">
<input type = "button" value = "회원정보수정" 
onclick = "location.href ='/memberJSP/member/modifyForm.jsp?id=<%=id%>'">

<% } else { %>
	아이디 또는 비밀번호가 틀렸습니다. 다시 로그인해주세요.
<% } %>		
</body>
</html>