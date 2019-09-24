var xhr = null; 

function startMethod(){
	xhr = new XMLHttpRequest(); 
	xhr.onreadystatechange = resultProcess;
	xhr.open("GET", "ajaxExam.xml", true);
	xhr.send();
}

function resultProcess(){
	if(xhr.readyState == 4 && xhr.status == 200){
		processXML();
	}
}

function processXML(){
	var trchild = document.getElementById("resultDisp").children;
	console.log(document.getElementById("resultDisp").children);
	console.log(document.getElementById("resultDisp").childNodes);
	
	for (var i = 0; i < trchild.length; i++) {
		trchild[i].remove();
		i--; 
	}
	//2. if(trChild.length > 0) return false; 
	
	var xmlDoc = xhr.responseXML;
	var trTag, tdTag;
	var curriculum ="";
	var subject = xmlDoc.getElementsByTagName("subject");
	
//배열로 대입하기
//		let curri = [codeNumber, titleName, roomNumer];
		
		for (var i = 0; i < subject.length; i++) {
			var codeNumber = subject.item(i).getElementsByTagName("codeNumber").item(0).firstChild.nodeValue;
			var titleName = subject.item(i).getElementsByTagName("titleName").item(0).firstChild.nodeValue;
			var roomNumber = subject.item(i).getElementsByTagName("roomNumber").item(0).firstChild.nodeValue;
			//curriculum += "<tr><td>" +codeNumber+ "</td> <td>" +titleName+ "</td> <td>" +roomNumber+ "</td></tr>";
			
			trTag = document.createElement("tr");
			var childs = subject.item(i).childNodes;
			for (var j = 0; j < childs.length; j++) {
				if(childs[j].firstChild !== null) {
					tdTag = document.createElement("td");
					var text = childs[j].firstChild; 
					tdTag.appendChild(text);
					trTag.appendChild(tdTag);
				}
			}
			document.getElementById("resultDisp").appendChild(trTag);
		}
//		document.getElementById("resultDisp").innerHTML = curriculum;
	
}