<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
public String textColor(String text, String color){
	StringBuffer buf = new StringBuffer();
	buf.append("<div style=\"color:"+color+"\">");
	buf.append(text);
	buf.append("</div>");
	return buf.toString();
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Hello World!</h1>
<p>Hello World</p>
<%
	Calendar cal = Calendar.getInstance();

	GregorianCalendar cal1 = new GregorianCalendar();	//Calendar : getInstance();
	int nowTime = cal1.get(Calendar.HOUR_OF_DAY);
	
%>

<p>-- 시간을 출력하는 예 --</p>
현재시각은<%=cal.getTime() %>입니다.

<%
	int hour = cal.get(Calendar.HOUR_OF_DAY);
%>
<%
	if(hour >= 6 && hour<=12){%>
	<p>Good Morning!!!</p>
<%}else if(hour > 12 && hour<=18){ %>
	<p>Good Afternoon!!</p>
<%}else if(hour >= 19 && hour<=21){ %>
	<p>Good Evening!</p>
<%}else{ %>
	<p>Good Night..</p>
<%}%>

<form action="hw1_1.jsp">
이름: <input type="text" size="20" name="name"><br>
생년월일: <input type="text" size="16" name="birth"><br>
<input type="submit" value="OK">
</form>

<%
	String red = textColor("빨간색텍스트", "red");
	String blue = textColor("파란색텍스트", "blue");
	String green = textColor("녹색", "green");
%>

<%=red %>
<%=blue %>
<%=green %>	<%-- ${green } EL tag --%>
</body>
</html>








