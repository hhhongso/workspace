<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/index.css">    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<style>
.headerFixed{
	background-color:white;
	z-index:100;
	position: sticky;
	top: 0px;
}
</style>
<!-- 메인 메뉴 -->
<div class="header1" style="width:100%">
	<div style="text-align: right; padding: 5px;">
	<c:if test="${memDTO.name != null }">
	${memDTO.name} 님 로그인
	</c:if>	
	</div> 

	<div style="display: inline-block; position: inherit; left: 0px;">
		<h1>
			<a class="headLogo" href="../main/index.do"
				style="text-decoration: none;"><strong>FUSE SEOUL</strong></a>
		</h1>
	</div>

	<div style="display: inline-block; float:right; text-align: center; position: inherit; right: 0px; top: 15px;">
		<div id="nav" class=" menu_left">
				<ul>
					<li class="sub-menu-parent"><a href="#">Shop</a>
						<ul class="sub-menu" style="left: -12px">
							<li><a href="#">TOP</a></li>
							<li><a href="#">BOTTOM</a></li>
							<li><a href="#">SUIT</a></li>
							<li><a href="#">OUTER</a></li>
							<li><a href="#">ACC&amp;ETC</a></li>
							<li><a href="#">SALE</a></li>
						</ul>
					</li>

					<li class="sub-menu-parent"><a href="#">Community</a>
						<ul class="sub-menu" style="left: -2px;">
							<li><a href="../notice/noticeBoardList.do">Notice</a></li>
							<li><a href="/board/product/list.html?board_no=6">Q / A</a></li>
							<li><a href="#">Review</a></li>
						</ul>
					</li>
					
					<li class="sub-menu-parent"><a href="#">Account</a>
						<ul class="sub-menu" style="left: -7px">
							<c:if test="${memDTO == null }">
								<li><a href="../member/loginForm.do" class="log">Login</a></li>
								<li><a href="../member/signupForm.do">Join us</a></li>
							</c:if>

							<c:if test="${memDTO != null }">
								<li><a href="#">Cart</a></li>
								<li><a href="#">Myshop</a></li>
								<li><a href="#">Wish list</a></li>
								<li><a href="#">Order list</a></li>
								<li><a href="#">Log Out</a></li>
							</c:if>
						</ul>
					</li>
					
					<li class="sub-menu-parent" id="search-label"><a href="#">Search</a>
					</li>	
					
				</ul>
		</div>
	</div>	
</div>	

<!-- 검색
<form id="searchBarForm" name="" action="/product/search.html"
	method="get" target="_self" enctype="multipart/form-data">
	<input id="banner_action" name="banner_action" value="" type="hidden">
	<div id="searchcontainer"
		class="xans-element- xans-layout xans-layout-searchheader ">
		<!--
                            $product_page=/product/detail.html
                            $category_page=/product/list.html
                        -
		<fieldset>
			<legend>검색</legend>
			<input id="keyword" name="keyword" fw-filter="" fw-label="검색어"
				fw-msg="" class="inputTypeText" placeholder=""
				onmousedown="SEARCH_BANNER.clickSearchForm(this)" value=""
				type="text">
		</fieldset>
		<div>Press Enter to Search</div>
	</div>
</form> -->

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
$().ready(function(){
	var hoffset = $('.headLogo').offset();
	$(window).scroll(function(){
		if($(document).scrollTop() > hoffset.top) $('.indexHeader').addClass('headerFixed');
		else $('.indexHeader').removeClass('headerFixed');
	});
	
});
</script>