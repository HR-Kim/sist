<%@page import="com.sist.Cal"%>
<%@page import="com.sist.CalAccess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<%!
public String two(String msg){	//한자리를 두자리로 만들어 주는 함수
	return msg.trim().length()<2 ? "0" + msg : msg.trim();
}
%>

<%
String id = request.getParameter("id");
String title = request.getParameter("title");
String content = request.getParameter("content");

String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");
String hour = request.getParameter("hour");
String min = request.getParameter("min");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>calwriteAfter</title>
</head>
<body>

<%
String wdate = year+two(month) + two(day) + two(hour) + two(min);

CalAccess access = CalAccess.getInstance();

boolean isS = access.addCalendar(new Cal(id, title, content, wdate));

String url = String.format("%s?year=%s&month=%s", "calendar.jsp", year, month);
%>
<%
if(isS){
%>
	<script type="text/javascript">
	alert("성공적으로 입력되었습니다.");
	location.href= "<%=url%>";
	</script>
<%
}else{
%>
	<script type="text/javascript">
	alert("일정을 입력하지 못했습니다.");
	location.href= "<%=url%>";
	</script>
<%
}
%>
</body>
</html>















