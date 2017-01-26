<%@page import="sist.com.CustUserDto"%>
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
<title>CustUser Detail</title>
</head>
<body>
<%--
	CustUserDto cust = (CustUserDto)request.getAttribute("cust");
--%>
<c:set var="cust" value="${requestScope.cust }"></c:set>
<div align="center">
<table style="width: 600;" cellpadding="0" cellspacing="0">
	<col width="200"><col width="400">
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="2"></td>
	</tr> 
	<tr bgcolor="#f6f6f6">
		<td>아이디</td>
		<td>${cust.id }</td>
	</tr>
	<tr>
		<td height="1" bgcolor="#0000ff" colspan="2"></td>
	</tr>
	<tr bgcolor="#f6f6f6">
		<td>이름</td>
		<td>${cust.name }</td>
	</tr>
	<tr>
		<td height="1" bgcolor="#0000ff" colspan="2"></td>
	</tr>
	<tr bgcolor="#f6f6f6">
		<td>주소</td>
		<td>${cust.address }</td>
	</tr>
	<tr>
		<td height="1" bgcolor="#0000ff" colspan="2"></td>
	</tr>
	
	<tr bgcolor="#f6f6f6">
		<td>고객 정보 변경</td>
		<td>
			<form action="custusercontrol.jsp" method="post">
				<input type="hidden" name="command" value="update">
				<input type="hidden" name="id" value="${cust.id }">
				<input type="submit" value="고객정보변경">
			</form>
		</td>
	</tr>
	<tr>
		<td height="1" bgcolor="#0000ff" colspan="2"></td>
	</tr>
	<tr bgcolor="#f6f6f6">
		<td>삭제</td>
		<td>
			<form action="custusercontrol.jsp">
				<input type="hidden" name="command" value="delete">
				<input type="hidden" name="id" value="${cust.id }">
				<input type="submit" value="고객정보삭제">
			</form>
		</td>
	</tr>
</table>
<br>
<c:url value="index.jsp" var="home"></c:url>
			<a href="${home }">Home</a>
<!-- <a href="index.jsp">Home</a> -->
</div>
</body>
</html>















