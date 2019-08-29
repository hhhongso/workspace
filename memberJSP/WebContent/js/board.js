function checkBoardWrite(){
	if(document.boardWriteForm.subject.value=="") alert("제목을 입력해주세요.");
	else if(document.boardWriteForm.content.value=="") alert("내용을 입력해주세요.");
	else document.boardWriteForm.submit();
}