<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
int tableSize =0;

%>
<html>
<head>
<style type="text/css">
td{
	border: 1px solid black;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
tableSize++;
%>
<table style="border: 1px solid black;">
	<%for(int i=0; i<tableSize; ++i){ %>
	<tr>
		<%for(int j=0; j<tableSize; ++j){%>
		<td><%=i %>*<%=j %>=<%=i*j %></td>
		<%} %>
	</tr>
	<%} %>
</table>
</body>
</html>