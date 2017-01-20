<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>앙케이트조사</p>
<form action="hj" method="post">
<table>
	<tr>
		<td>이름</td>
		<td>
			<input type="text" size="20" name="name">
		</td>
	</tr>
	<tr>
		<td>나이</td>
		<td>
			<input type="text" size="5" name="age">
		</td>
	</tr>
	<tr>
		<td>좋아하는 과일</td>
		<td>
			<select name="fruit" size="3" multiple>
			<option value="apple">사과</option>
			<option value="melon">메론</option>
			<option value="grape">포도</option>
			</select>
		</td>
	</tr>
</table>
<input type="submit" value="전송">
</form>
</body>
</html>










