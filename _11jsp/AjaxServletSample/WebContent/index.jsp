<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</head>
<body>

<form id="form1">
	<input type="text" name="val" value="ajax 테스트" id="val">
	<input type="text" name="num" value="1234" id="num">
	<input type="submit" value="호출" id="call">
</form>

<div id="div1">
div태그
</div>

<script type="text/javascript">
$(function(){
	$("#call").click(function(){
		var str = $("#form1").serialize();
		
		$.ajax({
			type:"get",
			url:"./ajaxText",
			data:str,
			dataType:"json",
			success:function(data){
				alert("data.result = " + data.result);
			},
			error:function(){
				alert("에러");
			}
		});
	});
});
</script>

</body>
</html>











