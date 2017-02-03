<%@page import="com.sist.Pds"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.PdsAccess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
PdsAccess access = PdsAccess.getInstance();

List<Pds> list = access.getPdss();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pdslist</title>
</head>
<body>
<table border="1"> 
<col width="50"><col width="100"><col width="400">
<col width="50"><col width="50"><col width="50">
<col width="100">

<tr bgcolor="#09bbaa" align="center">
	<td>번호</td>
	<td>작성자</td>
	<td>제목</td>
	<td>다운로드</td>
	<td>조회수</td>
	<td>다운수</td>
	<td>작성일</td>
</tr>
<%
for(int i=0; i<list.size(); ++i){
	Pds pds = list.get(i);
	String bgcolor = "";
	if(i%2 == 0){
		bgcolor = "#ddeebb";
	}else{
		bgcolor = "#ddddcc";
	}
	%>
	<tr bgcolor="<%=bgcolor%>" align="center" height="5">
	<td><%=i+1 %></td>
	<td><%=pds.getId() %></td>
	<td align="left">
		<a href="pdsdetail.jsp?pdsid=<%=pds.getId()%>">
			<%=pds.getTitle() %>
		</a>
	</td>
	<td>
	<input type="button" name="btnDownload" value="파일" 
	onclick="javascript:document.location.href='../filedown?filename=<%=pds.getFilename()%>&pdsid=<%=pds.getSeq()%>'">
	<%=pds.getFilename() %>
	</td>
	
	<td><%=pds.getReadcount() %></td>
	<td><%=pds.getDowncount() %></td>
	<td><%=pds.getRegdate() %></td>
	</tr>
<%		
}
%>

</table>

<a href="pdswrite.jsp">자료 올리기</a>
<a href="bbslist.jsp">HOME</a>
</body>
</html>







