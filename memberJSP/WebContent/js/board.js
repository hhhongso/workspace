function checkBoardWrite(){
	if(document.boardWriteForm.subject.value=="") alert("제목을 입력해주세요.");
	else if(document.boardWriteForm.content.value=="") alert("내용을 입력해주세요.");
	else document.boardWriteForm.submit();
}


function isLogin(id, seq){
	if(id == 'null') {
		alert("먼저 로그인 해주세요! ");
	} else {
		location.href="../board/boardView.jsp?seq="+seq;
	}
}