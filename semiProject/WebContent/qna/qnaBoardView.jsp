<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:if test="${qnaDTO != null }">
	<form action="">
		<table frame="hsides" rules="rows" style="width:400px; height:200px;">
			<tr>
				<td colspan = 3><font size=7pt><b>${qnaDTO.subject }</b></font></td>
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
		<c:if test="${memId == qnaDTO.id }">		
			<input type="button" value="글수정" onclick="location.href='/miniProject/board/boardModifyForm.do?seq=${qnaDTO.seq }&pg=${pg }'">
			<input type="button" value="글삭제" onclick="delConfirm(${qnaDTO.seq})">
		</c:if>
		<input type="button" value="목록" onclick="location.href='/miniProject/board/boardList.do?pg=${pg }'">
		<input type="button" value="답글쓰기" onclick="location.href='/miniProject/board/boardReplyForm.do?pg=${pg }&pseq=${qnaDTO.seq}'"> <br>
		
	</form>
</c:if>