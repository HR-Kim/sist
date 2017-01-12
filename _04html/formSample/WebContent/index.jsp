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
//여기는 Server 코드가 됩니다. -->JSP
String firstName = request.getParameter("firstName");
out.println("firstName = " + firstName);

String lastName = request.getParameter("lastName");
out.println("LastName = " + lastName);
%>
</body>
</html>