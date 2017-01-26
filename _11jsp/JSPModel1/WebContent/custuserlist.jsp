<%@page import="sist.com.CustUserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function deleteChecks(e) {
	var x = document.getElementsByName("delck");
	var len = x.length;
	for(i = 0; i<len; i++){
		x[i].checked = e;
	}
}
</script>

</body>

<div align="center">
<form action="custusercontrol.jsp" method="post">
	<input type="hidden" name="command" value="muldel">
	
	<table style="width: 700;"cellpadding="0" cellspacing="0">
	<col width="100"><col width="300"><col width="300">
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>
	<tr bgcolor="#f6f6f6">
		<td bgcolor="yellow" align="center">
			<input type="checkbox" name="alldel"
				onclick="deleteChecks(this.checked)">
		</td>
		<td>아이디</td>
		<td>이름</td>
	</tr>
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>
	<%--
	List<CustUserDto> custlist = (List<CustUserDto>)request.getAttribute("custs");
	--%>
	
	<c:set var="custlist" value="${requestScope.custs }"></c:set>
	
	<%--
	if(custlist.size() == 0){
	--%>
	<c:if test="${empty custlist}">
	<tr bgcolor="#f6f6e6">
		<td colspan="3" align="center">고객 목록이 존재하지 않습니다.</td>
	</tr>
	</c:if>
	<c:if test="${not empty custlist}">
		<c:forEach var='cust' items="${custlist }">
			<tr bgcolor="#f6f6d6">
			<td align="center" bgcolor="yellow">
				<input type="checkbox" name="delck" value="${cust.id }">
			</td>
			<td>
				<%--=cust.getId() --%>
				${cust.id }
			</td>
			<td>
				<a href="custusercontrol.jsp?command=detail&id=${cust.id }">
					<%--=cust.getName() --%>
					${cust.name }
				</a>
			</td>
		</tr>
		<tr>
			<td height="2" bgcolor="#0000ff" colspan="3"></td>
		</tr>
		</c:forEach>
	</c:if>
	<%--
	}else{
		for(CustUserDto cust:custlist){
	--%>
			
	<%--
		}
	}
	--%>
	
	<tr>
		<td align="center" height="1" bgcolor="#c0c0c0" colspan="3">
			<input type="submit" value="고객정보 삭제">
		</td>
	</tr>
	<tr>
		<td height="2" bgcolor="#0000ff" colspan="3"></td>
	</tr>
	<tr bgcolor="#f6f6d6">
		<td align="center"  colspan="3">
			<c:url value="custaddform.jsp" var="custadd"></c:url>
			<a href="${custadd }">고객 추가하기</a>
			<!-- <a href="custaddform.jsp">고객추가하기</a> -->
		</td>
	</tr>
	</table>
</form>
<br>
<c:url value="index.jsp" var="home"></c:url>
			<a href="${home }">Home</a>
<!-- <a href="index.jsp">Home</a> -->
</div>

</html>












