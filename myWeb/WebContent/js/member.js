	function openSignUpForm(){
		window.open("../member/signUpForm.jsp", "회원가입", "top=500px, left=800px, width=500, height=600 ");
	}

	function checkWrite(){		
 		if(document.getElementById("irum").value == "") {
 			alert("이름을 입력하세요");
 			document.signUpForm.name.focus();
 		} else if(document.signUpForm.id.value == ""){
 			alert("아이디를 입력하세요");
 			document.signUpForm.id.focus();	
 		} else if(document.signUpForm.pwd.value == ""){
 			alert("패스워드를 입력하세요");
 			document.signUpForm.pwd.focus();
 		} else if(document.signUpForm.repwd.value != document.signUpForm.pwd.value){
 			alert("패스워드가 일치하지 않습니다.");
 			document.signUpForm.repwd.focus();
 		} else if(document.signUpForm.idsw.value != document.signUpForm.id.value) {
 			alert("아이디 중복체크 해주세요. ");	
 		
 		} else { 		
 			document.signUpForm.submit();
 		}
 	}
 	
 	function checkIdDup(){
 		var checkId = document.signUpForm.id.value;
 		if(checkId =="") alert("아이디를 먼저 입력하세요. ");
 		else window.open("/myWeb/member/checkIdDup.do?id="+checkId, "", "width=400px, height=200px, left=1200px, top=500px");	
 	}
 	
 	function checkDupClose(checkId){
 		opener.signUpForm.id.value = checkId;
 		opener.signUpForm.idsw.value = opener.signUpForm.id.value;
 		window.close();
 		opener.signUpForm.pwd.focus();
 	}
 	
	function checkLogin() {
 		if (document.signInForm.id.value == "") {
 			alert("아이디를 입력해주세요.");
 			document.signInForm.name.focus();
 		} else if (document.signInForm.pwd.value == "") {
 			alert("비밀번호를 입력해주세요.");
 			document.signInForm.pwd.focus();
 		} else {
 			document.signInForm.submit();
 		}
 	}

 	