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
// application
//web.xml에 context-param으로 설정한 후에 사용하는 암시객체
String id = application.getInitParameter("id");
String pass = application.getInitParameter("pass");

out.println("id = " + id);
out.println("<br>");
out.println("pass = " + pass);

%>
</body>
</html>
