<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="qnaReply">
<h2>QNA - 답변 </h2>
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
	<input type="button" class="qnaReplyWrite btn btn-default" value="작성">
	<input type="reset" class="btn btn-default" value="취소">
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$().ready(function(){
	$('.qnaReplyWrite').on('click',function(){
		if($('#qnaReply .subject').val() == ''){
			$('#qnaReply .subjectDiv').empty();
			$('#qnaReply .subjectDiv').append('제목을 입력해 주세요.').css('color','red');
		}
		else{
			$('#qnaReply .subjectDiv').empty();
			$.ajax({
				type: 'post',
				url: '/semiProject/qna/qnaBoardReply.do',
				data: {'seq' : '${param.seq}', 
					'pg': '${param.pg}',
					'id' : '${memDTO.id}',
					'name' : '${memDTO.name}',
					'subject' : $('#qnaReply .subject').val(),
					'content': $('#qnaReply .content').val()},
				
				dataType: 'json',
				success: function(data){
					console.log("성공");
					console.log(data.url);
					location.href=data.url;
				},
				error: function(){
					console.log("실패");
				}
			});
		}
	});
});
</script>