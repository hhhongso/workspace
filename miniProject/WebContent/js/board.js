function checkBoard(){
	if(document.getElementById("subject").value=="") alert("제목을 입력해주세요.");
	else if(document.getElementById("content").value=="") alert("내용을 입력해주세요.");
	else document.forms[0].submit();
}


function isLogin(id, seq, pg){
	if(id == '') {
		alert("먼저 로그인 해주세요! ");
	} else {
		location.href="/miniProject/board/boardView.do?seq="+seq+"&pg="+pg;
	}
}

function delConfirm(seq){
	if(confirm("정말 삭제하시겠습니까?")){
		location.href="/miniProject/board/boardDelete.do?seq="+seq;
	} else {
		location.href="/miniProject/board/boardView.do?seq="+seq+"&pg="+pg;
	}
}

function searchBoard(){
	var searchWord = document.boardListForm.searchWord.value;
	if(searchWord == "") alert("검색어를 입력하세요");
	else document.boardListForm.submit();

//		var option = document.querySelector("#option");
//		var searchOp;
//		for (var i = 0; i < option.length; i++) {
//			if(option[i].selected) searchOp = option[i].value;
//		}
}
