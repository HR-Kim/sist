<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="xmlhttp.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>일치하는 데이터를  실시간으로 표시</h1>

<form name="ajaxForm">
	<input type="text" value="라면" name="requestText">
	<br>
</form>

<div id="result"></div>

<script type="text/javascript">
function loadDataFile(fName) {
	httpObj = createXMLHttpRequest(displayData);
	if(httpObj){
		httpObj.open("get", fName, true);
		httpObj.send(null);
	}
}
function displayData() {
	if((httpObj.readyState == 4) && (httpObj.status == 200)){
		document.getElementById("result").innerHTML = parseTabText(httpObj.responseText);
	}else{
		document.getElementById("result").innerHTML = "<b>Loading...</b>";
	}
}

function parseTabText(tabText) {
	var resultText = "<table border='1' cellspacing='0'>";
	var LF = String.fromCharCode(10);	//개행코드/n
	var Tab = String.fromCharCode(9);	//탭코드\t
	
	lineData = tabText.split(LF);
	//배열
	for(var i = 0; i< lineData.length; ++i){
		wCount = lineData[i].split(Tab);
		str = wCount[1].match(findText);
		if(str){
			resultText += "<tr><td>" + wCount[1] + "</td>"
						+ "<td align='right'><b>" + wCount[2] + "</b></td></tr>"
		}
		
	}
	resultText += "</table>";
	return resultText;
}

function inputCheck() {
	findText = document.ajaxForm.requestText.value;	//검색할 문자
	findTextOld = "";
	if(findText != findTextOld){
		loadDataFile('sample.txt');
		findTextOld = findText;
	}
	setTimeout("inputCheck()", 500);
}
window.onload = inputCheck();
</script>
</body>
</html>




