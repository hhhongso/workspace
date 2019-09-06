<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "memberJSP.dao.MemberDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복검사</title>
</head>
<body>

<form>
${id } 는 사용 가능합니다. 
<br><br>
<input type = "button" value = "아이디 사용" onclick ="checkIdClose('${id}')">

	
</form>
</body>
<script src="../js/member.js"></script>
</html>