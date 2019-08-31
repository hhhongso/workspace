<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<%
int seq = Integer.parseInt(request.getParameter("seq"));

boardDAO.updateHit(seq);
BoardDTO boardDTO = boardDAO.getBoardView(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="">
.content{
	width: 400px;
	height: 200px;
	text-align:top;
	white-space:pre-line; 
	word-break: break-all;
	overflow:auto;
}
</style>
</head>
<body>
	<form action="">
		<table frame="hsides" rules="rows">
			<tr>
				<td colspan = 3><font size=10pt><b><%=boardDTO.getSubject()%></b></font></td>
			</tr>
			<tr>
				<td>글번호: <%=boardDTO.getSeq()%></td>
				<td>작성자: <%=boardDTO.getName()%></td>
				<td>조회수: <%=boardDTO.getHit()%></td>
			</tr>
			<tr>
				<td colspan = 3>
<%-- 				<input type="text" class="content" value="<%=boardDTO.getContent()%>" readonly> --%>
				<pre class="content"><%=boardDTO.getContent()%></pre>
				
				</td>
			</tr>		
		</table>
		<%if(session.getAttribute("memId").equals(boardDTO.getId())){ %>
		<input type="button" value="글수정" onclick="">
		<input type="button" value="글삭제" onclick=""> <br>
		<%} %>
		<img src="../image/ni.PNG" width=80 height=80 onclick ="location.href='../main/index.jsp'" style= "cursor:pointer;"> 메인으로 가기 <br>
		
	</form>
</body>
</html>