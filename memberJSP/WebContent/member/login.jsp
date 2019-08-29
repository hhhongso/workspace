<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="memberJSP.dao.MemberDAO"
    import = "memberJSP.bean.MemberDTO"%>

<jsp:useBean id="memberDTO" class="memberJSP.bean.MemberDTO"/>
<jsp:setProperty property="id" name="memberDTO"/>
<jsp:setProperty property="pwd" name="memberDTO"/>
<% memberDTO = MemberDAO.getinstance().isLogin(memberDTO.getId(), memberDTO.getPwd());
%>
<jsp:getProperty property="id" name="memberDTO"/>
<jsp:getProperty property="name" name="memberDTO"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="modifyForm.jsp">
<input type = "hidden" name ="id" value="<%=memberDTO.getId()%>">
<%	
	request.setCharacterEncoding("UTF-8");
	if(memberDTO.getName() != null) { 
		//1. get방식: 주소에 값을 태워보낼 때, 한글: UTF-8 으로 인코딩 해주어야 한다. 
		response.sendRedirect("loginOK.jsp?name="+URLEncoder.encode(memberDTO.getName(), "UTF-8"));
		
		
		//2. post 방식
//		request.getSession().setAttribute("id", memberDTO.getId());
//		request.getSession().setAttribute("name", memberDTO.getName());
	} else { 
		response.sendRedirect("loginFail.jsp");
	}
%>
		
</form>
</body>
</html>