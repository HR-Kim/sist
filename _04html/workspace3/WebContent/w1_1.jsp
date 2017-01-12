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
	String name = request.getParameter("name");
	String engTalk = request.getParameter("englishTalk");
	String[] language = request.getParameterValues("language");
	String opinion = request.getParameter("msg");
	String age = request.getParameter("age");
%>
<h1>설문조사결과</h1>
당신의 이름은 : <%=name %>
<br>
당신은 영어로 대화할 수 있습니까? : <%=engTalk %>
<br>
당신이 영어외에 관심있는 언어는? : <%if(request.getParameter("language")==null){
	out.print("없음");
	}else{
		for(int i=0;i<language.length;i++){
	out.print(" ");
%>
<%=language[i]%>
<%
	if(i != language.length-1)
	out.print(",");
%>
<%}}%>
<br>
영어수업에 대한 의견은? : <%=opinion %>
<br>
당신의 연령대는 : <%=age %>

</body>
</html>