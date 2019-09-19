function checkImageboard(){
	if(document.imageboardWriteForm.imageId.value == "") alert("상품코드를 입력하세요.");
	else if(document.imageboardWriteForm.imageName.value == "") alert("상품명을 입력하세요.");
	else if(document.imageboardWriteForm.imagePrice.value == "") alert("단가를 입력하세요.");
	else if(document.imageboardWriteForm.imageQty.value == "") alert("상품수량을 입력하세요.");
	else if(document.imageboardWriteForm.imageContent.value == "") alert("내용을 입력하세요.");
	else if(document.imageboardWriteForm.image1.value == "") alert("파일을 등록하세요.");
	else document.imageboardWriteForm.submit();
}

//숫자만 들어오게: key.event < ??


var checkbox = document.querySelectorAll(".cbx");
var cbxMain =document.querySelector(".cbxMain");
cbxMain.addEventListener("change", cbxChecked);

function cbxChecked(event){
	event.stopPropagation(); 
	// 자식 element에서 발생된 event가 부모 element순으로 전달 되는 버블 현상을 막아준다.
	// (자기 자신에게만 이벤트가 유효하도록 stop. 그렇지 않으면 부모(상위 DOM)의 이벤트까지 모두 실행하게 됨.)
	console.dir(event);
	checkbox.forEach(o=> {
		if(cbxMain.checked) o.checked = true;
		else o.checked= false;
	})
	
	/* if(document.querySelector(".cbxNumberAll").checked){
		for (var i = 0; i < checkbox.length; i++) {
			checkbox[i].checked = true;
		}
	} else{
		for (var i = 0; i < checkbox.length; i++) {
			checkbox[i].checked = false;
		}
	} */
}

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
	else if(sw == 1) {
		if(confirm("정말로 삭제하시겠습니까?")) location.href="/miniProject/imageboard/imageboardDelete.do?seq="+seq;
		else location.href="/miniProject/imageboard/imageboardList.do?pg=1";
		
	}
}