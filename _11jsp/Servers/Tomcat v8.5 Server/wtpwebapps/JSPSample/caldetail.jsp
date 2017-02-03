<%@page import="com.sist.CalAccess"%>
<%@page import="com.sist.Cal"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>caldetail</title>
</head>
<body>
<form action="calendar.jsp" method="post">
<h2>디테일 일정</h2>
<table border="1">
<col width="200"><col width="500">
<%
String seq = request.getParameter("seq");

CalAccess access = CalAccess.getInstance();

Cal cal = access.getCal(seq);
%>
<tr>
	<td>아이디</td>
	<td>
		<input type="text" name="id" value="<%=cal.getId()%>" readonly="readonly">
	</td>
</tr>
<tr>
	<td>제목</td>
	<td>
		<input type="text" name="title" size="60" value="<%=cal.getTitle() %>" readonly="readonly">
	</td>
</tr>
<tr>
	<td>일정</td>
	<td>
		<input type="text" name="title" size="60" readonly="readonly" value="<%=cal.getRdate()%>">
	</td>
</tr>
<tr>
	<td>내용</td>
	<td>
	<textarea cols="60" rows="20" name="content"><%=cal.getContent() %></textarea>
	</td>
	
</tr>

<tr>
	<td>작성일</td>
	<td>
		<input type="text" name="title" size="60" readonly="readonly" value="<%=cal.getWdate()%>">
	</td>
</tr>

<tr>
	<td>
		<input type="button" value="수정" onclick="modifydate('<%=cal.getSeq() %>')">
		<input type="submit" value="일정보기">
	</td>
</tr>
</table>

<script type="text/javascript">
function modifydate(seq) {
	location.href = 'calupdate.jsp?seq=' + seq;
}
</script>
</form>
</body>
</html>