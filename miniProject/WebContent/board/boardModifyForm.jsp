<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style type="">
th{ width: 100px;}
.text{
	width:400px;
	}
</style>

<c:if test="${boardDTO != null }">
	<form name="boardModifyForm" method="post" action="/miniProject/board/boardModify.do">
	<input type="hidden" name="seq" value="${boardDTO.seq }">
	<input type="hidden" name="pg" value="${pg }">
		<h3> 글수정 </h3>
		<table border="10">
			<tr>
				<th>제목</th>
				<td><input type="text" class="text" id ="subject" name="subject" value="${boardDTO.subject }"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea class="text" id ="content" name="content" style="height:200px; overflow:auto;">${boardDTO.content }</textarea>
			</tr>	
			
			<tr>
				<td colspan=2 align="center">
					<input type="button" value="글수정" onclick="checkBoard()">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</c:if>
<script src="../js/board.js"></script>