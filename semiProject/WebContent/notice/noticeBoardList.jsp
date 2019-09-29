<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<h3>공지사항</h3>
	<c:if test="${list !=null }">
	
		<table frame="hsides" rules="rows">
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>작성일 </th>
				<th>조회수 </th>
			</tr>
			<c:forEach var="boardDTO" items="${list }">
			<tr>
			<td width=100px>
				<c:if test="${boardDTO.pseq ==0 }">	${boardDTO.seq }</c:if>	 
			</td>
				<td class="subject" width=400px class= subject>
				 	<c:if test="${boardDTO.pseq !=0 }">
					 	<c:forEach var="i" begin="1" end="${boardDTO.lev }" step="1">&emsp;</c:forEach>
					 	<img src="../image/reply.gif">
				 	</c:if>
					<a href="javascript:void(0)" onclick="isLogin('${sessionScope.memDTO}', ${boardDTO.seq}, ${boardPaging.currentPage })"> 
					
					<c:set var="subject" value="${boardDTO.subject }"/>
					<c:if test='${subject.contains("[원글이 삭제된 답글]") }'>					
						<font size="2" color="blue">${subject.substring(0, 12)}</font> 
						${subject.substring(12)}
					</c:if>				
					<c:if test='${!subject.contains("[원글이 삭제된 답글]") }'>
						${boardDTO.subject }
					</c:if>
					</a> 
				</td>
				<td width=100px>${boardDTO.id }</td>
				<td width=100px>${boardDTO.logtime } </td>
				<td width=100px>${boardDTO.hit } </td>
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
	
	<c:if test="${memId == 'admin' }">
		<input type="submit" class="writeNotice" value="글쓰기">
	</c:if>

	
<script>
	$().ready(function(){
		$('.writeNotice').click(){
			location.href='/semiProject/notice/noticeBoardWrite.do';
		}
	});
</script>