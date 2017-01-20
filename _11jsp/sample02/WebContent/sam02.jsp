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
// 내용 : 받은 매개 변수 (name)를 세션에 저장
// 파라메터를 통해서 name을 취득
String name = request.getParameter("name");

//out.println("name = " + name);
name = new String(name.getBytes("8859_1"), "UTF-8");

session.setAttribute("name", name);
%>
<p>세션 변수의 저장
<p>
다음의 내용을 세션에 저장했습니다.<br>
name = <%=name%>
<br>
<a href="index.jsp">돌아가기</a>
</p>
</body>
</html>