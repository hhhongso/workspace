<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- <%
//조회수: 새로고침 방지 
Cookie[] arr = request.getCookies();
if(arr !=null) {	
	for(int i =0; i < arr.length; i++){
		if(arr[i].getName().equals("memHit")){
			boardDAO.updateHit();
			arr[i].setMaxAge(0);
			response.addCookie(arr[i]);
		}
	}
}

%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="">
.content{
/* 	width: 400px;
	height: 200px;  */
/* 	text-align:top; */
	white-space:pre-line; 
 	word-break: break-all;
	overflow:auto;
}
</style>
</head>
<body>
<c:if test="${boardDTO != null }">
	<form action="">
		<table frame="hsides" rules="rows" style="width:400px; height:200px;">
			<tr>
				<td colspan = 3><font size=7pt><b>${boardDTO.subject }</b></font></td>
			</tr>
			<tr>
				<td>글번호: ${boardDTO.seq }</td>
				<td>작성자: ${boardDTO.name }</td>
				<td>조회수: ${boardDTO.hit }%></td>
			</tr>
			<tr>
				<td class="content" colspan = 3 valign="top"> ${boardDTO.content }%>
				</td>
			</tr>		
		</table>
		<input type="button" value="글수정" onclick="location.href='/mvcBoard/board/boardModifyForm.do?seq=${boardDTO.seq }&pg=${pg }'">
		<input type="button" value="글삭제" onclick="">
		<input type="button" value="목록으로" onclick="location.href='/mvcBoard/board/boardList.do?pg=${pg }'"> <br>
		
	</form>
</c:if>
</body>
<script>
window.onload = function(){

	
		
}
</script>
</html>