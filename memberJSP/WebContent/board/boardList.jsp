<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<%
	//1페이지당 5개씩.
	request.setCharacterEncoding("UTF-8");
	int pg = Integer.parseInt(request.getParameter("pg"));
	int endNum = pg * 5;
	int startNum = endNum - 4;
	int totArticle = boardDAO.getTotArticle();
	int totPg = (totArticle + 4) / 5;
	List<BoardDTO> list = boardDAO.getList(startNum, endNum);

	SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.DD");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="">
a:link{ color: black; text-decoration:none; font-weight:bold;}
a.currPg{
	color:red;
	text-decoration:underline;
}
table{
	width: 100%;
	border-top: 1px solid;
	border-collapse: collapse;
	text-align: center;
}

th, td{
	border-bottom:1px solid;
	padding: 10px;
}
</style>
</head>
<body>
	<form action="">
		<table>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일 </th>
			<th>조회수 </th>
		</tr>
		<%for(BoardDTO boardDTO : list) {%>
		<tr>
			<td><%=boardDTO.getSeq()%></td>
			<td><%=boardDTO.getSubject()%></td>
			<td><%=boardDTO.getId()%></td>
			<td><%=sdf.format(boardDTO.getLogtime())%> </td>
			<td><%=boardDTO.getHit()%> </td>
		</tr>
		<%} %>
		</table>
		
		<%for(int i = 1; i <= totPg; i++) { %>
			<%if(i == pg){ %>
			<a class="currPg" href="boardList.jsp?pg=<%=i%>">[ <%=i%> ]</a>
			<%} else { %>
			<a href="boardList.jsp?pg=<%=i%>">[ <%=i%> ]</a>
			<%} %>
		<%} %>
	</form>
</body>
</html>