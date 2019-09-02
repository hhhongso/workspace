<%@page import="board.bean.BoardPaging"%>
<%@page import="memberJSP.bean.MemberDTO"%>
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
	int pg = Integer.parseInt(request.getParameter("pg"));
	int endNum = pg * 5;
	int startNum = endNum - 4;
	List<BoardDTO> list = boardDAO.getList(startNum, endNum);
	
	BoardPaging boardPaging = new BoardPaging();
	int totalArticle = boardDAO.getTotArticle();
	boardPaging.setCurrentPage(pg);
	boardPaging.setPageBlock(3);
	boardPaging.setPageSize(5);
	boardPaging.setTotalArticle(totalArticle);	
	boardPaging.makePagingHTML();
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd");
	
	Cookie[] arr = request.getCookies();
	if(arr !=null) {
		for(int i =0; i < arr.length; i++){
			if(arr[i].getName().equals("board")){
				arr[i].setMaxAge(0); //쿠키 삭제
				response.addCookie(arr[i]);				
			}
		}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/board.css">
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
				
				<td width=200px class= subject>
				<a href="javascript:void(0)" class="subject" onclick="isLogin('<%=(MemberDTO)session.getAttribute("memDTO")%>', <%=boardDTO.getSeq()%>, <%=pg%>)"><%=boardDTO.getSubject()%></a></td>
				<td width=100px><%=boardDTO.getId()%></td>
				<td width=100px><%=sdf.format(boardDTO.getLogtime())%> </td>
				<td width=100px><%=boardDTO.getHit()%> </td>
			</tr>
			<%} %>
		</table>
	<% } %>
		
		<div style="float:left; "><img src="../image/ninini.JPG" width=120 height=100 onclick ="location.href='../main/index.jsp'" style= "cursor:pointer;"></div>
		<div style="float:left; width: 80%; text-align: center; "> <%=boardPaging.getPagingHTML()%></div>
	</form>
</body>
<script src = "../js/board.js"></script>

</html>