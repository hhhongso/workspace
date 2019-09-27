
function checkSignup(){
	if($('#name').val() =="") {
		$('.nameDiv').empty();
		$('.nameDiv').append('이름을 입력해 주세요');
		return false;
	} else if($('#id').val().length < 5 || $('#id').val().length > 10){
		$('.nameDiv, .idDiv').empty();
		$('.idDiv').append('아이디는 5자리 이상 10자리 이하로 작성 가능합니다. ');
		return false;
	} else if($('#pwd').val().length == 0){
		$('.idDiv, .pwdDiv').empty();
		$('.pwdDiv').append('비밀번호를 입력해 주세요');
		return false;
	} else if ($('#pwd').val() != $('#repwd').val()){
		$('.pwdDiv, .repwdDiv').empty();
		$('.repwdDiv').append('비밀번호가 일치하지 않습니다. ');
		return false;
	} else {
		$('.repwdDiv').empty();
		return true;
	}
}
