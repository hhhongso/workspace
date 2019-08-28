<%@page import="memberJSP.dao.MemberDAO"%>
<%@page import="memberJSP.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setName(request.getParameter("name"));
	memberDTO.setId(request.getParameter("id"));
	memberDTO.setPwd(request.getParameter("pwd"));
	memberDTO.setGender(request.getParameter("gender"));
	memberDTO.setEmail1(request.getParameter("email1"));
	memberDTO.setEmail2(request.getParameter("email2"));
	memberDTO.setTel1(request.getParameter("tel1"));
	memberDTO.setTel2(request.getParameter("tel2"));
	memberDTO.setTel3(request.getParameter("tel3"));
	memberDTO.setZipcode(request.getParameter("zipcode"));
	memberDTO.setAddr1(request.getParameter("addr1"));
	memberDTO.setAddr2(request.getParameter("addr2"));
	

	int cnt = MemberDAO.getinstance().update(memberDTO);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보수정 완료</title>
</head>
<body>
<%if(cnt != 0) { %>
<%=cnt%> 건 회원 정보 업데이트 완료
<% } else {%>
회원정보 업데이트 실패.
<% }%>
<% %>

</body>
</html>