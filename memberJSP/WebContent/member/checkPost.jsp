<%@page import="memberJSP.bean.ZipcodeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="memberJSP.dao.MemberDAO"%>

<%
//데이터 얻어오기
	request.setCharacterEncoding("UTF-8");
	String sido = request.getParameter("sido");
	String sigungu = request.getParameter("sigungu");
	String roadname = request.getParameter("roadname");
	
	List<ZipcodeDTO> list = null;
	if(sido != null && roadname != null){
		list = MemberDAO.getinstance().getZipcodeList(sido, sigungu, roadname);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
th, td, select {
	font-size: 8pt;
}

#addressA:link, #addressA:visited, #addressA:active {color: black; text-decoration: none;}
#addressA:hover {color: orange; text-decoration:underline;}

</style>
</head>
<body>
	<form name="" method="post" action="checkPost.jsp">
		<table border=3 width=100%>
			<tr>
				<th>시도</th>
				<td><select name="sido">
						<option>시도선택</option>
						<option value="서울">서울</option>
						<option value="인천">인천</option>
						<option value="대전">대전</option>
						<option value="대구">대구</option>
						<option value="울산">울산</option>
						<option value="세종">세종</option>
						<option value="광주">광주</option>
						<option value="경기">경기</option>
						<option value="강원">강원</option>
						<option value="전남">전남</option>
						<option value="전북">전북</option>
						<option value="경남">경남</option>
						<option value="경북">경북</option>
						<option value="충남">충남</option>
						<option value="충북">충북</option>
						<option value="부산">부산</option>
						<option value="제주">제주</option>
				</select></td>

				<th>시군구</th>
				<td><input type="text" name="sigungu" size=10></td>
			</tr>

			<tr>
				<th>도로명</th>
				<td colspan=3><input type="text" name="roadname" size=20>
					<input type="submit" value="검색"></td>

			</tr>

			<tr>
				<th>우편번호</th>
				<td colspan=3 align="center">주소</td>

			</tr>
		<%if(list != null) { %>		
			<%for(ZipcodeDTO zipcodeDTO : list) { 
				String zipcode=zipcodeDTO.getZipcode();				
				String address = zipcodeDTO.getSido() + " " + zipcodeDTO.getSigungu()+ " "
						+ zipcodeDTO.getYubmyundong() + " " + zipcodeDTO.getRi()+ " "
						+ zipcodeDTO.getRoadname() + " " + zipcodeDTO.getBuildingname();%>
				<tr>
					<td align ="center"> <%=zipcode%></td>
					<td colspan = 3> 
					<a id="addressA" href = "#" onclick ="checkPostClose('<%=zipcode%>', '<%=address%>')"> 
					<%=address%></a></td>
				</tr> 
				
			<% } %>
		<% } %>
		</table>
	</form>
</body>
<script src = "../js/member.js"></script>
</html>