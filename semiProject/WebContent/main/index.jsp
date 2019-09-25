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

<!-- jQuery 는 앞에 추가해주어야 읽을 수 있다 -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">


<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<header class="indexHeader">
	<jsp:include page="/template/headerMenu.jsp" />
</header>
<nav class="indexNav">
nav
</nav>

<section class="indexSection">
	<jsp:include page="${display }"/>
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

