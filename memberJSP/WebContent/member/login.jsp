<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="memberJSP.dao.MemberDAO"
    import = "memberJSP.bean.MemberDTO"%>
    
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
<form method="post" action="modifyForm.jsp">
<input type = "hidden" name ="id" value="<%=id%>">
<%	if(name != null) { %>
<%=name%> 님 로그인 <br><br>
<input type = "button" value = "로그아웃" onclick="">
<input type = "submit" value = "회원정보수정">
<!-- post => 레스트풀로. 싣어가는 아이디를 보안시켜주어야 함. -->
<% } else { %>
	아이디 또는 비밀번호가 틀렸습니다. 다시 로그인해주세요.
<% } %>		
</form>
</body>
</html>