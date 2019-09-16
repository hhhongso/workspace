<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>
<link rel="stylesheet" href="../css/indexStyle.css">
<header>
<jsp:include page="top.jsp"/>
<jsp:include page="topMenu.jsp"/>
</header>

<nav>
<jsp:include page="leftLogin.jsp"/>
</nav>

<section>
<jsp:include page="body.jsp"/>
</section>

<aside>
<jsp:include page="right.jsp"/>
</aside>

<footer>
<jsp:include page="bottom.jsp"/>
</footer>
</html>