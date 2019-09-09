function check(){
	if(document.getElementById("name") == "") alert("이름을 입력해주세요. ");	
	else if(document.getElementById("id").value == "") alert("아이디를 입력해주세요. ");	
	else if(document.getElementById("pwd").value == "") alert("비밀번호를 입력해주세요. ");
	else if(document.getElementById("pwd").value != document.getElementById("repwd").value) alert("비밀번호를 재확인 해주세요. ");
	else document.writeForm.submit();		
}

function checkLogin(){
	if(document.loginForm.id.value == "") alert("아이디를 입력해주세요. ");	
	else if(document.loginForm.pwd.value == "") alert("비밀번호를 입력해주세요. ");
	else document.loginForm.submit();
}