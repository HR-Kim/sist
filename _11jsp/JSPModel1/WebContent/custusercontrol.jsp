<%@page import="com.sun.org.apache.bcel.internal.generic.CPInstruction"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="sist.com.CustUserManager"%>
<%@page import="java.util.List" %>
<%@page import="sist.com.CustUserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
request.setCharacterEncoding("UTF-8");
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
boolean isNull(String str){
	return str == null || str.trim().equals("");
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>control</title>
</head>
<body>
<%
String command = request.getParameter("command");

CustUserManager manager = new CustUserManager();
if(command.equalsIgnoreCase("list")){
	// cust db 모두 출력
	System.out.println("controller list");
	
	///////////////////////model
	// list 취득
	List<CustUserDto> custs = manager.getCustUserList();
	// list 보내준다
	request.setAttribute("custs", custs);
	//////////////////////
	// view go
	pageContext.forward("custuserlist.jsp");
	
}else if(command.equalsIgnoreCase("add")){
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	
	if(isNull(id) || isNull(name) || isNull(address)){
		System.out.println("모든정보를 입력해야 합니다.");
	}
	
	// model 이동
	//CustUserDto cust = new CustUserDto(id, name, address);
	int count = manager.addCustUser(id, name, address);
	if(count == 0){
		System.out.println("추가하지 못했습니다.");
	}
	// 다시 controller list 이동
	pageContext.forward("custusercontrol.jsp?command=list");
	
}else if(command.equalsIgnoreCase("detail")){
	String id = request.getParameter("id");
	
	//model 이동 -> data취득
	CustUserDto custdto = manager.getCustUser(id);
	//송신
	request.setAttribute("cust", custdto);
	pageContext.forward("custuserdetail.jsp");
}else if(command.equalsIgnoreCase("delete")){
	String id = request.getParameter("id");
	
	// model 이동 -> data 삭제
	int count = manager.deleteCustUser(id);
	if(count == 0){
		System.out.println("고객정보 삭제 실패하였습니다");
	}
	// list
	pageContext.forward("custusercontrol.jsp?command=list");
}else if(command.equalsIgnoreCase("update")){
	String id = request.getParameter("id");
	
	//model 이동 -> data취득
	CustUserDto custdto = manager.getCustUser(id);
	request.setAttribute("cust", custdto);
	
	pageContext.forward("custuserupdate.jsp");
}else if(command.equalsIgnoreCase("updatemodel")){
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	
	if(isNull(id)||isNull(name)||isNull(address)){
		System.out.println("모든 정보를 입력하셔야 합니다.");
		pageContext.forward("custusercontrol.jsp?command=update");
	}else{
		int count = manager.updateCustUser(id, name, address);
		if(count == 0){
			pageContext.forward("custusercontrol.jsp?command=update");	
		}else{
			pageContext.forward("custusercontrol.jsp?command=detail&id="+id.trim());	
		}
		
	}
	
	// model -> DB의 데이터를 변경!
	
	// list로 이동
	
	
}else if(command.equalsIgnoreCase("muldel")){
	String ids[] = request.getParameterValues("delck");
	
	/* for(int i=0; i< ids.length; i++){
		System.out.println("ids[" + i + "] = " + ids[i]);
	} */
	
	//model로 취득한 id꾸러미를 들고 갔다 온다
	boolean isS = manager.deleteCustUser(ids);
	
	if(!isS){
		System.out.println("정상적으로 작동하지 못했습니다.");
	}
	pageContext.forward("custusercontrol.jsp?command=list");
}
/*
A.equals("a") -> false
A.equalsIgnoreCase("a") -> true
*/

%>
</body>
</html>