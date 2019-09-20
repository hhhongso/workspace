<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<fmt:requestEncoding value="UTF-8"/>

<jsp:useBean id="now" class="java.util.Date"/>
<c:set var="birthday" value="${param.birthday }"/>
<c:set var="birthArr" value="${fn:split(birthday, '/') }"/>
<fmt:formatDate var="year" value="${now }" pattern="yyyy"/>
${param.name }님의 생일은 
${birthArr[0] }년  ${birthArr[1] }월 ${birthArr[2] }일 입니다.

나이는 ${year - birthArr[0] +1}살입니다. 
