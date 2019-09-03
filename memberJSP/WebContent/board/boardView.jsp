<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"></jsp:useBean>

<%
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));

String memId = (String)session.getAttribute("memId");

//조회수: 새로고침 방지 
Cookie[] arr = request.getCookies();
if(arr !=null) {	
	for(int i =0; i < arr.length; i++){
		if(arr[i].getName().equals("memHit")){
			boardDAO.updateHit(seq);
			arr[i].setMaxAge(0);
			response.addCookie(arr[i]);
		}
	}
}

/*조회수: 쿠키에 시간주기 
Cookie[] arr = request.getCookies();
boolean sw = false;
if(arr !=null) {	
	for(int i =0; i < arr.length; i++){
		if(arr[i].getName().equals(memId+seq)){ // 게시글마다 다른 쿠키key : 쿠키가 살아있는 시간이 있을 경우, 서로다른 서버로 들어오면 서로 다른 쿠키가 생성됨. => 다른 쿠키와 혼선 방지
			// 이미 해당 memID+seq 쿠키로 들어온 적이 있음 => 쿠키를 삭제한다.
			//arr[i].setMaxAge(0);
			//response.addCookie(arr[i]);
			sw = true;			
		}
	}
	
	if(!sw) {
		// 한 번도 해당 memID+seq 쿠키로 들어온 적 없음 => 쿠키 생성, 조회수를 증가한다. 
		Cookie cookie = new Cookie(memId+seq, seq+"");
		System.out.println("쿠키명:" + memId+seq + " 쿠키값:" + seq+"");
		cookie.setMaxAge(30*60); //쿠키는 n초 동안 유효하며, 이후 삭제된다. => n초 동안은 조회수 업데이트 되지 않음. 
		response.addCookie(cookie); //클라이언트에 저장
		boardDAO.updateHit(seq);
	}
} */
BoardDTO boardDTO = boardDAO.getBoardView(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="">
.content{
/* 	width: 400px;
	height: 200px;  */
/* 	text-align:top; */
	white-space:pre-line; 
 	word-break: break-all;
	overflow:auto;
}
</style>
</head>
<body>
<%if(boardDTO != null) { %>
	<form action="">
		<table frame="hsides" rules="rows" style="width:400px; height:200px;">
			<tr>
				<td colspan = 3><font size=7pt><b><%=boardDTO.getSubject()%></b></font></td>
			</tr>
			<tr>
				<td>글번호: <%=boardDTO.getSeq()%></td>
				<td>작성자: <%=boardDTO.getName()%></td>
				<td>조회수: <%=boardDTO.getHit()%></td>
			</tr>
			<tr>
				<td class="content" colspan = 3 valign="top"><%=boardDTO.getContent()%>
<%-- 				<input type="text" class="content" value="<%=boardDTO.getContent()%>" readonly> --%>
<%-- 				<pre class="content"><%=boardDTO.getContent()%></pre> --%>
				
				</td>
			</tr>		
		</table>
		<%if(session.getAttribute("memId").equals(boardDTO.getId())){ %>
		<input type="button" value="글수정" onclick="location.href='boardModifyForm.jsp?seq=<%=boardDTO.getSeq()%>&pg=<%=pg%>'">
		<input type="button" value="글삭제" onclick="">
		<%} %>
		<input type="button" value="목록으로" onclick="location.href='boardList.jsp?pg=<%=pg%>'"> <br>
		<img src="../image/ni.PNG" width=80 height=80 onclick ="location.href='../main/index.jsp'" style= "cursor:pointer;"> 메인으로 가기 <br>
		
	</form>
<% } %>
</body>
<script>
window.onload = function(){

	
		
}
</script>
</html>