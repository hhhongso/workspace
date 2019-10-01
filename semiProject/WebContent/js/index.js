$().ready(function(){
	
	//headerMenu.jsp 	
	var hoffset = $('.headLogo').offset();
	$(window).scroll(function(){
		if($(document).scrollTop() > hoffset.top) $('.indexHeader').addClass('headerFixed');
		else $('.indexHeader').removeClass('headerFixed');
	});
	
	
	$('.logout').click(function(){
		$.ajax({
			type: 'get',
			url: '/semiProject/member/logout.do',
			data: '',
			dataType: 'html',
			success: function(data){
				console.log('성공');
				console.log(data);
				$('.indexSection').html(data);
			},
			error: function(){
				console.log('실패');
			}
			
		});
	});
	
	//asideBar.jsp
	$(window).scroll(function(){
		if($(document).scrollTop() > 0) $('#topBar').fadeIn();
		else $('#topBar').fadeOut();
	});
	
	$('#topBar').click(function(){
		$('html, body').animate( { scrollTop : 0 }, 400 )
		return false;	
	});
	
});