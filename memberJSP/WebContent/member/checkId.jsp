<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "member.dao.MemberDAO"%>

<% 
//데이터 가져오기
String id = request.getParameter("id");

//DB => 중복검사
boolean isDup = MemberDAO.getinstance().isDuplicate(id);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복검사</title>
</head>
<body>
<%if(isDup) { // 구역표시가 반드시 있어야 하기 jsp 코드가 구역 안에 있음을 알 수 있다. !! %>
<form name="checkIdForm" method= "get" action="checkId.jsp">
	<%=id%> 는 이미 사용 중입니다.
	<br><br>
	아이디 <input type="text" name="id" size=10>
	<input type = "submit" value = "중복체크">
</form>
<% } else { %>
<%=id%> 는 사용 가능합니다. 
<% } %>
<br><br>
<input type = "button" value = "아이디 사용" onclick ="checkIdClose('<%=id%>')">
</body>
<script src="/memberJSP/js/member.js"></script>
</html>