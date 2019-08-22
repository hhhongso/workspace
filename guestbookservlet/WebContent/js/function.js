function writeSubmit(){
	if(document.guestbookForm.subject.value == ""){
		alert("제목을 입력해주세요.");
	} else if (document.guestbookForm.content.value == ""){
		alert("내용을 입력해주세요.");
	} else {
		document.guestbookForm.submit();
	}
}