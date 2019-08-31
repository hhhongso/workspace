<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<% %>
<%
	//1페이지당 5개씩.
	int pg = Integer.parseInt(request.getParameter("pg"));
	int endNum = pg * 5;
	int startNum = endNum - 4;
	int totArticle = boardDAO.getTotArticle();
	int totPg = (totArticle + 4) / 5;
	List<BoardDTO> list = boardDAO.getList(startNum, endNum);

	SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd");
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
a.subject{
 	cursor:pointer; 
}
a.subject:hover{
	color:green;
	text-decoration: underline;
}
table{
	width: 100%;
/* 	border-top: 1px solid;
	border-collapse: collapse; */
	text-align: center;
}

th, td{
	border-bottom:1px solid;
	padding: 10px;
}

td.subject{
	text-align:left;
}
</style>
</head>
<body>
	<form name ="boardListForm" action="">
	<h3>글목록</h3>
	<%if(list !=null) { %>
		<table frame="hsides" rules="rows">
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성일 </th>
				<th>조회수 </th>
			</tr>
			<%for(BoardDTO boardDTO : list) {%>
			<tr>
				<td width=100px><%=boardDTO.getSeq()%></td>
				
				<td width=200px class= subject><a class="subject" onclick="isLogin('<%=(String)session.getAttribute("memId")%>', <%=boardDTO.getSeq()%>)"><%=boardDTO.getSubject()%></a></td>
				<td width=100px><%=boardDTO.getId()%></td>
				<td width=100px><%=sdf.format(boardDTO.getLogtime())%> </td>
				<td width=100px><%=boardDTO.getHit()%> </td>
			</tr>
			<%} %>
		</table>
	<% } %>
		
		<%for(int i = 1; i <= totPg; i++) { %>
			<%if(i == pg){ %>
			<a class="currPg" href="boardList.jsp?pg=<%=i%>">[ <%=i%> ]</a>
			<%} else { %>
			<a href="boardList.jsp?pg=<%=i%>">[ <%=i%> ]</a>
			<%} %>
		<%} %>
		<br>
		<img src="../image/ni.PNG" width=80 height=80 onclick ="location.href='../main/index.jsp'" style= "cursor:pointer;">메인으로 가기<br>
	</form>
</body>
<script src = "../js/board.js"></script>
</html>