<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>JSP실습</h3>
<%

String isExist = (String)session.getAttribute("counter");
 if(isExist == null){
	int count = 0;
	session.setAttribute("counter", Integer.toString(count));	
	out.println(count);
}else{
	String countStr = (String)session.getAttribute("counter");
	int count1 = Integer.parseInt(countStr);
	count1++;
	session.setAttribute("counter", Integer.toString(count1));
	out.println(count1);
} 
%>
</body>
</html>