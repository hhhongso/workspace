<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//	String name = request.getParameter("name");
String name = null;
String id = null;
String email = null;
//쿠키
/* Cookie[] arr = request.getCookies(); //특정 쿠키만을 가져올 수 없음 => 모든 쿠키 가져오기 
if(arr != null){ //3초 뒤 쿠키는 삭제되니까
	for(int i = 0; i < arr.length; i++){
		if(arr[i].getName().equals("memName"))	name = arr[i].getValue();
		if(arr[i].getName().equals("memId"))	id = arr[i].getValue();
	}
} */

//세션 
name = (String)session.getAttribute("memName");
id = (String)session.getAttribute("memId");
email = (String)session.getAttribute("memEmail");
// post 방식
// request.setCharacterEncoding("UTF-8");
// String name = (String)request.getSession().getAttribute("name");
%>
<img src="../image/clap.gif" width=200 height=200 onclick ="location.href='../main/index.jsp'" style= "cursor:pointer;"><br>
<%=name%> 님 로그인 
<br><br>
<input type = "button" value = "로그아웃" onclick="location.href='logout.jsp'">
<input type = "submit" value = "회원정보수정">