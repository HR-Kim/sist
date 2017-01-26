<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<form action="login.jsp" method="post">
	<tr>
		<th>아이디</th>
		<td><input type="text" size="50" name="id"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="text" size="50" name="pwd"></td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="submit" value="로그인">
		</td>
	</tr>
	</form>
</table>
<a href="regi.jsp">회원가입</a>
</body>
</html>