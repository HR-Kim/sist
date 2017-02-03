<%@page import="com.sist.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	Member user = (Member)session.getAttribute("login");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bbslist.jsp</title>
</head>
<body>
<form action="">

</form>
</body>
</html>