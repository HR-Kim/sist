<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String arrStr[] = request.getParameterValues("interest");

for(int i=0; i< arrStr.length; ++i){
	out.println("arrStr[" +i +"] :" + arrStr[i]);
}
%>
</body>
</html>