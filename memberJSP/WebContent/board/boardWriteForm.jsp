<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
	<form name="boardWriteForm" method="post" action="boardWrite.jsp">
		<h3> 글쓰기 </h3>
		<table border="10">
			<tr>
				<th>제목</th>
				<td><input type="text" class="text" id ="subject" name="subject" size="20"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea class="text" id="content" name="content" style="height:200px; overflow:auto;"></textarea>
			</tr>	
			
			<tr>
				<td colspan=2 align="center">
					<input type="button" value="글쓰기" onclick="checkBoard()">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
<script src="../js/board.js"></script>
</html>