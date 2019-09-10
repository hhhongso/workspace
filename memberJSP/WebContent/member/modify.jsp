<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
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
</body>
<script type="text/javascript">
window.onload= function(){
	if(<%=cnt%> == 1) {
		alert("정보가 수정되었습니다.");
		location.href = "loginForm.jsp";
	} else {
		alert("정보 수정 실패");
		location.href = "modifyForm.jsp";
	}
	
}
</script>
</html>