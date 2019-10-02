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
	<!--<textarea name="content" id="summernote" value=""></textarea> -->
	<textarea id="content" name="content" class="content" style="position: relative; width: 100%; height: 500px; overflow: auto;"></textarea><br>
	<div class="contentDiv"></div>
	<div align="center">
	<input type="button" class="qnaWrite btn btn-default" value="작성">
	<input type="reset" class="btn btn-default" value="취소">
	</div>
</div>
    
    
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<!-- include libraries(jQuery, bootstrap) -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
 
<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>

<!-- <script>
$(document).ready(function() {
    $('#summernote').summernote({
            height: 300,                 // set editor height
            minHeight: null,             // set minimum height of editor
            maxHeight: null,             // set maximum height of editor
            focus: true                  // set focus to editable area after initializing summernote
    });
});

</script> -->

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
    