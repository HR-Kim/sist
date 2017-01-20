<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String birth = request.getParameter("birth");
	//getParameter는 String을 받고  getAttribute는 객체를 받는다.
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>--사용자의 입력을 출력한다--</p>
<ul>
	<li>이름 :<%=name %></li>
	<li>생일 :<%=birth %></li>
</ul>
</body>
</html>