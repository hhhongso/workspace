<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<%
int seq = Integer.parseInt(request.getParameter("seq")); 
int pg = Integer.parseInt(request.getParameter("pg"));
BoardDTO boardDTO = boardDAO.getBoardView(seq);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="">
th{ width: 100px;}
.text{
	width:400px;
	}
</style>
</head>
<body>
<%if(boardDTO != null){ %>
	<form name="boardModifyForm" id="boardModifyForm" method="post" action="boardModify.jsp?seq=<%=boardDTO.getSeq()%>">
		<h3> 글수정 </h3>
		<table border="10">
			<tr>
				<th>제목</th>
				<td><input type="text" class="text" id ="subject" name="subject" value="<%=boardDTO.getSubject()%>"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea class="text" id ="content" name="content" style="height:200px; overflow:auto;"><%=boardDTO.getContent()%></textarea>
			</tr>	
			
			<tr>
				<td colspan=2 align="center">
					<input type="button" value="글쓰기" onclick="checkBoardWrite()">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
<%} %>
</body>
<script src="../js/board.js"></script>
</html>