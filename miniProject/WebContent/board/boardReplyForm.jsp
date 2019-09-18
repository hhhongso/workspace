<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="">
th{ width: 100px;}
.text{ width:400px;}
</style>

<form name="boardReplyForm" method="post" action="/miniProject/board/boardReply.do">
	<input type="hidden" name="pg" value="${pg}">
	<input type="hidden" name="pseq" value="${pseq}">
	
	<h3>답글쓰기</h3>
	<table border="10">
		<tr>
			<th>제목</th>
			<td><input type="text" class="text" id="subject" name="subject"
				size="20"></td>
		</tr>

		<tr>
			<th>내용</th>
			<td><textarea class="text" id="content" name="content"
					style="height: 200px; overflow: auto;"></textarea>
		</tr>

		<tr>
			<td colspan=2 align="center">
				<input type="button" value="답글쓰기" onclick="checkBoard()">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
<script src="../js/board.js"></script>