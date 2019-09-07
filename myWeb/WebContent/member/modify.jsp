<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="memberDTO" class="member.bean.MemberDTO"/>
<jsp:setProperty property="*" name="memberDTO"/>
<% 
	MemberDAO.getinstance().updateInfo(memberDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 완료</title>
</head>
<body>
 수정완료 되었습니다. 
</body>
</html>