<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
input[type="button"], [type="reset"] {
	background-color: grey; 
	color: white; 
	padding: 5px 0; 
	width: 45%; 
}

div[class$='Div']{
	color: red; 
	font-size: 5pt; 
}
</style>

<div id="notice">    
	<div>
		<label>작성자</label>&emsp; ${memId} <br>
		<label>제목 </label>&emsp;
		<input type="text" class="subject" class="subject">
		<div class="subjectDiv"></div>
	</div>
	<br>
	<textarea id="content" name="content" class="content" style="position: relative; width: 100%; height: 500px; overflow: auto;"></textarea><br>
	<div class="contentDiv"></div>
	<div align="center">
	<input type="button" class="noticeWrite" value="작성">
	<input type="reset" value="취소">
	</div>
</div>

<script>
$().ready(function(){
	$('.noticeWrite').click(function(){
		if($('#notice .subject').val() == '') {
			$('.subjectDiv').empty();
			$('.subjectDiv').append('제목을 입력하세요 ');
		} else if($('#notice .content').val() == ''){
			$('.subjectDiv, .contentDiv').empty();
			$('.contentDiv').append('내용을 입력하세요 ');
		} else {
			$('.contentDiv').empty();
			$.ajax({
				type: 'post',
				url: '/semiProject/notice/noticeBoardWrite.do',
				data: {"name": '${memDTO.name}', "subject": $('#notice .subject').val(), "content": $('#notice .content').val()},
				dataType:'text',
				success: function(data){
					console.log('성공');
					console.log(data);
				},
				error: function(){
					console.log('실패');
				}				
				
			});
		}
	});
});

</script>



 <!-- 

<script type="text/javascript" src="../Editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">

// 추가 글꼴 목록
//var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];
$().ready(function(){
	var oEditors = [];	
	//var sLang = "ko_KR";	// 언어 (ko_KR/ en_US/ ja_JP/ zh_CN/ zh_TW), default = ko_KR
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "content",
		sSkinURI: '../Editor/SmartEditor2Skin.html',	
		htParams : {
			bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			//bSkipXssFilter : true,		// client-side xss filter 무시 여부 (true:사용하지 않음 / 그외:사용)
			//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
	/* 		fOnBeforeUnload : function(){
				//alert("완료!");
			},
			I18N_LOCALE : sLang */
		}, //boolean
		fOnAppLoad : function(){
			//예제 코드
			oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
		},
		fCreator: "createSEditor2"
	});
	
	function pasteHTML() {
		var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
		oEditors.getById["ir1"].exec("PASTE_HTML", [sHTML]);
	}
	
	function showHTML() {
		var sHTML = oEditors.getById["ir1"].getIR();
		alert(sHTML);
	}
		
	function submitContents(elClickedObj) {
		oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
		
		// 에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("ir1").value를 이용해서 처리하면 됩니다.
		
		try {
			elClickedObj.form.submit();
		} catch(e) {}
	}
	
	function setDefaultFont() {
		var sDefaultFont = '궁서';
		var nFontSize = 24;
		oEditors.getById["ir1"].setDefaultFont(sDefaultFont, nFontSize);
	}
});
</script> -->