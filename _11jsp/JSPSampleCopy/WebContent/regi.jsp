<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="regiAf.jsp" method="post">
<table border="1">
	<tr>
		<th>아이디</th>
		<td><input type="text" size="20" name="id"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="text" size="20" name="pwd"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" size="20" name="name"></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type="text" size="20" name="email"></td>
	</tr>
	<tr>
		<td colspan="3" align="center"><input type="submit" value="회원가입"></td>
	</tr>
	<tr>
		<td align="center"><a href="index.jsp">가입 취소</a></td>
	</tr>
</table>
</form>
</body>
</html>