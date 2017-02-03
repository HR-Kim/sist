<%@page import="com.sist.Member"%>
<%@page import="com.sist.CalAccess"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.Cal"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>calendar.jsp</title>
<style type="text/css">
#big{
	border-collapse: collapse;
	width: 700px;
	border: 1;
}

table, td, th{
	border: 1px solid black;
}
tr{
	height: 100px;
}
.small{
	height: 20px;
	border: none;
}
tr.date{
	font-size: 30px;
	text-align: center;
}
.t1{
	margin: auto;
	width: 706px;
	border: 3px solid #8AC007;
	padding: 10px;
}

</style>
<%!
public boolean nvl(String msg){
	return msg == null || msg.trim().equals("") ? true : false;	//빈문자이거나 null일때 true
}

public String callist(int year, int month, int day){
	String s = "";
	s += String.format("<a href='%s?year=%d&month=%d&day=%d'>", "callist.jsp", year, month, day);
	s += String.format("%2d", day);
	s += "</a>";
	return s;
}

public String showpen(int year, int month, int day){
	String s = "";
	String url = "calwrite.jsp";
	String image = "<img src='./image/pen.gif'>";
	s = String.format("<a href='%s?year=%d&month=%d&day=%d'>%s</a>", url, year, month, day, image);
	
	return s;
}

public String two(String msg){	//한자리를 두자리로 만들어 주는 함수
	return msg.trim().length()<2 ? "0" + msg : msg.trim();
}
//제목이 15자 이상이면...표시한다.
public String dot3(String msg){
	String s = "";
	if(msg.length() >= 15){
		s = msg.substring(0, 15);
		s += "...";
	}else{
		s = msg.trim();
	}
	return s;
}

public String makeTable(int year, int month, int day, List<Cal> calList){
	String s = "";
	String dates = (year+"") + two(month+"") + two(day+"");
	s = "<table>";
	s += "<col width='98'/>";
	
	for(Cal lcd:calList){
		System.out.println(lcd);
		if(lcd.getRdate().substring(0, 8).equals(dates)){
			s += "<tr bgcolor='pink' class='small'>";
			s += "<td>";
			s += "<a href='caldetail.jsp?seq=" + lcd.getSeq() + "'>";
			s += "<font style='font-size:8px; color:red'>";
			s += dot3(lcd.getTitle());
			s += "</font>";
			s += "</a>";
			s += "</td>";
			s += "</tr>";
		}		
	}
	s += "</table>";
	return s;	
}
%>
</head>
<body>

<h1>달력</h1>

<%
Calendar cal = Calendar.getInstance();
cal.set(Calendar.DATE, 1);

String syear = request.getParameter("year");
String smonth = request.getParameter("month");

int year = cal.get(Calendar.YEAR);
if(!nvl(syear)){
	year = Integer.parseInt(syear);
}
int month = cal.get(Calendar.MONTH) + 1;
if(!nvl(smonth)){
	month = Integer.parseInt(smonth);
}

if(month<1){month = 12; year--;}
if(month>12){month = 1; year++;}

cal.set(year, month-1, 1);

int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
//요일 1 ~ 7

CalAccess access = CalAccess.getInstance();

Member user = (Member)session.getAttribute("login");

List<Cal> calList = access.calList(user.getId(), year+two(month+""));

/* String sf = String.format("%d년 %d월", year, month);

String sleft = String.format("calendar.jsp?year=%d&month=%d", year, month-1);
String sright = String.format("calendar.jsp?year=%d&month=%d", year, month+1); */

String pp = String.format("<a href='%s?year=%d&month=%d'><img src='image/left.gif'></a>",
		"calendar.jsp", year-1, month);
String p = String.format("<a href='%s?year=%d&month=%d'><img src='image/prev.gif'></a>",
		"calendar.jsp", year, month-1);
String nn = String.format("<a href='%s?year=%d&month=%d'><img src='image/last.gif'></a>",
		"calendar.jsp", year+1, month);
String n = String.format("<a href='%s?year=%d&month=%d'><img src='image/next.gif'></a>",
		"calendar.jsp", year, month+1);
%>

<div class="t1">
<table border="1" id="big">
<col width="100"><col width="100"><col width="100">
<col width="100"><col width="100"><col width="100">
<col width="100">

<%-- <tr class="date">
	<td colspan="7">
		<a href="<%=sleft%>">
			<img src="./image/left.png">
			<%=sf %>
		</a>
		<a href="<%=sright%>">
			<img src="./image/right.png">
		</a>
	</td>
</tr> --%>

<tr height="100">
	<td colspan="7" align="center">
		<%=pp %>
		<%=p %>
			<font color="red" style="font-size: 50">
				<%=String.format("%d년&nbsp;&nbsp;%d월", year, month) %>
			</font>
		<%=n %>
		<%=nn %>
	</td>
</tr>
<tr class="date">
	<td>일</td>
	<td>월</td>
	<td>화</td>
	<td>수</td>
	<td>목</td>
	<td>금</td>
	<td>토</td>
</tr>
<tr height="100" align="left" valign="top">
<%
for(int i = 1; i < dayOfWeek; i++){
%>

	<td>&nbsp;</td>
<%
}

int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

for(int i = 1; i<= lastDay; i++){
%>
	<%-- <td height="100" align="left" valign="top">
	<%=i %>
	<a href="calwrite.jsp?year=<%=year %>&month=<%=month %>&day=<%=i%>">
		<img src="./image/pen.gif">
	</a>
	</td> --%> 
	
	<td>
		<%=callist(year, month, i) %>&nbsp;<%=showpen(year, month, i) %>
	 	<%=makeTable(year, month, i, calList) %>
	</td>
<%
	if((i+ dayOfWeek - 1)%7==0){
	%>
		</tr height="100" align="left" valign="top"><tr>
	<%	
	}
}

for(int i = 0; i< (7-(dayOfWeek + lastDay -1)%7)%7; i++){
%>
	<td>&nbsp;</td>
<%
}
%>

</tr>
</table>

</div>
</body>
</html>

















