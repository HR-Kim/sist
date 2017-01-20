<%@page import="sist.com.MemberAccess"%>
<%@page import="sist.com.Member"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!
boolean isNull(String str){
	return str == null || str.trim().equals("");
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String command = request.getParameter("command");

MemberAccess memberAccess = new MemberAccess();

if(command.equalsIgnoreCase("login")){
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	System.out.println("controller login!");
	if(isNull(id) || isNull(password)){%>
		<script>alert('빈칸채워욧!'); window.history.back(); </script>
	<%}
	Member member = new Member(id, password);
	member = memberAccess.readMember(member);
}else if(command.equalsIgnoreCase("join")){
	System.out.println("controller join!");
}else if(command.equalsIgnoreCase("main")){
	System.out.println("controller main!");
}
%>
</body>
</html>
















