<%@page import="com.sist.MemberAccess"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String user_id = request.getParameter("id");

System.out.println("user_id = " + user_id);

MemberAccess access = MemberAccess.getInstance();
boolean flag = access.selectId(user_id);

if(flag){	// 이미 존재하는 ID
	out.print("NO");
}else{	// 존재하지 않는 ID
	out.print("YES");
}
%>












