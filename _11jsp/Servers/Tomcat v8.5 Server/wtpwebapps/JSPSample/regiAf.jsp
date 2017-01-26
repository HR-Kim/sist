<%@page import="com.sist.Member"%>
<%@page import="com.sist.MemberAccess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>regAf</title>
</head>
<body>

<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	
	MemberAccess access = MemberAccess.getInstance();
	
	boolean isS = access.addMember(new Member(id, name, pwd, email, 0));
	
	if (isS){
	%>
		<script type="text/javascript">
			alert("성공적으로 가입되었습니다.");
			location.href = "index.jsp";
		</script>		
	<%	
	}else{
	%>
		<script type="text/javascript">
			alert("다시 기입하십시오!");
			location.href = "regi.jsp";
		</script>
	<%
	}
	%>




</body>
</html>



























