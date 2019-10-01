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
				<td class="content" colspan = 3 valign="top"> ${qnaDTO.content }
				</td>
			</tr>		
		</table>
		<div class="commentList"></div>
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
		$('.commentDiv').append('<textarea class="txtComment" style="float:left; width: 80%; margin: 0 20px; height: 50px;"></textarea>');
		$('.commentDiv').append('<input type="button" class="writeComment" value="댓글 등록" style="padding: 15px 0; width: 15%">');
	}
	
	$('.btnList').append('<input type="button" class="getQNAList" value="목록">');
	$('.btnList').append('<input type="button" class="replyQNA" value="답글쓰기">');
		
	$('input[type="button"]').addClass("btn btn-default");
	
	$('.replyQNA').click(function(){
		location.href='/semiProject/qna/qnaBoardReplyForm.do?seq=${qnaDTO.seq}&pg=1';
	});
	
	$('.writeComment').click(function(){
		$('.commentList').append('<div>'+ $('.txtComment').val() +'</div>').css('background', 'green').css('margin', '20px 0; ');
		$('.txtComment').text("");
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