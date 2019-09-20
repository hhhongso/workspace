function checkImageboard(){
	if(document.imageboardWriteForm.imageId.value == "") alert("상품코드를 입력하세요.");
	else if(document.imageboardWriteForm.imageName.value == "") alert("상품명을 입력하세요.");
	else if(document.imageboardWriteForm.imagePrice.value == "") alert("단가를 입력하세요."); //숫자만 들어오게: key.event < ??
	else if(document.imageboardWriteForm.imageQty.value == "") alert("상품수량을 입력하세요.");
	else if(document.imageboardWriteForm.imageContent.value == "") alert("내용을 입력하세요.");
	else if(document.imageboardWriteForm.image1.value == "") alert("파일을 등록하세요.");
	else document.imageboardWriteForm.submit();
}

	var checkbox = document.querySelectorAll(".cbx");
	var cbxMain =document.querySelector(".cbxMain");
	cbxMain.addEventListener("change", cbxChecked);

function cbxChecked(event){
	event.stopPropagation(); 
	// 자식 element에서 발생된 event가 부모 element순으로 전달 되는 버블 현상을 막아준다.
	// (자기 자신에게만 이벤트가 유효하도록 stop. 그렇지 않으면 부모(상위 DOM)의 이벤트까지 모두 실행하게 됨.)
	console.dir(event);
	
	// querySelector 사용 - forEach문 
	checkbox.forEach(o=> {
		if(cbxMain.checked) o.checked = true;
		else o.checked= false;
	})
	
	/* querySelector 사용 - 일반  for문 
	 	
	 	if(document.querySelector(".cbxNumberAll").checked){
		for (var i = 0; i < checkbox.length; i++) {
			checkbox[i].checked = true;
		}
	} else{
		for (var i = 0; i < checkbox.length; i++) {
			checkbox[i].checked = false;
		}
	} */
	
  
/*	cbxMain속성에 id를, cbx속성에 name 을 줄 경우.
 
	var cbxMain = document.getElementById("cbxMain").checked; // id 속성은 하나만 주는 것을 약속으로 한다. (mark up시 id 속성을 사용하기 때문) 
	var cbx = document.getElementsByName("cbx"); // name 속성은 중복될 수 있다. name=cbx 인 변수의 갯수를 가져온다. 
	
	if(cbxMain){
		for (var i = 0; i < cbx.length; i++) {
			cbx[i].checked = true;
		}
	} else {
		for (var i = 0; i < cbx.length; i++) {
			cbx[i].checked = false;
		}
	}*/
}

/*
object (자바스크립트의 최상위 객체)
	- Element (interface)
		- checkbox, input, tr, td, ... (모든 tag)*/
		

function delConfirm(){
	var sw = 0;
	var seq = [];
	checkbox.forEach(o=>{
		if(o.checked) {
			sw = 1;
			seq.push(o.value);
		}
	})
	
	if(sw == 0) alert("삭제할 항목을 선택하세요.");
	else {
		if(confirm("정말로 삭제하시겠습니까?")) location.href="/miniProject/imageboard/imageboardDelete.do?seq="+seq; //document.imageboardListForm.submit();
		else location.href="/miniProject/imageboard/imageboardList.do?pg=1";
		
	}
}