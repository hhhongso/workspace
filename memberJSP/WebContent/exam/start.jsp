<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<font color = "red"><b>
start.jsp - sendProc.jsp - sendResult.jsp 페이지로 이동합니다. <br>
sendRedirect로 이동하므로 데이터는 공유하지 않습니다.(각자의 내장객체 request를 사용) <br>

주소는 sendResult.jsp 가 보인다.  <br>
</b></font>
<br>

<font color = "blue"><b>
start.jsp - forwardProc.jsp - forwardResult.jsp 페이지로 이동합니다. <br>
forward로 이동하므로 데이터는 공유합니다.  (페이지는 각기 존재하지만, 내장객체 request는 병합)<br>
주소는 forwardProc.jsp 로 보이지만, 결과는 forwardResult.jsp가 나온다. <br>
</b></font>
<br>

<input type ="button" value = "sendRedirect" onclick="location.href='sendProc.jsp'">
<input type ="button" value = "forward" onclick="location.href='forwardProc.jsp'">
</body>
</html>