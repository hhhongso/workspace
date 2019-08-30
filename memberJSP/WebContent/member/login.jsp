<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="memberJSP.dao.MemberDAO"
    import = "memberJSP.bean.MemberDTO"%>

<jsp:useBean id="memberDTO" class="memberJSP.bean.MemberDTO"/>
<jsp:setProperty property="id" name="memberDTO"/>
<jsp:setProperty property="pwd" name="memberDTO"/>
<% memberDTO = MemberDAO.getinstance().isLogin(memberDTO.getId(), memberDTO.getPwd());%>
<!--  Map<String, String> 에 key, value 값을 받아올 수도 있음. -->
<jsp:getProperty property="id" name="memberDTO"/>
<jsp:getProperty property="name" name="memberDTO"/>
<jsp:getProperty property="email1" name="memberDTO"/>
<jsp:getProperty property="email2" name="memberDTO"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="modifyForm.jsp">
<input type = "hidden" name ="id" value="<%=memberDTO.getId()%>">
<%	
	request.setCharacterEncoding("UTF-8");
	if(memberDTO != null) { 
	//1. get방식: 주소에 값을 태워보낼 때, 한글: UTF-8 으로 인코딩 해주어야 한다. 
		//response.sendRedirect("loginOK.jsp?name="+URLEncoder.encode(memberDTO.getName(), "UTF-8"));
		
	//2. post 방식
		//쿠키:클래스
		/* Cookie cookie = new Cookie("memName", memberDTO.getName()); //쿠키 생성
		cookie.setMaxAge(30*60); //초 단위
		response.addCookie(cookie); //클라이언트에 저장
		
		Cookie cookie2 = new Cookie("memId", memberDTO.getId());
		cookie2.setMaxAge(30*60);
		response.addCookie(cookie2); */
		
		//세션: 인터페이스
		//HttpSession session = request.getSession(); //세션 생성:jsp 에서는 내장객체로 가지고 있음
		session.setAttribute("memName", memberDTO.getName());
		session.setAttribute("memId", memberDTO.getId());
		session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
		
		session.setAttribute("memDTO", memberDTO); //DTO객체의 모든 값을 담기
		response.sendRedirect("loginOK.jsp");
//		request.getSession().setAttribute("id", memberDTO.getId());
//		request.getSession().setAttribute("name", memberDTO.getName());
	} else { 
		response.sendRedirect("loginFail.jsp");
	}
%>
		
</form>
</body>
</html>