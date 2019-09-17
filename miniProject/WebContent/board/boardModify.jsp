<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
window.onload = function(){
	alert("게시글이 수정되었습니다. ");
	location.href="/miniProject/board/boardList.do?pg=${pg}";
}
</script>
