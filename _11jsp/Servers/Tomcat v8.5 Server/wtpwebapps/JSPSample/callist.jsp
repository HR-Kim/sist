
<%@page import="com.sist.Cal"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.CalAccess"%>
<%@page import="com.sist.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	Member user = (Member)session.getAttribute("login");

	String year = request.getParameter("year");
	String month = request.getParameter("month");
	String day = request.getParameter("day");
	
	String dates = year + two(month) + two(day);
	
	CalAccess access = CalAccess.getInstance();
	List<Cal> callist = access.getDayList(user.getId(), dates);
	
	/* for(int i = 0; i<callist.size(); i++){
		Cal cal = callist.get(i);
		out.println(cal.toString());
	} */
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>callist</title>
<%!
public String two(String msg){	//한자리를 두자리로 만들어 주는 함수
	return msg.trim().length()<2 ? "0" + msg : msg.trim();
}
%>
</head>
<body>
<table border="1">
<col width="100"><col width="200">
<col width="450"><col width="50">

<tr bgcolor="#09bbaa">
	<td>번호</td><td>시간</td><td>제목</td><td>삭제</td>
</tr>
<%
for(int i=0; i<callist.size(); i++){
	Cal cal = callist.get(i);
	%>
	<tr>
		<td><%=i+1 %></td>
		<td><%=cal.getRdate() %></td>
		<td>
			<a href="caldetail.jsp?seq=<%=cal.getSeq()%>">
			<%=cal.getTitle() %>
			</a>
		</td>
		<td>
			<form action="caldel.jsp" method="post">
				<input type="hidden" name="seq" value="<%=cal.getSeq()%>">
				<input type="submit" value="일정삭제">
			</form>
		</td>
	</tr>
<%	
}
%>
</table>
</body>
</html>



















