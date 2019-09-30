<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
 
<h3>QnA 게시판 </h3>
	<c:if test="${list !=null }">
	
		<table frame="hsides" rules="rows">
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성일 </th>
				<th>조회수 </th>
			</tr>
			<c:forEach var="qnaDTO" items="${list }">
			<tr>
			<td width=100px>
				<span class="QnAseq"><c:if test="${qnaDTO.pseq ==0 }">	${qnaDTO.seq }</c:if></span>	 
			</td>
				<td class="subject" width=400px class= subject>
				 	<c:if test="${qnaDTO.pseq !=0 }">
					 	<c:forEach var="i" begin="1" end="${qnaDTO.lev }" step="1">&emsp;</c:forEach>
					 	<img src="../image/reply.gif">
				 	</c:if>
					<a class="viewQNA"> 
					
					<c:set var="subject" value="${qnaDTO.subject }"/>
					<c:if test='${subject.contains("[원글이 삭제된 답글]") }'>					
						<font size="2" color="blue">${subject.substring(0, 12)}</font> 
						${subject.substring(12)}
					</c:if>				
					<c:if test='${!subject.contains("[원글이 삭제된 답글]") }'>
						${qnaDTO.subject }
					</c:if>
					</a> 
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
		<input type="submit" class="writeQNA" value="글쓰기">
	</c:if>
    
    	
<script>

	$().ready(function(){
		$('.writeQNA').click(function(){
			location.href='/semiProject/qna/qnaBoardWriteForm.do';
		});
		
		$('.viewQNA').click(function(){
			if(${memDTO == null}) window.open("../member/loginForm.jsp", "로그인", "width: 300px; height: 300px;");
			else location.href="/semiProject/qna/qnaBoardView.do?seq="+ $('.QnAseq').text() +"&pg=1";
			
		});
	});
</script>