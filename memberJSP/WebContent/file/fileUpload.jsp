<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//실제폴더위치 
String realFolder = request.getServletContext().getRealPath("/storage");

//업로드: 가상폴더로는 들어오지 않음					//받을 데이터,		주소,	최대용량(byte), 인코딩, 같은 이름의 파일에 rename
MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024, "UTF-8", 
											new DefaultFileRenamePolicy());  

//String subject = request.getParameter("subject");
String subject = multi.getParameter("subject");
String content = multi.getParameter("content");

String originalFileName1 = multi.getOriginalFileName("upload1");
String originalFileName2 = multi.getOriginalFileName("upload2");

//rename을 했기 때문에 필요. rename 하지 않았다면 originalFileName만 있어도 됨
String fileName1 = multi.getFilesystemName("upload1");
String fileName2 = multi.getFilesystemName("upload2");

File file1 = multi.getFile("upload1");
File file2 = multi.getFile("upload2");

long fileSize1 = 0; 
long fileSize2 = 0; 
if(file1 != null) fileSize1 = file1.length();
if(file2 != null) fileSize2 = file2.length();

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>업로드 완료 </h3>
<ul>
	<li>제 목: <%=subject%><br></li>
	<li>내 용: <pre><%=content%></pre><br></li>
	<li>파 일: <a href="fileDownload.jsp?fileName=<%=URLEncoder.encode(originalFileName1, "UTF-8")%>"><%=originalFileName1%></a><br></li>
	<li>파 일: <%=fileName1%><br></li>
	<li>크 기: <%=fileSize1%><br></li>
	<hr>
	<li>파 일: <a href="fileDownload.jsp?fileName=<%=originalFileName2%>"><%=originalFileName2%></a><br></li>
	<li>파 일: <%=fileName2%><br></li>
	<li>크 기: <%=fileSize2%><br></li>

</ul>
</body>
</html>