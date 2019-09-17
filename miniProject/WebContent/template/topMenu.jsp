<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
a {
	color: black;
	text-decoration: none;
}
a:hover{
	font-weight:bold;
	color: red;
}
</style>
<c:if test="${memId != null }">
	<a href="/miniProject/board/boardWriteForm.do">게시판 글쓰기</a> &emsp;
	<a href="/miniProject/imageboard/imageboardList.do?pg=1">이미지(상품) 목록보기</a> &emsp;
</c:if>

<c:if test="${memId == 'admin' }">
	<a href="/miniProject/imageboard/imageboardWriteForm.do">이미지 등록</a> &emsp;
</c:if>

<a href="/miniProject/board/boardList.do?pg=1">게시판 글목록</a>