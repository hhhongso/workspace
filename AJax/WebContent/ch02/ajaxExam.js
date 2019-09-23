var xhr = null; 

function startMethod(){
	xhr = new XMLHttpRequest();
	xhr.onreadystatechange = resultProcess;
	xhr.open("GET", "ajaxExam.xml", true);
	xhr.send();
}

var display = document.getElementById("displayArea");

function resultProcess(){
	if(xhr.readyState == 4 && xhr.status == 200){
		display.innerHTML = xhr.responseText;
//		display.style.display="block";
		display.style.visibility = "visible";
	}
}
