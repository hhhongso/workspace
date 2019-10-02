<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<c:if test="${qnaDTO != null }">
	<form action="">
		<table class="table table-striped">
			<tr>
				<td colspan = 3><h3>${qnaDTO.subject }</h3></td>
			</tr>
			<tr>
				<td>글번호: ${qnaDTO.seq }</td>
				<td>작성자: ${qnaDTO.name }</td>
				<td>조회수: ${qnaDTO.hit }</td>
			</tr>
			<tr>
				<td class="content" colspan = 3 valign="top"><pre style="height:200px;"> ${qnaDTO.content }</pre>
				</td>
			</tr>		
		</table>
		
<!-- 댓글 영역 -->		
		<c:if test="${list != null}">
			<table class="commentTb table " style="background-color: #e3e8e5; " class="table">
				<thead> 댓글 </thead>
				<c:forEach var="commentDTO" items="${list }">
				<tr class="subject" id="subject${commentDTO.seq }">
					<input type="hidden" class="seq" value="${commentDTO.seq }">
					<td>${commentDTO.id }</td>
					<td class="subject${commentDTO.seq }">${commentDTO.content }</td>
					<td align="right">
					<c:if test="${memDTO.id == commentDTO.id }">
						<input type="button" class="modifyComment btn" value="수정">
						<input type="button" class="delComment btn" value="삭제">					 
					</c:if>
					${commentDTO.logtime }</td>
				</tr>	
						
				</c:forEach>
			</table>
		</c:if>
		<div class="commentDiv"></div><br>	
		<div class="btnList"></div>
	</form>
</c:if>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="../js/qna.js"></script>
<script>
$().ready(function(){	
	//js 파일을 따로 빼면 아래 memDTO, qnaDTO 값을 가져오지 못함 
	if('${memDTO.id}' == '${qnaDTO.id}'){
		$('.btnList').append('<input type="button" class="modifyQNA" value="글수정">');
		$('.btnList').append('<input type="button" class="deleteQNA" value="글삭제">');
	}
	
	$('.commentDiv').append('<textarea class="txtComment" style="float:left; width: 80%; margin: 0 20px; height: 50px;"></textarea>');
	$('.commentDiv').append('<input type="button" class="writeComment" value="댓글 등록" style="padding: 15px 0; width: 15%">');
	$('.btnList').append('<input type="button" class="getQNAList" value="목록">');
	$('.btnList').append('<input type="button" class="replyQNA" value="답글쓰기">');
		
	$('input[type="button"]').addClass("btn btn-default");
	
	//답글 달기
	$('.replyQNA').click(function(){
		location.href='/semiProject/qna/qnaBoardReplyForm.do?seq=${qnaDTO.seq}&pg=1';
	});
	
	//댓글 달기
	 $('.commentDiv, .subject').on('click', '.writeComment', function(){
		 $.ajax({
			type: 'post',
			url: '/semiProject/qna/qnaBoardCommentWrite.do',
			data: {"bseq": "${qnaDTO.seq }",
				"id": "${memDTO.id}",
				"name": "${memDTO.name}",
				"content": $('.txtComment').val()
				},
			dataType: 'json',
			success: function(data){
				//여기로 다시 돌아와야함 	
				location.href=data.url+'?seq=${qnaDTO.seq }&pg=1';
			},
			error: function(){
				console.log('실패');
			}
			
		});
	});
	
	//댓글 수정
	var sw = 0; 
	$('.subject').on('click', $('.modifyComment'), function(){		
		var attr = $(this).attr('id');
		$('.'+attr).html('<textarea class="txtComment" style=" width: 100%;">'+$('.'+attr).text()+ '</textarea>');
		/* $('.modifyComment').click(function(){
			$('.subject').off('click');
			$.ajax({
				type: 'post',
				url: '/semiProject/qna/qnaBoardModify.do',
				data: {"seq": $('.seq').val(),
					"content": $('.txtComment').text(),
					},
				dataType: 'json',
				success: function(data){
					console.log('성공');
					location.href=data.url+'?seq=${qnaDTO.seq }&pg=1';
				},
				error: function(){
					console.log('실패');
				}				
			});
		}); */
		
	});
	
/*  $(document).ready(function(){
	      $('.content_wrap').hide();
	      $('.subject_wrap').on({
	         click : function(){
	            var aaa = $(this).attr('id');
	            $('.'+aaa).slideToggle();
	         }
	      },'a');
	});
 */
});
</script>