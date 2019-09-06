<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script>
window.onload = function(){
	alert("게시글이 수정되었습니다. ");
	location.href="/mvcBoard/board/boardList.do?pg="+${pg};
}

</script>
</html>