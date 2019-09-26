<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#topBar{
	position: fixed;
	top: 70%;
	display:none;
	cursor: pointer;
	/* z-index:100; */
}
</style>
<div id="topBar">
<img src="../image/logo.jpg" style="width: 50px; height:50px;">
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$().ready(function(){
	$(window).scroll(function(){
		if($(document).scrollTop() > 0) $('#topBar').fadeIn();
		else $('#topBar').fadeOut();
	});
	
	$('#topBar').click(function(){
		$('html, body').animate( { scrollTop : 0 }, 400 )
		return false;	
	});
	
});
</script>