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
