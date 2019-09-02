<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>

<%
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));


Cookie[] arr = request.getCookies();
Cookie tempCookie = null; 

if(arr !=null) {
	for(int i =0; i < arr.length; i++){
		if(arr[i].getName().equals("board")){			
			tempCookie = arr[i];
		}
	}
}

if(tempCookie == null) {
	Cookie cookie = new Cookie("board", seq+""); //쿠키 생성
//	cookie.setMaxAge(1); //초 단위
	response.addCookie(cookie); //클라이언트에 저장
	boardDAO.updateHit(seq);

}

BoardDTO boardDTO = boardDAO.getBoardView(seq);
%>
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
<%if(boardDTO != null) { %>
	<form action="">
		<table frame="hsides" rules="rows" style="width:400px; height:200px;">
			<tr>
				<td colspan = 3><font size=7pt><b><%=boardDTO.getSubject()%></b></font></td>
			</tr>
			<tr>
				<td>글번호: <%=boardDTO.getSeq()%></td>
				<td>작성자: <%=boardDTO.getName()%></td>
				<td>조회수: <%=boardDTO.getHit()%></td>
			</tr>
			<tr>
				<td class="content" colspan = 3 valign="top"><%=boardDTO.getContent()%>
<%-- 				<input type="text" class="content" value="<%=boardDTO.getContent()%>" readonly> --%>
<%-- 				<pre class="content"><%=boardDTO.getContent()%></pre> --%>
				
				</td>
			</tr>		
		</table>
		<%if(session.getAttribute("memId").equals(boardDTO.getId())){ %>
		<input type="button" value="글수정" onclick="location.href='boardModifyForm.jsp?seq=<%=boardDTO.getSeq()%>&pg=<%=pg%>'">
		<input type="button" value="글삭제" onclick="">
		<%} %>
		<input type="button" value="목록으로" onclick="location.href='boardList.jsp?pg=<%=pg%>'"> <br>
		<img src="../image/ni.PNG" width=80 height=80 onclick ="location.href='../main/index.jsp'" style= "cursor:pointer;"> 메인으로 가기 <br>
		
	</form>
<% } %>
</body>
<script>
window.onload = function(){

	
		
}
</script>
</html>