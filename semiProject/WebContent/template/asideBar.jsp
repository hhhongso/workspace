<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
#topBar{
	position: fixed;
	top: 70%;
	display:none;
	cursor: pointer;
}
</style>

<img id="topBar" src="../image/logo.jpg" style="width: 50px; height:50px;">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$().ready(function(){
	$(window).scroll(function(){
		if($(document).scrollTop() > 0) $('#topBar').fadeIn();
		else $('#topBar').fadeOut();
	});
	
	$('img#topBar').click(function(){
		$(document).animate( { scrollTop : 0 }, 400 );
		return false;	
	});
	
});
</script>