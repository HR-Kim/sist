<%@page import="com.sist.Bbs"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.BbsAccess"%>
<%@page import="com.sist.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%!
public String arrow(int depth){
	String rs = "<img src='image/arrow.png' width='20px' height='20px'>";
	String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
	String ts = "";
	for(int i = 0; i<depth; i++){
		ts += nbsp;
	}
	return depth==0 ? "" : ts + rs;  
}
%>

<%
BbsAccess access = BbsAccess.getInstance();
List<Bbs> bbslist = access.getBbsList();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>bbslist</title>
<style type="text/css">
table{
	border-collapse:collapse;
}
table, th, td{
	border: 1px solid black;
}
th{
	background-color: green;
	color: black;
}
.tda{
      background-color: #abcdef;
      color: black;
   }
.tdb{
      background-color: #febdab;
      color: black;
 }
</style>
</head>
<%
Object ologin = session.getAttribute("login");
Member member = null;
if (ologin == null){
%>
	<script type="text/javascript">
		alert("로그인 하십시오");
		location.href = "index.jsp";
	</script>
	<%
	return;
}
member = (Member)ologin;
%>
<body>

<h3>환영합니다<%=member.getName() %>님 반갑습니다. </h3>

<a href="calendar.jsp">일정보기</a>

<a href='pdslist.jsp'>자료실</a>

<a href='logout.jsp'>로그 아웃</a>

<hr/>

<table border="1">
<col width="50"/><col width="500"/><col width="150"/>
<tr>
	<th>순서</th><th>제목</th><th>작성자</th>
</tr>
<%
if(bbslist == null || bbslist.size() == 0){
%>
	<tr>
		<td colspan="3"	>작성된 글이 없습니다.</td>
	</tr>
<%	
}
for (int i = 0; i < bbslist.size(); i++){
	Bbs bbs = bbslist.get(i);
	%>
	
	<tr <%=i%2 ==0 ? "class='tda'" : "class='tdb'" %>>
		<td><%=i+1 %></td>
		<td><%=arrow(bbs.getDepth()) %>
			<a href='bbsdetail.jsp?seq=<%=bbs.getSeq()%>'>
				<%=bbs.getTitle() %>
			</a>
		</td>
		<td><%=bbs.getId() %></td>
	</tr>
<%	
}
%>
</table>
<a href='bbswrite.jsp'>글쓰기</a>
</body>
</html>



















