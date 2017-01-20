<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="sample01.YouClass" %>
<%!
class MyClass{
	int num;
	String str;
	
	MyClass(){
		System.out.println("여기는 생성자입니다.");
	}
}
int number = 123; // global 변수
%>

<%
System.out.println("number = " + number);

MyClass cls = new MyClass();
YouClass ycls = new YouClass();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
<%int j=1; 
<%for(int i=0; i<100; ++i){ 
%>
<p><%=j %> </p>
<%j++; %>
<%} %>
--%>
<%--
<%=값만을 취득 %>
<% Java 소스 코드; %>
ycls.num<%=ycls.getNum() %>
 --%>


</body>
</html>














