<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
window.onload = function(){
	alert("답글이 작성되었습니다. ");
	location.href="/miniProject/board/boardList.do?pg=${pg}"
}
</script>