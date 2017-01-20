<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>

<%! String yoil[] = {"일", "월", "화", "수", "목", "금", "토"}; %>


<%
Calendar cal = Calendar.getInstance();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
System.out.println("이 해의 년도 : " + cal.get(Calendar.YEAR));

System.out.println("월(0~11, 0:1월): " + (cal.get(Calendar.MONTH) + 1));
System.out.println("이 해의 몇 째 주: " + cal.get(Calendar.WEEK_OF_YEAR));
System.out.println("이 달의 몇 째 주: " + cal.get(Calendar.WEEK_OF_MONTH));
// DATE와 DAY_OF_MONTH는 같다.
System.out.println("이 달의 몇 일: " + cal.get(Calendar.DATE));
System.out.println("이 달의 몇 일: " + cal.get(Calendar.DAY_OF_MONTH));
System.out.println("이 해의 몇 일: " + cal.get(Calendar.DAY_OF_YEAR));
// 1:일요일, 2:월요일, ... 7:토요일
System.out.println("요일(1~7, 1:일요일): " + cal.get(Calendar.DAY_OF_WEEK)); 
System.out.println("이 달의 몇 째 요일: " + cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
System.out.println("오전_오후(0:오전, 1:오후): " + cal.get(Calendar.AM_PM));
System.out.println("시간(0~11): " + cal.get(Calendar.HOUR));
System.out.println("시간(0~23): " + cal.get(Calendar.HOUR_OF_DAY));
System.out.println("분(0~59): " + cal.get(Calendar.MINUTE));
System.out.println("초(0~59): " + cal.get(Calendar.SECOND));
System.out.println("1000분의 1초(0~999): " + cal.get(Calendar.MILLISECOND));
// 천분의 1초를 시간으로 표시하기 위해 3600000으로 나누었다.(1시간 = 60 * 60초)
System.out.println("TimeZone(-12~+12): " + 
(cal.get(Calendar.ZONE_OFFSET)/(60*60*1000))); 
// 이 달의 마지막 일을 찾는다.
System.out.println("이 달의 마지막 날: " + cal.getActualMaximum(Calendar.DATE) ); 
%>

<%=cal.get(Calendar.YEAR) %>년
<%=cal.get(Calendar.MONTH)+1 %>월
<%=cal.get(Calendar.DAY_OF_MONTH) %>일
<%=yoil[cal.get(Calendar.DAY_OF_WEEK)-1] %>요일
<%=cal.get(Calendar.HOUR_OF_DAY) %>시
<%=cal.get(Calendar.MINUTE) %>분
<%=cal.get(Calendar.SECOND) %>초
</body>
</html>
















