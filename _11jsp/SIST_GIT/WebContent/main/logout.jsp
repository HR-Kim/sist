<%
/*------------------------------------------------------------
 * 페이지명:	logout.jsp
 * 설      명:	로그아웃_페이지
 * Table:   
 * 작성자 :	다현아빠
 * 버    전:	0.1
 *-----------------------------------------------------------*/
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>:::Login:::</title>
</head>
<body>
   <center>
   <form method=post action="logout_cont.jsp">
    <table id="table_content" width=200>
     <tr>
      <td align=left><%=session.getAttribute("name") %>님</td>
     </tr>
     <tr>
      <td align=left>로그인되었습니다!!</td>
     </tr>
     <tr>
      <td align=right>
       <input type=submit value=로그아웃>
      </td>
     </tr>
    </table>
    </form>
   </center>
</body>
</html>