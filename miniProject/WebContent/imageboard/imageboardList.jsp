<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
.imageboard td{
	text-align:center;
}

#currPaging {
	text-decoration: underline;
	color: red;
	font-weight: bold;
}
</style>
<form name="imageboardListForm" method="get" action="/miniProject/imageboard/imageboardDelete.do">
	<c:if test="${list !=null }">
		<table class="imageboard" frame="hsides" rules="rows">
			<tr>
				<th><input type="checkbox" class="cbxMain" onclick="cbxChecked()">	번호</th>
				<th>이미지</th>
				<th>상품명</th>
				<th>단가 </th>
				<th>개수 </th>
				<th>합계 </th>
			</tr>
			<c:forEach var="imageboardDTO" items="${list }">
			<tr>
				<td width=100px>
				<input type="checkbox" class="cbx" name="cbx" value="${imageboardDTO.seq }">${imageboardDTO.seq }</td>	
				<td width=100px>
					<img src="../storage/${imageboardDTO.image1 }" style="width:100px; cursor:pointer;" 
					onclick="location.href='/miniProject/imageboard/imageboardView.do?seq=${imageboardDTO.seq }&pg=${imageboardPaging.currentPage }'">
				<td width=400px>${imageboardDTO.imageName }</td>
				<%-- 이 방법으로도 가능 
				<fmt:formatNumber pattern="#,###" value="${imageboardDTO.imagePrice }"/> --%>
				
				<td width=100px>${String.format("%,d", imageboardDTO.imagePrice) } </td>
				<td width=100px>${String.format("%,d",imageboardDTO.imageQty) } </td>
				<td width=100px>${String.format("%,d", imageboardDTO.imagePrice * imageboardDTO.imageQty)} 원</td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
	<div style="text-align:center;">${imageboardPaging.pagingHTML}</div>
	<div><input type="button" value="선택 삭제" onclick="delConfirm()"></div>
</form>

<script src="../js/imageboard.js"></script>
