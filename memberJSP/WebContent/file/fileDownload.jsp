<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String fileName = request.getParameter("fileName");
	String realFolder = request.getServletContext().getRealPath("/storage");

	//다운로드 받을 파일 생성 
	File file = new File(realFolder, fileName);
	fileName = URLEncoder.encode(fileName, "UTF-8").replace("+", " ");

	response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
	response.setHeader("Content-Length", file.length() + "");

	/* getOutputStream() has already been called for this response
	JSP에서는 servlet으로 변환될 때, 내부적으로 내장객체 out이 (web으로 가도록) getOutputStream을 이미 자동으로 생성하기 때문에 
	out객체를 만들면 충돌이 일어나서 위와 같은 에러를 뿌림 
	=> out 를 먼저 초기화 하고 생성한다.  
	*/

	out.clear();
	out = pageContext.pushBody();

	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());

	int size = (int) file.length();
	byte[] b = new byte[size];
	bis.read(b, 0, size);
	bos.write(b);

	bis.close();
	bos.close();
%>

<!-- IO Stream
1. byte 단위로 처리
- InputStream/ OutputStream : 추상 클래스

2. 문자(2byte) 단위로 처리
- Reader / Writer 
				
				BufferedInputStream				FileInputStream
fileDownload.jsp <================== buffer <===================== /storage
		저장한[file]==================>		=====================>원하는 위치, 이름으로 저장 
				
-->

