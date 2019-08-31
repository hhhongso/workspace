<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("apple", "사과");

	//페이지 이동
	RequestDispatcher dispatcher = request.getRequestDispatcher("forwardResult.jsp"); //반드시 상대번지
	
	//제어권 넘겨주기: 하나의 request, response 를 공유한다. 
	dispatcher.forward(request, response);
%>

<%-- <jsp:forward page="forwardResult.jsp"/> --%>