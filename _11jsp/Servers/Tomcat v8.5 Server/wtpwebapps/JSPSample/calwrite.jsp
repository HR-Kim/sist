<%@page import="java.util.Calendar"%>
<%@page import="com.sist.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<%
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");

System.out.println(year + "년" + month + "월" + day + "일");

Member user = (Member)session.getAttribute("login");



Calendar cal = Calendar.getInstance();
int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH) + 1;
int tday = cal.get(Calendar.DATE);
int thour = cal.get(Calendar.HOUR);
int tmin = cal.get(Calendar.MINUTE);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="calwriteAf.jsp" method="post">
<h2>일정쓰기</h2>
<table border="1">
<col width="200"><col width="500">
<tr>
	<td>아이디</td>
	<td>
		<%=user.getId() %>
		<input type="hidden" name="id" value="<%=user.getId()%>">
	</td>
</tr>
<tr>
	<td>제목</td>
	<td>
		<input type="text" name="title" size="60">
	</td>
</tr>
<tr>
	<td>일정</td>
	<td>
		<select name="year">
		<%
		for(int i=tyear-5; i < tyear+6; ++i){
		%>
			<option <%=year.equals(i+"")?"selected='selected'":"" %> value="<%=i%>"><%=i %></option>
		<%	
		}
		%>
		</select>년
		
		<select name="month">
		<%
		for(int i = 1; i<= 12; i++){
		%>
			<option <%=month.equals(i+"")?"selected='selected'":"" %>
			 value="<%=i%>"><%=i %></option>
		<%
		}
		%>
		</select>월
		<select name="day">
		<%
		for(int i = 1; i<=cal.getActualMaximum(Calendar.DAY_OF_MONTH); ++i){
		%>
			<option <%=day.equals(i+"")?"selected='selected'":"" %>
			value="<%=i%>"><%=i %></option>
		<%	
		}
		%>
		</select>일
		<select name="hour">
		<%
		for(int i = 0; i<24; ++i){
		%>
			<option <%=(thour+"").equals(i+"")?"selected='selected'":"" %>
			value="<%=i%>"><%=i %></option>
		<%	
		}
		%>
		</select>시
		
		<select name="min">
		<%
		for(int i = 0; i<60; ++i){
		%>
			<option <%=(thour+"").equals(i+"")?"selected='selected'":"" %>
			value="<%=i%>"><%=i %></option>
		<%	
		}
		%>
		</select>분
	</td>
</tr>
<tr>
	<td>내용</td>
	<td>
	<textarea cols="60" rows="20" name="content"></textarea>
	</td>
	
</tr>

<tr>
	<td colspan="2">
		<input type="submit" value="글쓰기">
	</td>
</tr>
</table>
</form>
<%
String url = String.format("%s?year=%s&month=%s", "calendar.jsp", year, month);
%>
<a href="<%=url%>">일정보기</a>

<script type="text/javascript">
$(document).ready(function(){
    $("select[name='month']").change(function(){
        alert($(this).val());  
        var lastDay = ( new Date( $("select[name='year']").val()+"", $("select[name='month']").val()+"", 0) ).getDate();
        alert("lastDay = " + $("select[name='year']").val());
        
		var str = "";
        for(i = 1;i <= lastDay; i++){
        	str +="<option value='"+i+"'>" + i + "</option>";
        }
        
        $("select[name='day']").html(str); 
    });    
});

</script>

</body>
</html>

















