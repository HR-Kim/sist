<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 창</h1>
<form name="f1" action="membercontrol.jsp">
<input type="hidden" name="command" value="" id="command">
<table style="width: 700;"cellpadding="0" cellspacing="0">
	<col width="100"><col width="200">
	<tr>
		<td height="2" bgcolor="#eeddff" colspan="2"></td>
	</tr>
	<tr bgcolor="#f6f6f6">
		<td>아이디</td>
		<td><input type="text" name="id" size="60"></td>
	</tr>
	
	<tr>
		<td height="2" bgcolor="#eeddff" colspan="2"></td>
	</tr>
	<tr bgcolor="#f6f6f6">
		<td>비밀번호</td>
		<td><input type="password" name="password" size="60"></td>
	</tr>
	
	<tr>
		<td height="2" bgcolor="#eeddff" colspan="2"></td>
	</tr>
	<tr>
		<td align="center" height="4" bgcolor="white" colspan="2">
		<input type="button" id="login" value="로그인" onclick="forwardTo(1)">
		<input type="button" id="join" value="회원가입" onclick="forwardTo(2)">
		</td>
	</tr>
</table>
</form>
<script type="text/javascript">
function forwardTo(n) {
	if(n == 1){
		document.getElementById('command').value = 'login';
	}else if(n == 2){
		document.getElementById('command').value = 'join';
	}
	document.f1.submit();
}

</script>
</body>
</html>