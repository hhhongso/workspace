var ischecked= false;

function checkWrite() {
//	if(!ischecked){
//		alert("중복체크하세요.");
//		return;
//	}
	
	if (document.getElementById("irum").value == "") {
		alert("이름을 입력하세요");
		document.writeForm.name.focus();
	} else if (document.writeForm.id.value == "") {
		alert("아이디를 입력하세요");
		document.writeForm.id.focus();
	} else if (document.writeForm.pwd.value == "") {
		alert("패스워드를 입력하세요");
		document.writeForm.pwd.focus();
	} else if (document.writeForm.repwd.value != document.writeForm.pwd.value) {
		alert("패스워드가 일치하지 않습니다.");
		document.writeForm.repwd.focus();
	} else if (document.writeForm.id.value != document.writeForm.sw.value) {
		alert("중복체크하세요.");
	} else {
		document.writeForm.submit();
	}
}

function checkId() {
	var sId = document.writeForm.id.value;
	if(sId == "") {
		alert("아이디를 먼저 입력해주세요. ");
	} else {
		window.open("http://localhost:8080/memberJSP/member/checkId.jsp?id="+sId, 
				"이름 줄게 하나만 뜨렴", "width=350, height= 100 left=1200, top=500, location=no");
		
	}
}

function checkIdClose(id){
	//데이터를 전달 : 자바스크립트에서는 "" or ''가 있어야 문자열로 인식
	opener.writeForm.id.value = id;
	opener.writeForm.sw.value = id;
	window.close();
	opener.writeForm.pwd.focus();
	
}

function checkPost() {

}

function checkLogin() {
	if (document.loginForm.id.value == "") {
		alert("아이디를 입력해주세요.");
		document.loginForm.name.focus();
	} else if (document.loginForm.pwd.value == "") {
		alert("비밀번호를 입력해주세요.");
		document.loginForm.pwd.focus();
	} else {
		document.loginForm.submit();
	}
}

function genderCheck(){
	if(document.modifyForm.gender[0].value == document.modifyForm.gendersw.value) {
		document.modifyForm.gender[0].checked = true;
	} else{
		document.modifyForm.gender[1].checked= true;
	}
}

function emailCheck(email2){
	if(document.modifyForm.email2[2].value == email2){
		document.modifyForm.email2[2].selected = true;
	}

}

function telCheck(){
	if(document.modifyForm.tel1[0].value == document.modifyForm.tel.value){
		document.modifyForm.tel1[0].selected =true;
	} else if(document.modifyForm.tel1[1].value == document.modifyForm.tel.value){
		document.modifyForm.tel1[1].selected =true;
	} else if(document.modifyForm.tel1[2].value == document.modifyForm.tel.value){
		document.modifyForm.tel1[2].selected =true;
	}
}

