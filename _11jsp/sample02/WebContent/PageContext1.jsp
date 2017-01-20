<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name1 = "Java";
String name2 = "Text";

pageContext.setAttribute("name1", name1, PageContext.REQUEST_SCOPE);
pageContext.setAttribute("name2", name2, PageContext.REQUEST_SCOPE);

pageContext.forward("PageContext2.jsp");
%>
<h1>PageContext1.jsp</h1>
</body>
</html>