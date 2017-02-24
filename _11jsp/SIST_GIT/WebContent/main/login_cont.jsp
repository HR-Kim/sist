<%
/*------------------------------------------------------------
 * 페이지명:	login_ok.jsp
 * 설      명:	로그인_cont_페이지
 * Table:   
 * 작성자 :	다현아빠
 * 버    전:	0.1
 *-----------------------------------------------------------*/
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.khy.cmn.MemberDto"%>
<%@page import="com.khy.cmn.MemberDao"%>    
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

MemberDao dao = MemberDao.getInstance();
MemberDto mem = dao.login(new MemberDto(id, null, pwd, null, 0));

if(mem != null && !mem.getId().equals("")){

    session.setAttribute("id", mem.getId());
    session.setAttribute("name", mem.getName());
    response.sendRedirect("main.jsp");		
}else{	
%>
	<script type="text/javascript">
		alert("아이디나 패스워드를 확인하십시오");
		history.back();
	</script>	
<%
}
%>	