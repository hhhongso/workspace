<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


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

<c:if test="${boardDTO != null }">
	<form action="">
		<table frame="hsides" rules="rows" style="width:400px; height:200px;">
			<tr>
				<td colspan = 3><font size=7pt><b>${boardDTO.subject }</b></font></td>
			</tr>
			<tr>
				<td>글번호: ${boardDTO.seq }</td>
				<td>작성자: ${boardDTO.name }</td>
				<td>조회수: ${boardDTO.hit }</td>
			</tr>
			<tr>
				<td class="content" colspan = 3 valign="top"> ${boardDTO.content }
				</td>
			</tr>		
		</table>
		<c:if test="${memId == boardDTO.id }">		
			<input type="button" value="글수정" onclick="location.href='/miniProject/board/boardModifyForm.do?seq=${boardDTO.seq }&pg=${pg }'">
			<input type="button" value="글삭제" onclick="delConfirm(${boardDTO.seq})">
		</c:if>
		<input type="button" value="목록" onclick="location.href='/miniProject/board/boardList.do?pg=${pg }'">
		<input type="button" value="답글쓰기" onclick="location.href='/miniProject/board/boardReplyForm.do?pg=${pg }&pseq=${boardDTO.seq}'"> <br>
		
	</form>
</c:if>

<script src="../js/board.js"></script>