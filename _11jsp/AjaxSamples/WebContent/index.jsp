<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
</head>
<body>

<p id="result">여기가 result에 해당</p>
<input type="text" width="20" value="aaa" id="tf">
<button>click</button>

<script type="text/javascript">
$(document).ready(function() {
	$("button").click(function(){
	//	$("#result").text("Hello");
	//	$("#tf").val("Hello");
	
	//	$("#result").load("test.html #session1");
	//	$("#result").load("test.jsp", "t1=AAA&t2=BBB");	// get
	//	$("#result").load("test.jsp", {t1:"AAA"&t2:"BBB"});	// post
		$("#result").load("test.html", function(data, status, xhr){
										// test.html데이터, success, 200
			$("#result").append("data = " + data + "<br>");
			$("#result").append("status = " + status + "<br>");	//success
			$("#result").append("xhr.status = " + xhr.status + "<br>");	// 200
			$("#result").append("xhr.statusText = " + xhr.statusText + "<br>");	// OK
		});
	});
	
});
</script>

</body>
</html>