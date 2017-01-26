<%@page import="com.sist.BbsAccess"%>
<%@page import="com.sist.Bbs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>answerAf</title>
</head>
<body>

<%
String sseq = request.getParameter("seq");
int seq = Integer.parseInt(sseq.trim());

String id = request.getParameter("id");
String title = request.getParameter("title");
String content = request.getParameter("content");


BbsAccess access = BbsAccess.getInstance();
boolean isS = access.answer(seq, new Bbs(id, title, content));
if(isS){
%>
	<script type="text/javascript">
		alert("답글입력 성공!");
		location.href = "bbslist.jsp";
	</script>
<%
}else{
%>
	<script type="text/javascript">
		alert("답글입력 실패...");
		location.href = "bbslist.jsp";
	</script>
<%	
}
%>
</body>
</html>