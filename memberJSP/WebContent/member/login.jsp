<%@page import="member.bean.MemberDTO"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import ="member.dao.MemberDAO"%>

<% 
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

MemberDTO memberDTO = MemberDAO.getinstance().isLogin(id, pwd);

%>
<!--  Map<String, String> 에 key, value 값을 받아올 수도 있음. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="modifyForm.jsp">
<input type = "hidden" name ="id" value="<%=id%>">
<%	if(memberDTO != null) { 
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