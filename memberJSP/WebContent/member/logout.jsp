<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
//쿠키
/* Cookie[] arr = request.getCookies();

if(arr != null) {
	for(int i = 0; i < arr.length; i++) {
		if(arr[i].getName().equals("memName")) {
			arr[i].setMaxAge(0); //쿠키 삭제
			response.addCookie(arr[i]); //클라이언트에 저장
		}
		if(arr[i].getName().equals("memId")){
			arr[i].setMaxAge(0);
			response.addCookie(arr[i]);
		}
	}
}
 */
//세션 삭제
session.removeAttribute("memName");
session.removeAttribute("memId");

session.invalidate(); //모든 세션 비활성화(무효화)
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
window.onload = function(){
	alert("로그아웃되었습니다. ");
	location.href="../main/index.jsp";
}

</script>
</body>
</html>