<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<form name ="boardSearchListForm" action="">
	<h3>글목록</h3>
	<c:if test="${list.size() == 0}"> 찾는 게시글이 없습니다. </c:if>
	
	<c:if test="${list.size() != 0}">
	
		<table frame="hsides" rules="rows">
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성일 </th>
				<th>조회수 </th>
			</tr>
			<c:forEach var="boardDTO" items="${list }">
			<tr>
				<td width=100px>${boardDTO.seq }</td>	
				<td width=200px class= subject>
					<a href="javascript:void(0)" onclick="isLogin('${sessionScope.memDTO}', ${boardDTO.seq}, ${boardPaging.currentPage })"> ${boardDTO.subject }</a> </td>
				<td width=100px>${boardDTO.id }</td>
				<td width=100px>${boardDTO.logtime } </td>
				<td width=100px>${boardDTO.hit } </td>
			</tr>
			</c:forEach>
		</table>
	</c:if>	
	<div style="text-align:center;">${boardPaging.pagingHTML}</div>
	<div align="center">
		<select id="option" name="searchOp">
			<option id="subject" value="subject" selected> 제목으로 검색</option>
			<option id="id" value="id"> 아이디로 검색</option>
		</select>
		<input type="text" name="searchWord" size="10">
		<input type="button" value="검색" onclick="searchBoard()">
	</div>
	</form>

<script src = "../js/board.js"></script>