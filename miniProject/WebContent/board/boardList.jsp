<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<form name ="boardListForm" action="">
	<h3>글목록</h3>
	<c:if test="${list !=null }">
	
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
					<a href="javascript:void(0)" onclick="isLogin('${sessionScope.memId }', ${boardDTO.seq}, ${boardPaging.currentPage })"> ${boardDTO.subject }</a> </td>
				<td width=100px>${boardDTO.id }</td>
				<td width=100px>${boardDTO.logtime } </td>
				<td width=100px>${boardDTO.hit } </td>
			</tr>
			</c:forEach>
		</table>
	</c:if>	
	<div style="text-align:center;">${boardPaging.pagingHTML}</div>
	<div align="center">
		<select>
			<option value="name"> 이름으로 검색</option>
			<option value="id"> 아이디로 검색</option>
		</select>
		<input type="text" size="10">
		<input type="button" value="검색">
	</div>
	</form>

<script src = "../js/board.js"></script>
