<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${memId == null }">
로그인 창 
</c:if>

<c:if test="${memId != null }">
로그인OK 창 
</c:if>