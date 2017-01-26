<%@page import="jsp.tag.myClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<fmt:requestEncoding value="UTF-8"/>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- JSP tag --%>
<p>index 이전</p>

<jsp:include page="NewFile.jsp"></jsp:include>
<%
// servlet -> include
// c: import
// jsp : inclue
%>
<p>index 이후</p>

<%
String linkfile = "NewFile";
%>
<%-- <jsp:forward page='<%=linkfile +".jsp' %>'></jsp:forward> --%>
<%-- <jsp:forward page="NewFile.jsp">
	<jsp:param value="설현" name="name"/>
	<jsp:param value="2017" name="num"/>
</jsp:forward> --%>

<%-- jsp:userBeam --%>

<%--
myClass cls = new myClass();
cls.setName("설현");
out.println(cls.getName());
--%>

<jsp:useBean id="cls" scope="request" class="jsp.tag.myClass"></jsp:useBean>
<%
cls.setName("설현");
out.println(cls.getName());
%>
<jsp:setProperty property="name" name="cls" value="초아"/>
<%
out.println(cls.getName());
%>
<jsp:getProperty property="name" name="cls"/>
<P>여기는 index.jsp입니다.</P>
</body>
</html>


























