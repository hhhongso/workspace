<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>
<%
request.setCharacterEncoding("UTF-8");
int seq = Integer.parseInt(request.getParameter("seq")); 
int pg = Integer.parseInt(request.getParameter("pg")); 
String subject = request.getParameter("subject");
String content = request.getParameter("content");

Map<String, String> map = new HashMap<String, String>();
map.put("seq", seq+"");
map.put("subject", subject);
map.put("content", content);

boardDAO.updateBoard(map);
%>

<!-- Collection: 객체를 모아주는 것. 
1. Collection coll = new ArrayList(); 들어간 순서대로 나옴. 중복 가능. 
2. Set set = new HashSet(); 순서 없음. 중복 불가
3. Map<Key, Value>
 -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
<script>
window.onload = function(){
	alert("게시글이 수정되었습니다. ");
	location.href="boardList.jsp?pg=<%=pg%>";
}

</script>
</html>