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
