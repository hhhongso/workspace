	function checkLogin() {
 		if (document.mainForm.id.value == "") {
 			alert("아이디를 입력해주세요.");
 			document.mainForm.name.focus();
 		} else if (document.mainForm.pwd.value == "") {
 			alert("비밀번호를 입력해주세요.");
 			document.mainForm.pwd.focus();
 		} else {
 			document.mainForm.submit();
 		}
 	}
