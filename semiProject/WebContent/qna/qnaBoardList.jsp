<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<style>
.QNABoard th {
	text-align:center;
}

a[id^="viewQNA_"]:hover { cursor: pointer;}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<h3>QnA 게시판 </h3>
	<c:if test="${list !=null }">
	
		<table class="QNABoard table table-striped table-hover">
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성일 </th>
				<th>조회수 </th>
			</tr>
			<c:forEach var="qnaDTO" items="${list }">
			<tr>
			<td width=100px class="qnaSeq">
				<c:if test="${qnaDTO.pseq == 0 }"> ${qnaDTO.seq}<span></span></c:if>
			</td>
				<td class="subject" width=400px>
				 	<c:if test="${qnaDTO.pseq !=0 }">
					 	<c:forEach var="i" begin="1" end="${qnaDTO.lev }" step="1">&emsp;</c:forEach>
					 	<img src="../image/reply.gif">
				 	</c:if>
				 	
<!--  a tag가 들어가야 하는 자리=============================================== -->
					<a id="viewQNA_${qnaDTO.seq }" style="text-decoration: none;">${qnaDTO.subject } </a> 
					<%--
					<c:set var="subject" value="${qnaDTO.subject }"/>
					<c:if test='${subject.contains("[원글이 삭제된 답글]") }'>					
						<font size="2" color="blue">${subject.substring(0, 12)}</font> 
						${subject.substring(12)}
					</c:if>				
					<c:if test='${!subject.contains("[원글이 삭제된 답글]") }'>
						${qnaDTO.subject }
					</c:if>
					 --%>
				</td>
				<td width=100px>${qnaDTO.id }</td>
				<td width=100px>${qnaDTO.logtime } </td>
				<td width=100px>${qnaDTO.hit } </td>
			</tr>
			</c:forEach>
		</table>
	</c:if>	
	<div style="text-align:center;">${boardPaging.pagingHTML}</div><br>

	<div align="center">
		<select id="searchOp" name="searchOp">
			<option id="subject" value="subject"> 제목으로 검색</option>
			<option id="id" value="id"> 아이디로 검색</option>
		</select>
		<input type="text" name="searchWord" size="10" value="${searchWord }">
		<input type="button" value="검색" onclick="searchBoard()">
	</div>
	
	<c:if test="${memDTO.id != null }">
		<input type="submit" class="writeQNA btn btn-default pull-right" value="글쓰기">
	</c:if>
    
    	

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
	$().ready(function(){
		$('.writeQNA').click(function(){
			location.href='/semiProject/qna/qnaBoardWriteForm.do';
		});
		
	 	$('a[id^="viewQNA_"]').on('click', function(){
			if('${memDTO.id}' == '') window.open("../member/loginForm.jsp", "로그인", "width:200px; height: 200px;");
			else{
				var seq = $(this).attr('id').substring(8);
	 			$(this).attr('href', '/semiProject/qna/qnaBoardView.do?seq='+seq+'&pg=1');
			}
		});
		
	
		
		
	});
</script>
