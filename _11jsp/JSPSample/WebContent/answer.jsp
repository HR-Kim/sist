<%@page import="com.sist.BbsAccess"%>
<%@page import="com.sist.Bbs"%>
<%@page import="com.sist.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.center{
	margin: auto;
	width: 60%;
	border: 3px solid #8Ac007;
	padding: 10px;
}
input{
	size:50;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String seqStr = request.getParameter("seq");
	int seq = Integer.parseInt(seqStr);
	
	BbsAccess access = BbsAccess.getInstance();
	Bbs bbs = null;
	bbs = access.getBbs(seq);
%>
<a href='logout.jsp'>로그아웃</a>

<h1>상세글보기</h1>

<div class="center">

<table border="1">
<col width="200"><col width="500">
	<tr>
		<td>제목</td>
		<td><input type="text" value="<%=bbs.getTitle() %>" readonly="readonly"></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type="text" value="<%=bbs.getId() %>" readonly="readonly"></td>
	</tr>
	<tr>
		<td>작성일</td>
		<td><input type="text" value="<%=bbs.getWdate() %>" readonly="readonly"></td>
	</tr>
	<tr>
		<td>조회수</td>
		<td><input type="text" value="<%=bbs.getReadcount() %>" readonly="readonly"></td>
	</tr>
	tr>
		<td>정보</td>
		<td><input type="text" value="<%=bbs.getRef() %> - <%=bbs.getDepth() %> - <%=bbs.getStep() %>" readonly="readonly"></td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
		<textarea rows="10" cols="50" readonly="readonly"><%=bbs.getContent() %></textarea>
		</td>
	</tr>
</table>

<hr/>
<%
Object ologin = session.getAttribute("login");
Member member = null;
member = (Member)ologin;
%>
<h1>답글달기</h1>

<form action="answerAf.jsp" method="post">
<input type="hidden" name="seq" value="<%=bbs.getSeq()%>">

<table border="1">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="id" size="50" value="<%=member.getId()%>" readonly="readonly">
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>
			<input type="text" name="title" size="50">
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea rows="10" cols="50" name="content"></textarea>>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="답글">
		</td>
	</tr>
</table>
</form>

<a href='bbslist.jsp'>글목록</a>
</body>
</html>


















