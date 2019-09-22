
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../css/index.css">    
    
<!-- 메인 메뉴 -->    
<div class="header1">
	<div style="display:inline-block; position: relative; margin: 0 auto; width: 90%;">
		<h1 class="xans-element- xans-layout xans-layout-logotop ">
			<a href="/index.html"><img
				src="/web/upload/category/logo/2cace9fc9027550a66bb092a1361775b_6_top.jpg"
				alt="FUSE SEOUL"></a>
		</h1>

		<div
			style="display: block; position: absolute; right: 0%; top: 0px; text-align: center; clear: both; margin: 40px auto 0; z-index: 10;">

		<div id="nav" class=" menu_left">
				<ul>
					<li class="sub-menu-parent"><a href="#">project</a>

						<ul class="sub-menu" style="left: -2px;">
							<li><a href="/product/lookbook.html?cate_no=79">project
									01</a></li>
							<li><a href="/product/lookbook.html?cate_no=80">project
									02</a></li>
							<li><a href="/product/lookbook.html?cate_no=81">project
									03</a></li>
							<li><a href="/product/lookbook.html?cate_no=90">project
									04</a></li>
							<li><a href="/board/project-05/8/">project 05</a></li>

						</ul></li>

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
							<li><a href="/member/login.html" class="log">Login</a></li>
							<li><a href="/member/join.html">Join us</a></li>
							<li><a href="/order/basket.html">Cart<span
									class="count displaynone"><span>()</span></span></a></li>
							<li><a href="/myshop/index.html">Myshop</a></li>
							<li><a href="/myshop/wish_list.html">Wish list <strong></strong></a>
							</li>
							<li><a href="/myshop/order/list.html">Order list</a></li>
						</ul></li>
					<li class="sub-menu-parent" id="search-label"><a href="#none"
						style="padding-right: 0px"><label for="keyword"
							id="search-label">Search </label></a></li>
				</ul>
			</div>
		</div>
	</div>
</div>


<!-- 검색 -->
<form id="searchBarForm" name="" action="/product/search.html"
	method="get" target="_self" enctype="multipart/form-data">
	<input id="banner_action" name="banner_action" value="" type="hidden">
	<div id="searchcontainer"
		class="xans-element- xans-layout xans-layout-searchheader ">
		<!--
                            $product_page=/product/detail.html
                            $category_page=/product/list.html
                        -->
		<fieldset>
			<legend>검색</legend>
			<input id="keyword" name="keyword" fw-filter="" fw-label="검색어"
				fw-msg="" class="inputTypeText" placeholder=""
				onmousedown="SEARCH_BANNER.clickSearchForm(this)" value=""
				type="text">
		</fieldset>
		<div>Press Enter to Search</div>
	</div>
</form>