<%@page import="com.sist.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.center{
	margin: auto;
	width: 60%;
	border: 3px solid #8Ac007;
	padding: 10px;
}
input{
	size:50;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bbs write</title>
</head>
<%
Object ologin = session.getAttribute("login");
Member member = null;
member = (Member)ologin;
%>
<body>

<a href='logout.jsp'>로그 아웃</a>

<h1>글쓰기</h1>

<div class="center">

<form action="bbswriteAf.jsp" method="post">

<table border="1">
<col width="200"><col width="500">

<tr>
	<td>아이디</td>
	<td>
		<input type="text" name="id" readonly="readonly" value="<%=member.getId()%>">
	</td>
</tr>

<tr>
	<td>제목</td>
	<td>
		<input type="text" name="title" size="50">
	</td>
</tr>

<tr>
	<td>내용</td>
	<td>
		<textarea rows="10" cols="50" name="content"></textarea>
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="글쓰기">
	</td>
</tr>
</table>
</form>
<a href='bbslist.jsp'>글목록</a>

</div>

</body>
</html>

















