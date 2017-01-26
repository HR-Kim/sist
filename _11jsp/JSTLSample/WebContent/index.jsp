<%@page import="sist.com.MainClass"%>
<%@page import="java.util.HashMap"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<%-- java 코드를 사용하지 않기 위해 탄생되었음  --%>
<%//
//%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<script>
</script>
<style>
</style>
</head>
<body>
<pre>
<%-- Java ServerPages Tag Library --%>

<!-- c는 core tag의 약자이다  -->
<%--set은 변수에 값을 설정하는것과 동일하다 --%>
<c:set var="data" value="JSTL입니다"/>
<%--out은 out.println(data)와 동일하다 --%>
<c:out value="${data }"/>

<%
session.setAttribute("setdata", "test");
%>

<c:set var="sData" value="${sesdata }"/>
<c:out value="${sData }"/>

<br><br><br><br>

<c:set var="data1" value="테스트"></c:set>
<%-- <c:remove var="data1"/> --%>
---
<c:out value="data1"></c:out>


<%
session.setAttribute("count", "15");
%>

<c:if test="${count>=10 }"> <!-- test는 예약어라서 마음대로 바꾸면 안됨. -->
   count: <c:out value="${count }"/>
</c:if>

<% //위와 동일 
String count =(String)session.getAttribute("count");
int num = Integer.parseInt(count);

if(num>=10){
%>
   count:<%=num %>
<%
}
%>

<%
session.setAttribute("name", "Tom");
%>

<c:if test="${name eq 'Tom' }" var="flg"/>
<c:if test="${flg }">
톰
</c:if>
<c:if test="${!flg }">
톰이아님
</c:if>

<%
request.setAttribute("data2", "aaa");
%>

변수 data2가 비어 있는지?:${empty data2 }

<c:if test="${not empty data2 }">
변수 data2가 비어있지 않다. 
</c:if>

<!-- forEach == for -->
<c:forEach begin="1" end="10" step="1" varStatus="status">
index:<c:out value="${status.index }"/><br>
</c:forEach>

<%
List<MainClass> list = new ArrayList<MainClass>();
MainClass cls = new MainClass();
cls.setName("홍길동");
list.add(cls);

cls = new MainClass();
cls.setName("임꺽정");
list.add(cls);

request.setAttribute("list", list);
%>

<c:forEach var="obj" items="${list }" varStatus="status">
index:<c:out value="${status.index }"/>
이름:<c:out value="${obj.name }"></c:out><br>
</c:forEach>

<%
Map<String, String> map = new HashMap<String, String>();
map.put("key1", "아아아");
map.put("key2", "이이이");
map.put("key3", "우우우");

request.setAttribute("myMap", map);
%>

<c:forEach var="obj" items="${myMap }">
키: <c:out value="${obj.key }"/>
값: <c:out value="${obj.value }"/>
</c:forEach>

<br><br><br>

<%-- c:forTokens --%>
<c:set var="ft" value="aaa-bbb-ccc"></c:set>
<c:forTokens items="${ft }" delims="-" var="obj">
문자열:<c:out value="${obj }"/><br>
</c:forTokens>

 <%-- redirect --%>
<%-- <c:redirect url="NewFile.jsp">
	<c:param name="userId" value="1001"></c:param>
	<c:param name="userName" value="홍길동"></c:param>
</c:redirect>  --%>

<%-- include --%>
<%-- 부모 jsp파일<br>

<c:import url="NewFile1.jsp"></c:import> --%>


</pre>
</body>
</html>



