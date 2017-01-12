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
String car = request.getParameter("car");
String message = request.getParameter("msg");
%>

선택하신 자동차는:<%=car %>
<br><br>
<textarea rows="10" cols="">
<%=message %>
</textarea>
</body>
</html>