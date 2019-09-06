function checkBoard(){
	if(document.getElementById("subject").value=="") alert("제목을 입력해주세요.");
	else if(document.getElementById("content").value=="") alert("내용을 입력해주세요.");
	else document.forms[0].submit();
}


function isLogin(id, seq, pg){
	if(id == 'null') {
		alert("먼저 로그인 해주세요! ");
	} else {
		location.href="/mvcBoard/board/boardView.do?seq="+seq+"&pg="+pg;
	}
}

function delConfirm(seq){
	if(confirm("정말 삭제하시겠습니까?")) location.href="/mvcBoard/board/boardDelete.do?seq="+seq;
	else location.href="javascript:void(0)";
	
}