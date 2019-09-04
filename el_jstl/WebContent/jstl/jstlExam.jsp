<%@page import="com.jstl.PersonDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("사자");
	list.add("코끼리");
	list.add("기린");	
	request.setAttribute("list1", list);

	PersonDTO personDTO1 = new PersonDTO("홍길동", 25);
	PersonDTO personDTO2 = new PersonDTO("꼬부기", 3);
	PersonDTO personDTO3 = new PersonDTO("이상해씨", 10);

	ArrayList<PersonDTO> list2 = new ArrayList<PersonDTO>();
	list2.add(personDTO1);
	list2.add(personDTO2);
	list2.add(personDTO3);

	request.setAttribute("list", list2);
	
	//페이지 이동
	//response.sendRedirect("jstlTest.jsp");
	// <jsp:forward> 는 사라졌음 => 같은 기능을 하는 인터페이스 RequestDispatcher 사용. 주소는 상대번지.
	RequestDispatcher dispatcher = request.getRequestDispatcher("jstlTest.jsp");
	dispatcher.forward(request, response); // 제어권 넘겨주기
%>
<%-- <jsp:forward page="jstlTest.jsp"/> --%>
