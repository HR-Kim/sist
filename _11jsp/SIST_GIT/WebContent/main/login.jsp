<%
/*------------------------------------------------------------
 * 페이지명:	login.jsp
 * 설      명:	로그인_페이지
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
    <form method=post action="login_cont.jsp">
    <table id="table_content" width=200>
     <tr>
      <td width=20% align=right>ID</td>
      <td width=80% align=left>
       <input type=text name=id size=12>
      </td>
     </tr>
     <tr>
      <td width=20% align=right>PW</td>
      <td width=80% align=left>
       <input type=password name=pwd size=12>
      </td>
     </tr>
     <tr>
      <td colspan="2" align=right>
       <input type=submit value=로그인>
      </td>
     </tr>
    </table>
    </form>
   </center>
</body>
</html>