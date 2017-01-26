<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p id="result">여기가 result</p>
<button>Ajax run</button>

<script type="text/javascript">
$(function () {
	$("button").click(function() {
		$.ajax({
			url:"test.jsp",
			type:"get",
			data:"t1=AAA&t2=BBB",
			success:function(data, status, xhr){
				//alert("통신성공!");
				$("#result").html(data + " " + status + " " + xhr.status);
			},
			error:function(xhr, status, error){
				alert("통신실패!");
			},
			complete:function(xhr, status){
				alert("통신종료!");
			}
		});
	});
})
</script>
</body>
</html>