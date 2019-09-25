
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/index.css">    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<style>
.headerFixed{
	background-color:#ecf0f1;
	z-index:100;
	position: sticky;
	top: 0px;
}
</style>
<!-- 메인 메뉴 -->
<div class="header1" style="width:100%">
		<div style="display:inline-block; position: relative; margin: 0 auto;">
			<h1 class="xans-element- xans-layout xans-layout-logotop ">
				<a href="../main/index.do"><img class="headImg"
					src="/web/upload/category/logo/2cace9fc9027550a66bb092a1361775b_6_top.jpg"
					alt="FUSE SEOUL"></a>
			</h1>
		</div>

	<div style="display: inline-block; position: relative; width:70%; top: 0px; text-align: center; clear: both;">
		<div id="nav" class=" menu_left">
				<ul>
					<li class="sub-menu-parent"><a href="#">Shop</a>
						<ul style="left: -12px"
							class="xans-element- xans-layout xans-layout-category sub-menu">
							<li class="xans-record-"><a
								href="/product/list.html?cate_no=59">TOP</a></li>
							<li class="xans-record-"><a
								href="/product/list.html?cate_no=60">BOTTOM</a></li>
							<li class="xans-record-"><a
								href="/product/list.html?cate_no=89">SUIT</a></li>
							<li class="xans-record-"><a
								href="/product/list.html?cate_no=62">OUTER</a></li>
							<li class="xans-record-"><a
								href="/product/list.html?cate_no=63">ACC&amp;ETC</a></li>
							<li class="xans-record-"><a
								href="/product/list.html?cate_no=83">SALE</a></li>
						</ul></li>


					<li class="sub-menu-parent"><a href="#">Community</a>
						<ul class="sub-menu" style="left: -2px;">
							<li><a href="/board/free/list.html?board_no=1">Notice</a></li>
							<li><a href="/board/product/list.html?board_no=6">Q / A</a></li>
							<li><a href="/board/smartreview/list.html">Review</a></li>
						</ul></li>
					<li class="sub-menu-parent"><a href="#">Account</a>
						<ul style="left: -7px"
							class="xans-element- xans-layout xans-layout-statelogoff sub-menu ">
							<c:if test="${sessionScope.memId == null }">
								<li><a href="../member/loginForm.do" class="log">Login</a></li>
								<li><a href="/member/join.html">Join us</a></li>
							</c:if>

							<c:if test="${sessionScope.memId != null }">
								<li><a href="/order/basket.html">Cart<span
										class="count displaynone"><span>()</span></span></a></li>
								<li><a href="/myshop/index.html">Myshop</a></li>
								<li><a href="/myshop/wish_list.html">Wish list <strong></strong></a>
								</li>
								<li><a href="/myshop/order/list.html">Order list</a></li>
							</c:if>
						</ul></li>
					<li class="sub-menu-parent" id="search-label"><a href="#none"
						style="padding-right: 0px"><label for="keyword"
							id="search-label">Search </label></a></li>
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
	var hoffset = $('.headImg').offset();
	console.log(hoffset);
	$(window).scroll(function(){
	console.log($(document).scrollTop());
		if($(document).scrollTop() > hoffset.top) $('.indexHeader').addClass('headerFixed');
		else $('.indexHeader').removeClass('headerFixed');
	});
	
});
</script>