<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
	<form name="" method="post" enctype="multipart/form-data" action="fileUpload.jsp">
		<h3> 글쓰기 - 파일 올리기 </h3>
		<table border="10" style="width:400px; height:400px">
			<tr>
				<th>제목</th>
				<td><input type="text" class="text" id ="subject" name="subject" style="width:300px;"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea class="text" id="content" name="content" style="width:300px; height:300px; overflow:auto;"></textarea>
			</tr>
			
			<tr>
				<td colspan=2>
				<input type="file" name="upload1" size=50>
				</td>
			</tr>
			
			<tr>
				<td colspan=2>
				<input type="file" name="upload2" size=50>
				</td>
			</tr>
			
			<tr>
				<td colspan=2 align="center">
					<input type="submit" value="파일 업로드">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>