function checkBoardWrite(){
	if(document.getElementById("subject").value=="") alert("제목을 입력해주세요.");
	else if(document.getElementById("content").value=="") alert("내용을 입력해주세요.");
	else document.forms[0].submit();
}


function isLogin(id, seq, pg){
	if(id == 'null') {
		alert("먼저 로그인 해주세요! ");
	} else {
		location.href="../board/boardView.jsp?seq="+seq+"&pg="+pg;
	}
}