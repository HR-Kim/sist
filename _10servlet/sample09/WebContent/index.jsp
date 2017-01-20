<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="dispatchtest">
<table border="0">
<tr>
	<td>나이</td>
	<td>
		<input type="text" size="10" name="age">
	</td>
</tr>
<tr>
	<td>연수입</td>
	<td>
		<input type="text" size="10" name="pay">
	</td>
</tr>

<tr>
	<td>성별</td>
	<td>
		<select name="manlady">
			<option>남성</option>
			<option>여성</option>
		</select>
	</td>
</tr>
</table>

<input type="submit" value="송신">
<input type="reset" value="reset">

</form>
</body>
</html>










