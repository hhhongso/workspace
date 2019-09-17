<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!-- 파일 업로드: 
1) method= 반드시 post 타입
2) enctype = multipart/form-data (multipart형식으로 읽어올 수 있도록 함) 

이클립스 상의 가상폴더 생성 (storage)

-->
    
<form name="imageboardWriteForm" method="post" enctype="multipart/form-data" action="/miniProject/imageboard/imageboardWrite.do">
	<table border=3>
		<tr>
			<th>상품코드</th>
			<td><input type="text" name="imageId" value="img_"></td>
		</tr>
		
		<tr>
		<th>상품명</th>
		<td><input type="text" name="imageName" placeholder="상품명 입력"></td>
		</tr>

		<tr>
			<th>단가</th>
			<td><input type="number" name="imagePrice" placeholder="단가 입력"></td>
		</tr>
		
		<tr>
			<th>갯수</th>
			<td><input type="number" name="imageQty" placeholder="갯수 입력"></td>
		</tr>

		<tr>
			<th>내용</th>
			<td><textarea name="imageContent" placeholder="내용입력" style="width:300px; height:200px;"></textarea></td>
		</tr>
		
		<tr>
			<td colspan=2><input type="file" name="image1" size="50"></td>
		</tr>
		
		<tr>
			<td colspan=2 align="center">
				<input type="button" value="이미지 등록" onclick="checkImageboard()">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
<script src="../js/imageboard.js"></script>