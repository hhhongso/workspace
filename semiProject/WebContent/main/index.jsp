<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	<jsp:include page="/template/asideBar.jsp"/>
</aside>

<footer class="indexFooter">
	<jsp:include page="/template/footerInfo.jsp"/>
</footer>
    