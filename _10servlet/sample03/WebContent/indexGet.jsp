<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>indexGet.jsp</h1>

<p>상태코드 선택</p>

<form action="hj">	<!-- default값은 get방식이다. -->

<table>
	<tr>
		<td>상태코드</td>
		<td>
			<select name="code" size="3" multiple="multiple">	<!-- name은 중복가능! -->
				<option value="200">SC_OK</option>
				<option value="404">SC_NOT_FOUND</option>
				<option value="500">SC_INTERNAL_SERVER_ERROR</option>
			</select>
		</td>
	</tr>
</table>
<input type="submit" value="송신" name="button1">
</form>
</body>
</html>










