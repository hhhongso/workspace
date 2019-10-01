<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="indexHeader">
	<jsp:include page="/template/headerMenu.jsp" />
</header>
<nav class="indexNav">
<div></div>
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


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../js/index.js"></script>