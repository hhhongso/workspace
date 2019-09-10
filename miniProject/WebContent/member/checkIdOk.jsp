<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "member.dao.MemberDAO"%>

<form>
${id } 는 사용 가능합니다. 
<br><br>
<input type = "button" value = "아이디 사용" onclick ="checkIdClose('${id}')">

</form>

<script src="../js/member.js"></script>
