<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!
	MainClass cls = new MainClass();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Expression(표현) Language(언어) -->

${'value'}
<!-- == -->
<%='값' %>
${'식' }
<br>
${10*2 }
<%
request.setAttribute("age", "25");
%>
${empty age }
${not empty age }

a eq b : ${a eq b }

${1 + 1 }<br>

${age }<br>
${requestScope.age }



<%
	request.setAttribute("strData", cls);
%>

String 데이터 : ${strData.getName() }<br> 
</body>
</html>




















