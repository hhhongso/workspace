var ischecked= false;

function checkWrite() {
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
		window.open("/miniProject/member/checkId.do?id="+sId, 
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
	window.open("/miniProject/member/checkPost.do", "", "width=500, height=500 left=1200, top=500 scrollbars=yes");
				//여기 인자를 주면	여기는 주면 안된다. (반대도 성립) 
}

function checkPostClose(zipcode, address){
	//form을 관리하는 객체:forms[i] 를 이용 
//	opener.document.forms[0].zipcode.value = zipcode;
//	opener.document.forms[0].addr1.value = address;
//	window.close();
//	opener.document.forms[0].addr2.value.focus();
	
	//forms가 작동하지 않을 때: getElementById() 로 접근
//	opener.document.getElementById("daum_zipcode").value = zipcode;
//	opener.document.getElementById("daum_addr1").value = address;				
//	window.close();
//	opener.document.getElementById("daum_addr2").focus();		
//	
	opener.parent.daum_zipcode.value = zipcode;
	opener.parent.daum_addr1.value = address;
	window.close();
	opener.parent.daum_addr2.value.focus();

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

function genderCheck(gender){	
	let radioArr = document.querySelectorAll(".radio");
	radioArr[gender].checked = true;
}

function emailCheck(email2){
	let emailArr= document.querySelectorAll(".mailaddr, #mailaddr, .email2");
	console.log(emailArr[0]);
	for (var i = 0; i < emailArr.length; i++) {
		if(emailArr[i].value == email2){
			emailArr[i].selected = true;
		}	
	}
}

function telCheck(tel1){
	let telArr = document.querySelectorAll(".tel, .tel1");
	for (var i = 0; i < telArr.length; i++) {
		if(telArr[i].value == tel1){
			telArr[i].selected = true;
		}	
	}
}

function checkModify(){
	if(document.modifyForm.name.value == ""){
		alert("이름을 입력해 주세요.");
	} else if(document.modifyForm.pwd.value == ""){
		alert("수정할 비밀번호를 입력해주세요.");
	} else if(document.modifyForm.pwd.value != document.modifyForm.repwd.value){
		alert("비밀번호가 일치하지 않습니다.");
	} else {
		document.modifyForm.submit();
	}
}


