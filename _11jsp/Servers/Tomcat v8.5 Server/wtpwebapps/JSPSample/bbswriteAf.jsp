
<%@page import="com.sist.Bbs"%>
<%@page import="com.sist.BbsAccess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bbs writeAf</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BbsAccess access = BbsAccess.getInstance();
	
	boolean isS = access.writeBbs(new Bbs(id, title, content));
	
	if (isS){
	%>
		<script>
			alert("글 입력 성공");
			location.href = 'bbslist.jsp';
		</script>
	<%	
	}else{
		%>
		<script>
			alert("글 입력 실패");
			location.href = 'bbswrite.jsp';
		</script>
	<%	
	}
%> 
</body>
</html>