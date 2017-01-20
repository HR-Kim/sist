<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 내용 : 세션을 종료
// 세션 변수를 해방
session.invalidate();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>세션 종료</p>
<p>
세션을 종료하고 세션 변수를 해제했습니다
<br>
<a href="index.jsp">돌아가기</a>
</p>
</body>
</html>