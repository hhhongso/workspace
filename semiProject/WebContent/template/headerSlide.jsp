<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
img.slide1{
	align-content: center;
	width: 800px; 
	height: 300px; 	
}
</style>

	<div align="center" style="margin: 10px;">
		<img class="slide1" src="../image/slide3.jpg">
		<img class="slide1" src="../image/slide4.jpg">
		<img class="slide1" src="../image/slide5.jpg">
	
	</div>


<script>
/*$(document).ready(function(){
	$('img').fadeOut(3000);
	
});
*/
 
var index = 0; 
window.onload = function(){
	slideShow();
}

function slideShow(){
	var i; 
	var x = document.getElementsByClassName("slide1");
	for (var i = 0; i < x.length; i++) {
		x[i].style.display = "none";
	}
	index++; 
	if(index > x.length) index = 1;
	
	x[index-1].style.display = "block";
	setTimeout(slideShow, 3000);
} 
</script>