<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="xmlhttp.js">

</script>
</head>
<body>
<h1>서버에서 XML파일 읽기</h1>

<form name="ajaxForm">
	<input type="button" value="data.xml을 로드"
		onclick="loadXMLFile('data.xml')">
</form>

<div id="result"></div>

<script type="text/javascript">
function loadXMLFile(fName) {
	httpObj = createXMLHttpRequest(displayData);
	if(httpObj){
		httpObj.open("get", fName, true);
		httpObj.send(null);
	}
}

function displayData() {
	if((httpObj.readyState == 4) && (httpObj.status == 200)){
		document.getElementById("result").innerHTML = httpObj.responseXML;
		xmlData = httpObj.responseXML;
		
		userListTags = xmlData.getElementsByTagName("user");
		numberListTags = xmlData.getElementsByTagName("number");
		usernameListTags = xmlData.getElementsByTagName("username");
		
		userLen = userListTags.length;
		
		resultText = "";
		
		for(i = 0; i<userLen; ++i){
			num = numberListTags[i].childNodes[0].nodeValue;
			uname = usernameListTags[i].childNodes[0].nodeValue;
			resultText = resultText + num + ":" + uname + "<br>";

		}
		document.getElementById("result").innerHTML = resultText;
	}else{
		document.getElementById("result").innerHTML = "<b>Loading...</b>";
	}
}
</script>
</body>
</html>