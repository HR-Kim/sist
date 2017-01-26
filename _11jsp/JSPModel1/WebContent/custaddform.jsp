<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
고객추가
<form action="custusercontrol.jsp" name="formAdd" method="post">
	<input type="hidden" name="command" value="add">
	
	<table style="width: 600" cellpadding="0" cellspacing="0">
	<col width="200"><col width="400">
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="2"></td>
	</tr>
	<tr bgcolor="#f6f6f6">
		<td align="center">아이디</td>
		<td>
			<input type="text" name="id" size="60">
		</td>
	</tr>
	<tr>
		<td height="1" bgcolor="#0000ff" colspan="2"></td>
	</tr>
	<tr bgcolor="#f6f6f6">
		<td align="center">이름</td>
		<td>
			<input type="text" name="name" size="60">
		</td>
	</tr>
	<tr>
		<td height="1" bgcolor="#0000ff" colspan="2"></td>
	</tr>
	<tr bgcolor="#f6f6f6">
		<td align="center">주소</td>
		<td>
			<input type="text" name="address" size="60">
		</td>
	</tr>
	<tr>
		<td height="1" bgcolor="#0000ff" colspan="2"></td>
	</tr>
	<tr>
		<td height="1" bgcolor="#0000ff" colspan="2"></td>
	</tr>
	<tr bgcolor="#f6f6d6">
		<td align="center" colspan="2">
			<input type="submit" value="고객추가">
			<input type="reset" value="추가취소">
		</td>
	</tr>
	<tr>
		<td height="1" bgcolor="#0000ff" colspan="2"></td>
	</tr>
	</table>
</form>
<br>
<c:url value="index.jsp" var="home"></c:url>
			<a href="${home }">Home</a>
<!-- <a href="index.jsp">Home</a> -->
</div>
</body>
</html>