<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="styleshee" href="../css/index.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href="http://fonts.googleapis.com/earlyaccess/nanumgothic.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato:400,700,900"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Oswald:400,500,600,700"
	rel="stylesheet">



<header class="indexHeader">
	<jsp:include page="/template/headerMenu.jsp" />
	<div class="visual">
		이벤트 창이나 슬라이더를 넣고 싶다
	</div>
</header>

<nav class="indexNav">
nav
</nav>

<section class="indexSection">
	<jsp:include page="/template/body.jsp"/>
</section>

<aside class="indexAside">
aside
</aside>

<footer class="indexFooter">
	<jsp:include page="/template/footerInfo.jsp"/>
</footer>

<!-- 이걸 어디에 써먹지 -->
<div class="top-border" style="display: none">
	<div class="link">
		<a href="/link/bookmark.html" target="_blank"
			onclick="winPop(this.href); return false;"
			class="xans-element- xans-layout xans-layout-bookmark "><span>Bookmark</span>
		</a> <a href="/link/shortcut.html" target="_blank"
			onclick="winPop(this.href); return false;"
			class="xans-element- xans-layout xans-layout-shortcut ">바로가기 </a>
	</div>
</div>
