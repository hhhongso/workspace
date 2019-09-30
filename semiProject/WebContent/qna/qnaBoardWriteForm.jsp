<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="qna">
<h2>QnA</h2>
	<div>
		<label>작성자</label>&emsp; ${memDTO.name} <br>
		<label>제목 </label>&emsp;
		<input type="text" class="subject" class="subject">
		<div class="subjectDiv"></div>
	</div>
	<br>
	<textarea id="content" name="content" class="content" style="position: relative; width: 100%; height: 500px; overflow: auto;"></textarea><br>
	<div class="contentDiv"></div>
	<div align="center">
	<input type="button" class="qnaWrite" value="작성">
	<input type="reset" value="취소">
	</div>
</div>
    
    

<script>
$().ready(function(){
	$('.qnaWrite').click(function(){
		if($('#qna .subject').val() == '') {
			$('.subjectDiv').empty();
			$('.subjectDiv').append('제목을 입력하세요 ');
		} else if($('#qna .content').val() == ''){
			$('.subjectDiv, .contentDiv').empty();
			$('.contentDiv').append('내용을 입력하세요 ');
		} else {
			$('.contentDiv').empty();
			$.ajax({
				type: 'post',
				url: '/semiProject/qna/qnaBoardWrite.do',
				data: {"id": '${memDTO.id}' , "name": '${memDTO.name}', "subject": $('#qna .subject').val(), "content": $('#qna .content').val()},
				dataType:'text',
				success: function(data){
					console.log('성공');
					alert(data);
					location.href='/semiProject/qna/qnaBoardList.do';
				},
				error: function(){
					console.log('실패');
				}				
				
			});
		}
	});
});

</script>
    