function checkImageboard(){
	if(document.imageboardWriteForm.imageId.value == "") alert("상품코드를 입력하세요.");
	else if(document.imageboardWriteForm.imageName.value == "") alert("상품명을 입력하세요.");
	else if(document.imageboardWriteForm.imagePrice.value == "") alert("단가를 입력하세요.");
	else if(document.imageboardWriteForm.imageQty.value == "") alert("상품수량을 입력하세요.");
	else if(document.imageboardWriteForm.imageContent.value == "") alert("내용을 입력하세요.");
	else if(document.imageboardWriteForm.image1.value == "") alert("파일을 등록하세요.");
	else document.imageboardWriteForm.submit();
}