<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--

Asynchronous JAscript XML
비동기
 --%>
 
<h1>XMLHttpRequest</h1>

<form name="ajaxForm">
	<input type="button" value="읽기" onclick="loadTextFile()">
	<textarea rows="5" cols="40" name="result"></textarea>
</form>

<script type="text/javascript">
function loadTextFile() {
	httpObj = null
	try{
		httpObj = new XMLHttpRequest();	
	}catch(e){
		document.ajaxForm.result.value = "Http통신을 할 수 없습니다.";
	}
	
	if(httpObj != null){
		httpObj.onload = displayData;
		httpObj.open("get", "text.txt", true);
		httpObj.send(null);
	}else{
		document.ajaxForm.result.value = "Http통신을 할 수 없습니다.";
	}
	
	
}
function displayData() {
	document.ajaxForm.result.value = httpObj.responseText;
}
</script>
</body>
</html>
















