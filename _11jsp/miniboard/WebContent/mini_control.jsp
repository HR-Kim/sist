<%@page import="miniboard.MiniBean"%>
<%@page import="java.util.List"%>
<%@page import="miniboard.MiniDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command = request.getParameter("command");
	
	MiniDAO dao = new MiniDAO();
	if(command.equals("list")){
		List<MiniBean> list = dao.getList();
		
		request.setAttribute("list", list);
		
		pageContext.forward("mini_list.jsp");
	}else if(command.equals("add")){
		String mi_name = request.getParameter("mi_name");
		String mi_date = request.getParameter("mi_date");
		String mi_email = request.getParameter("mi_email");
		String mi_passwd = request.getParameter("mi_passwd");
		String mi_contents = request.getParameter("mi_contents");
		
		MiniBean dto = new MiniBean(mi_name, mi_date, mi_email, mi_passwd, mi_contents);
		
		if(dao.addForm(dto)){
			System.out.println("추가성공!");
		}else{
			System.out.println("추가실패...");
		}
		pageContext.forward("mini_control.jsp?command=list");
	}else if(command.equals("edit")){
		String mi_name = request.getParameter("mi_name");
		String mi_date = request.getParameter("mi_date");
		String mi_email = request.getParameter("mi_email");
		String mi_passwd = request.getParameter("mi_passwd");
		String mi_contents = request.getParameter("mi_contents");
		int mi_id = Integer.parseInt(request.getParameter("mi_id"));
		
		MiniBean dto = new MiniBean(mi_name, mi_date, mi_email, mi_passwd, mi_contents);
		
		dto.setMi_id(mi_id);
		if(dao.editForm(dto)){
			System.out.println("edit성공!");
		}else{
			System.out.println("edit실패...");
		}
		pageContext.forward("mini_control.jsp?command=list");
	}else if(command.equals("delete")){
		int mi_id = Integer.parseInt(request.getParameter("mi_id"));
		
		if(dao.deleteForm(mi_id)){
			System.out.println("delete성공!");
		}else{
			System.out.println("delete실패...");
		}
		pageContext.forward("mini_control.jsp?command=list");
	}
%>
</body>
</html>









