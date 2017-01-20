<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 내용 : 세션을 사용
// 세션 : 변수의 취득
String userName = (String)session.getAttribute("name");
// 표시할 메시지
String message = "";
if(userName == null){
	//session이 없을 때
	message = "이름을 입력하십시오.<br>"
		+ "<form action=\"sam02.jsp\">"
		+ "<input type=\"text\" name=\"name\" size=16>"
		+ "<input type=\"submit\" value=\"OK\">"
		+ "</form>";
}else{
	message = "환영<b>" + userName + "</b>씨.<br><br>"
			+ "<a href=\"sam03.jsp\">세션을 종료</a>";
}
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션사용하기</title>
</head>
<body>
<p>세션 변수 취득</p>
   <p><%=message %></p>
   <p>(sessionID = <%=session.getId() %>)
</body>
</html>