<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- html xml 주석 -->	
<%-- jsp 주석--%>	

<h1>Hello JSP</h1>

<%
	//java code
	String str = "Hello JSP";
	System.out.println("str = " + str);
	out.println("str = " + str);
	
	int number = 123;
	Date nowTime = new Date();
%>
<br><br>
str
<br><br>
<%=str %>
<br><br>
<%=number %>
<br><br>
<p>
현재 시간은<strong><%=nowTime %></strong>입니다.
</p>

<%@include file="include.jsp" %>

<!-- Java Server Page의 줄임말 - Server에서 Client코드를 생성하기 위한 것이다.
Server + client

Html + JavaScript + JQuery  + CSS + Java -->


</body>
</html>