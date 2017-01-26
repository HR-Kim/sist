<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>index</title>
</head>
<body>
<c:url value="custusercontrol.jsp" var='controls'>
	<c:param name="command" value="list"></c:param>	
</c:url>

<a href="${controls }">모든 CUSTUSER 보기</a>

<!-- <a href="custusercontrol.jsp?command=list">모든 CUSTUSER 보기</a> -->

<%--
response.sendRedirect("custusercontrol.jsp?command=list");
--%>
</body>
</html>