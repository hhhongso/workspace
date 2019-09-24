<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<style>
li{	margin: 10px;}

img{	
	width: 300px;
	margin: 10px;
}
</style>

    <c:if test="${imageboard != null }">
		<img src="../storage/${imageboard.image1 }" align="left">
		<div id="zoom" style="position: relative; top:0px; left:-320px;"></div>	
		
			<li> 상품명: ${imageboard.imageName } <br></li>
			<li> 단가: ${String.format("%,d",imageboard.imagePrice) } <br></li>
			<li> 개수: ${String.format("%,d",imageboard.imageQty) } <br></li>
			<li> 합계: ${String.format("%,d", imageboard.imagePrice * imageboard.imageQty) } <br></li>
			<li> 내용: <br>
			<pre>${imageboard.imageContent}</pre></li>
		
		<input type="button" value="목록" onclick="location.href='../imageboard/imageboardList.do?pg=${pg}'">  
   </c:if>
   
<script>
window.onload = function(){
var zoomImg = document.createElement("img");
zoomImg.setAttribute("src", "../image/zoom.png");
zoomImg.setAttribute("style", " width:30px; height:30px; cursor:pointer;")
zoomImg.setAttribute("onclick", "zoomImage()");

var image1 = document.getElementById("zoom");
//var image1 = document.getElementsByTagName("div").item(0);
image1.appendChild(zoomImg);
}

function zoomImage(){
	var newWindow = window.open("", "", "width:500, height:500");
	var img = newWindow.document.createElement("img");
	img.setAttribute("src", "http://localhost:8080/miniProject/storage/${imageboard.image1 }");
								//chrome 은 상대번지로 불가. 절대번지 이용
	img.setAttribute("style", " width:500px; height:500px;")
	
	newWindow.document.body.appendChild(img);
}
</script>