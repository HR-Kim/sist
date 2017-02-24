<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="mini_control.jsp" method="get">
<input type="hidden" name="command" value="edit">

<%
	String mi_id = request.getParameter("mi_id");
	String mi_name = request.getParameter("mi_name");
	String mi_date = request.getParameter("mi_date");
	String mi_email = request.getParameter("mi_email");
	String mi_passwd = request.getParameter("mi_passwd");
	String mi_contents = request.getParameter("mi_contents");

%>
<input type="hidden" value="<%=mi_id%>" name="mi_id">
<table border="1">
<col width="120"><col width="200">
<tr>
	<td>작성자</td>
	<td><input type="text" value="<%=mi_name%>" name="mi_name" readonly="readonly" style="width: 400px"></td>
</tr>
<tr>
	<td>작성일</td>
	<td><input type="text" value="<%=mi_date%> " name="mi_date" style="width: 400px"></td>
</tr>
<tr>
	<td>e-mail</td>
	<td><input type="text" value="<%=mi_email %>" name="mi_email" style="width: 400px"></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" name="mi_passwd" style="width: 400px"></td>
</tr>
<tr>
	<td>내용</td>
	<td></td>
</tr>
<tr>
<td colspan="2"><textarea rows="4" cols="100" name="mi_contents"><%=mi_contents%></textarea></td>
</tr>
</table>
<input type="button" value="목록" onclick="document.location='mini_control.jsp?command=list'">
<input type="submit" value="수정">
<input type="button" value="삭제" onclick="document.location='mini_control.jsp?command=delete&mi_id=<%=mi_id%>'">
</form>
</div>
</body>
</html>