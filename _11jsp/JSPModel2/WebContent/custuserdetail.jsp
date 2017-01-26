<%@page import="sist.com.dto.CustUserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
	CustUserDto cust = (CustUserDto)request.getAttribute("cust");
%>
<div align="center">
<table style="width: 600;" cellpadding="0" cellspacing="0">
	<col width="200"><col width="400">
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="2"></td>
	</tr> 
	<tr bgcolor="#f6f6f6">
		<td>아이디</td>
		<td><%=cust.getId() %></td>
	</tr>
	<tr>
		<td height="1" bgcolor="#0000ff" colspan="2"></td>
	</tr>
	<tr bgcolor="#f6f6f6">
		<td>이름</td>
		<td><%=cust.getName() %></td>
	</tr>
	<tr>
		<td height="1" bgcolor="#0000ff" colspan="2"></td>
	</tr>
	<tr bgcolor="#f6f6f6">
		<td>주소</td>
		<td><%=cust.getAddress()%></td>
	</tr>
	<tr>
		<td height="1" bgcolor="#0000ff" colspan="2"></td>
	</tr>
	
	<tr bgcolor="#f6f6f6">
		<td>고객 정보 변경</td>
		<td>
			<form action="./custUpdateCtr" method="post">
				<input type="hidden" name="command" value="update">
				<input type="hidden" name="id" value="<%=cust.getId()%>">
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
			<form action="./custDeleteCtr">
				<input type="hidden" name="command" value="delete">
				<input type="hidden" name="id" value="<%=cust.getId()%>">
				<input type="submit" value="고객정보삭제">
			</form>
		</td>
	</tr>
</table>
<br>
<a href="index.jsp">Home</a>
</div>
</body>
</html>















