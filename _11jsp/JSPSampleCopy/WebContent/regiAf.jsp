<%@page import="com.sist.Member"%>
<%@page import="com.sist.MemberAccess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	MemberAccess access = MemberAccess.getInstance();
	boolean isS = access.addMember(new Member(id, pwd, name, email, 0));
	
	if(isS){
	%>
		<script>
		alert("가입성공!");
		location.href("index.jsp");
		</script>
	<%		
	}else{
		%>
		<script>
		alert("가입실패..");
		location.href("index.jsp");
		</script>
	<%
	}
	%>

	
</body>
</html>