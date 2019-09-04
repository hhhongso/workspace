<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>** 변수 설정 **</h3>
<c:set var="name">홍길동</c:set>
<c:remove var="name"/>
<c:set var="age" value="25"/>

내 이름은 <c:out value="${name}"/> 입니다. <br>
내 이름은 ${name} 입니다. <br>
나이는 ${age} 살 입니다. <br>
좋아하는 색은 ${color} 입니다. <br>

<!-- 변수를 선언하지 않을 시, 에러가 나는 것이 아니라, 값이 출력되지 않고 뿌려진다.  -->

<h3> ** forEach ** </h3>
<c:forEach var="i" begin="1" end="10" step="2">${i} </c:forEach> <br>
<c:forEach var="i" begin="1" end="10" step="1">
<c:set var="j" value="11"/>${j- i} 
</c:forEach> <br>

<c:forEach var="i" begin="1" end="10" step="1">
<c:set var="sum" value="${sum+i}"/>
</c:forEach>
1~10까지의 합: ${sum}
<br>

<h3> ** forTokens ** </h3>
<c:forTokens var="car" items="소나타 & 아우디 & 링컨, 페라리, 벤츠" delims=",">${car} </c:forTokens>
<br>

<h3>** jstlExam.jsp 에서 넘어온 데이터 출력 **</h3>
가져오나욥?: ${requestScope.list1}

<h3>** jstlExam.jsp 에서 넘어온 데이터 중 인덱스 2번째 **</h3>
두번째 인덱스?: ${list1[2]} <br>
두번째 인덱스?: ${requestScope.list1[2]} <br>

<h3>** jstlExam.jsp 에서 넘어온 데이터: 클래스 객체 가져오기  **</h3>
<c:forEach var="personDTO" items="${requestScope.list}">
	<%-- ${personDTO } --%>
	이름: ${personDTO.getName()} &nbsp; &emsp; 나이: ${personDTO.getAge()} <br>
	이름: ${personDTO.name} &nbsp; &emsp; 나이: ${personDTO.age} <br>
		<!-- 메소드를 변수처럼 사용 가능 
		private String name; 필드가 아니라, getter/setter의 이름 ?? -->
</c:forEach>

<!-- requestScope.list 를 가져옴 => 주소값을 가져온다. 즉, [~~~~] 전체가 참조주소. 
값을 가져올 때, scope 우선순위(pageScope → requestScope → sessionScope → applicationScope)에 맞추어 움직인다. --> 
</body>
</html>