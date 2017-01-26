<%@page import="com.sist.MemberAccess"%>
<%@page import="com.sist.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>

<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

MemberAccess access = MemberAccess.getInstance();

Member member = access.login(new Member(id, null, pwd, null, 0));

if (member != null && !member.getId().equals("")){
	session.setAttribute("login", member);
	session.setMaxInactiveInterval(30*60);
	%>
	<script type="text/javascript">
		alert("안녕하세요<%=member.getId()%>!!");
		location.href = 'bbslist.jsp';
	</script>
<%
}else{
%>
	<script type="text/javascript">
		alert("아이디나 패스워드를 확인하십시오");
		location.href = 'index.jsp';
	</script>
<%
}
%>




</body>
</html>