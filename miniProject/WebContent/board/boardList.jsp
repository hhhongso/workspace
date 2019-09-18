<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
div a#currPaging {
	text-decoration: underline;
	color: red;
	font-weight: bold;
}
td{ text-align: center;}
td.subject { text-align: left;}
</style>
	<form name ="boardListForm" method="post" action="/miniProject/board/boardSearch.do?pg=1">
	<input type="hidden" name="sw2" value="0">
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
			<td width=100px>
				<c:if test="${boardDTO.pseq ==0 }">	${boardDTO.seq }</c:if>			 
			</td>
				<td class="subject" width=200px class= subject>
				 	<c:if test="${boardDTO.pseq !=0 }">
					 	<c:forEach var="i" begin="1" end="${boardDTO.lev }" step="1">&emsp;</c:forEach>
					 	<img src="../image/reply.gif">
				 	</c:if>
					<a href="javascript:void(0)" onclick="isLogin('${sessionScope.memDTO}', ${boardDTO.seq}, ${boardPaging.currentPage })"> 
					
					<c:set var="subject" value="${boardDTO.subject }"/>
					<c:if test='${subject.contains("[원글이 삭제된 답글]") }'>					
						<font size="2" color="blue">${subject.substring(0, 12)}</font> 
						${subject.substring(12)}
					</c:if>				
					<c:if test='${!subject.contains("[원글이 삭제된 답글]") }'>
						${boardDTO.subject }
					</c:if>
					</a> 
				</td>
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
			<option id="subject" value="subject"> 제목으로 검색</option>
			<option id="id" value="id"> 아이디로 검색</option>
		</select>
		<input type="text" name="searchWord" size="10">
		<input type="button" value="검색" onclick="searchBoard()">
	</div>
	</form>

<script src = "../js/board.js"></script>
