<%@page import="memberJSP.dao.MemberDAO"%>
<%@page import="memberJSP.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	alert("정보가 수정되었습니다.");
	location.href = "/mvcMember/member/loginForm.do";
	
}
</script>
</html>