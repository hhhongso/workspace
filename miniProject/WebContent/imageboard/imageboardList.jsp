<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<c:if test="${list !=null }">
		<table class="imageboard" frame="hsides" rules="rows">
			<tr>
				<th>번호</th>
				<th>이미지</th>
				<th>상품명</th>
				<th>단가 </th>
				<th>개수 </th>
				<th>합계 </th>
			</tr>
			<c:forEach var="imageboardDTO" items="${list }">
			<tr>
				<td width=100px>${imageboardDTO.seq }</td>	
				<td width=200px>
					<abbr title="${imageboardDTO.imageContent }">
					<a href="/miniProject/imageboard/imageboardView.do?seq=${imageboardDTO.seq }&pg=${boardPaging.currentPage }">
					<img src="../storage/${imageboardDTO.image1 }" style="width:200px;">
					</a>
					</abbr>
				<td width=200px>${imageboardDTO.imageName }</td>
				<td width=100px>${String.format("%,3d", imageboardDTO.imagePrice) } </td>
				<td width=100px>${String.format("%,3d",imageboardDTO.imageQty) } </td>
				<td width=100px>${String.format("%,3d", imageboardDTO.imagePrice * imageboardDTO.imageQty)} 원</td>
			</tr>
			</c:forEach>
		</table>
	</c:if>	
	<div style="text-align:center;">${boardPaging.pagingHTML}</div>
