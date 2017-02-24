<%@page import="miniboard.MiniBean"%>
<%@page import="java.util.List"%>
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
	List<MiniBean> list = (List<MiniBean>)request.getAttribute("list");
	if(list != null){
		for(int i = 0; i < list.size(); ++i){
		%>
			<div align="center">
			<form action="mini_edit.jsp" method="post" name="f<%=i%>">
			<input type="hidden" value="<%=list.get(i).getMi_passwd()%>" id="answer">
			<input type="hidden" value="<%=list.get(i).getMi_id()%>" name="mi_id">
			<table border="1">
			<col width="120"><col width="150"><col width="100"><col width="250">

			<tr>
				<td>작성자</td>
				<td><input type="text" name="mi_name" value="<%=list.get(i).getMi_name() %>" readonly="readonly"></td>
				<td>작성일</td>
				<td><input type="text" name="mi_date" value="<%=list.get(i).getMi_date() %>" readonly="readonly"></td>
			</tr>
			<tr>
				<td>e-mail</td>
				<td><input type="text" name="mi_email" value="<%=list.get(i).getMi_email() %>" readonly="readonly"></td>
				<td>비밀번호</td>
				<td>
					<input type="text" name="mi_passwd" id = "mi_passwd<%=i %>" style="width: 200px">
					<input type="button" value="수정" align="left" onclick="checkPw('<%=i%>')">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea rows="4" cols="100" name="mi_contents"><%=list.get(i).getMi_contents()%></textarea></td>
			</tr>
			</table>
			</form>
			</div>
			
		<%		
		}
	}else{
	%>
		<div align="center">
		<form>
		<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>작성일</td>
		</tr>
		<tr>
			<td colspan="4" align="center">작성된 글이 없습니다.</td>
		</tr>
		</table>
		</form>
		</div>
	<%	
	}
%>

<script type="text/javascript">
function checkPw(n) {
	var pw = document.getElementById("mi_passwd"+n).value;
	var answer = document.getElementById("answer").value;
	if(pw==answer){
		document.forms[n].submit();
	}else{
		alert("비밀번호가 틀렸습니다.");
	}
}
</script>

</body>
</html>
