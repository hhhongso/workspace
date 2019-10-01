<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<link rel="stylesheet" href="../css/index.css">    
<style> .logout{ cursor: pointer;}</style>
<!-- 메인 메뉴 -->
<div class="header_wrap">
<div class="header_holder">
	<div style="display: inline-block; left: 0px;">
		<h1 style="margin: 0; padding: 0;">
			<a class="headLogo" href="../main/index.do"
				style="text-decoration: none;"><strong>FUSE SEOUL</strong></a>
		</h1>
	</div>
	
	<div style="display: inline-block; float:right; ">
	<div style=" text-align: right; padding: 5px;">
	<c:if test="${memDTO.name != null }">
	${memDTO.name} 님 로그인
	</c:if>	
	</div> 

	<div style=" text-align: center; right: 0px;">
		<div id="nav" class=" menu_left">
				<ul>
					<li class="sub-menu-parent"><a href="#">Shop</a>
						<ul class="sub-menu" style="left: -12px">
							<li><a href="../shop/productTop.do">TOP</a></li>
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
							<li><a href="../qna/qnaBoardList.do">Q / A</a></li>
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
								<li><a class="logout">Log Out</a></li>
							</c:if>
						</ul>
					</li>
					
					<li class="sub-menu-parent" id="search-label"><a href="#">Search</a>
					</li>	
					
				</ul>
		</div>
	</div>	
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

