var today = new Date();

window.onload = function(){
	for (var i = 1900; i <= today.getFullYear(); i++) {
		$('#signupForm .birthYear').append('<option>'+i+'</option>');	}
	
	for (var i = 1; i <= 12 ; i++) {
		$('.birthMonth').append('<option>'+i+'</option>');	}
	
	for (var i = 1; i <= 31; i++) {
		$('.birthDay').append('<option>'+i+'</option>');	}
}

$().ready(function(){	
	$('.birthYear, .birthMonth').change(function(){
		var birthday = new Date($('.birthYear').val(), $('.birthMonth').val(), 0);
		lastdate = birthday.getDate();
		$('.birthDay').empty();
		for (var i = 1; i <= lastdate ; i++) {
			$('.birthDay').append('<option>'+i+'</option>');
		}
	});

	$('#signupForm #name, #signupForm #id, #signupForm #pwd, #signupForm #repwd').keyup(function(){
		checkSignup();
		
	});
	
	$('.btnSubmit').click(function(){
		if(checkSignup()){
			//$('form').submit();
			
			$.ajax({
				type: 'post',
				url: '/semiProject/member/signup.do',
				data: { 'name' : $('#name').val(),					
					'id' : $('#id').val(),
					'pwd' : $('#pwd').val(),
					'email1': $('.email1').val(),
					'email2': $('.email2').val(),
					'birthYear': $('.birthYear').val(),
					'birthMonth': $('.birthMonth').val(),
					'birthDay': $('.birthDay').val()
				
				},
				dataType: 'text',
				success: function(result){
					$('.signupModal').show();
					$('.msg').text(result);
				},
				error: function(){
					console.log('실패');
				}
			});
			 
		}
		
	});
	
	$('.btnIsExisted').click(function(){
		if($('#id').val().length >= 5 && $('#id').val().length <= 10){
			$.ajax({
				type: 'get',
				url: '/semiProject/member/isExistedId.do',
				data: {'id' : $('#id').val() },
				dataType: 'text',
				success: function(result){
					$('.idDiv').empty();
					if(result.trim() == 'able'){
						$('.idDiv').append('사용 가능한 아이디 입니다. ').css('color', 'blue');			
					} else if(result.trim() == 'unable'){
						$('.idDiv').append('중복된 아이디 입니다. ').css('color', 'red');
					}
				},
				error: function(){
					console.log('실패');
				}
			});
			
			 
		 }
	});	
	
	
	$('#signupForm .btnClose').click(function(){
		$('.signupModal').hide();
		location.href='/semiProject/member/loginForm.do';
	});
	
	
	//로그인
	$('.btnLogin').click(function(){		
		if($('#loginForm .id').val() == ""){
			$('#loginForm .idDiv').empty();
			$('#loginForm .idDiv').append('아이디를 입력하세요.');
		}
		else if ($('#loginForm .pwd').val() == ""){
			$('#loginForm .idDiv, .pwdDiv').empty();
			$('#loginForm .pwdDiv').append('비밀번호를 입력하세요');
		}
		else {
			$('#loginForm .pwdDiv').empty();
			$.ajax({
				type: 'post',
				url: '/semiProject/member/login.do',
				data: {'id': $('#loginForm .id').val(), 
					'pwd': $('#loginForm .pwd').val(), 
					'rememberMe' : $('.rememberMe').prop('checked')},
				dataType: 'json',
				success: function(data){
					if(data.result == 'ok'){
						location.href="/semiProject/main/index.do";
						window.parent.close();
						
					}else {
						$('.isLoginDiv').append('아이디 또는 비밀번호가 틀립니다. ');
						$('#loginForm .id').val('');
						$('#loginForm .pwd').val('');
						$('#loginForm .id').focus();
					}
					
				},
				error: function(){
					console.log("실패");
				}
				
			});
		}
	});
	
});
	
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
