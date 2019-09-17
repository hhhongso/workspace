<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
li{
	margin: 10px;
}

img{	
	width: 400px;
	margin: 10px;
	
}
</style>
    <c:if test="${imageboard != null }">
		<img src="../storage/${imageboard.image1 }" align="left">
		<li> 상품명: ${imageboard.imageName } <br></li>
		<li> 단가: ${String.format("%,3d",imageboard.imagePrice) } <br></li>
		<li> 개수: ${String.format("%,3d",imageboard.imageQty) } <br></li>
		<li> 합계: ${String.format("%,3d", imageboard.imagePrice * imageboard.imageQty) } <br></li>
		<li> 내용: <br>
		<pre>${imageboard.imageContent}</pre></li> 
		<br><br>
		
		<input type="button" value="목록" onclick="location.href='../imageboard/imageboardList.do?pg=${pg}'">
		
    
    </c:if>