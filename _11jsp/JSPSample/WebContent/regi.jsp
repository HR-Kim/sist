<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.1.1.min.js"></script>
<title>회원등록</title>

<style type="text/css">
.center{
	margin: auto;
	width: 60%;
	border: 3px solid #8Ac007;
	padding: 10px;
</style>
</head>
<body>
<h1>회원등록</h1>
<p>환영합니다</p>
<div class="center">
<form action="regiAf.jsp" method="post">

<table border="1">
<tr>
	<td>아이디</td>
	<td><input type="text" name="id" size="20" id="id"></td>
	<td><input type="button" id="btn" value="아이디확인"></td>
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="name" size="20"></td>
</tr>
<tr>
	<td>패스워드</td>
	<td><input type="text" name="pwd" size="20"></td>
</tr>
<tr>
	<td>이메일</td>
	<td><input type="text" name="email" size="20"></td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="회원가입"></td>
</tr>
</table>
</form>
</div>

<a href="index.jsp">Home</a>

<script type="text/javascript">
$(function(){
	$("#btn").click(function(){
		$.ajax({	//서버와 클라이언트 공존
			type:"post",
			url:"idcheck.jsp",	//서버
			data:{
				"id":$('#id').val()	//뒤의 값을 앞의 문자열로 보낸다.
				
			},
			success:function(data){
				if($.trim(data) == "YES"){
					alert($('#id').val() + '는 사용가능한 id입니다.');
				}else{
					alert($('#id').val() + '는 사용할 수 없습니다.');
				}
			}
		});
	});	
});
</script>
</body>
</html>
















