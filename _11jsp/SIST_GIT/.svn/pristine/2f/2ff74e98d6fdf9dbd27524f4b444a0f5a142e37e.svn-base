<%
/*------------------------------------------------------------
 * 페이지명:	left.jsp
 * 설      명:	메뉴_페이지
 * Table:   
 * 작성자 :	다현아빠
 * 버    전:	0.1
 *-----------------------------------------------------------*/
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id=(String)session.getAttribute("id");


 %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>:::Login:::</title>
</head>
<body>
<center>
   <%
      if(id!=null)
      {
   %>
   <table  width=150>
     <tr >
      <td align=left><a href="main.jsp?cont_div=500105">홈</a></td>
     </tr>
     <tr >
      <td align=left><a href="main.jsp?cont_div=3">회원수정</a></td>
     </tr>
     <tr >
      <td align=left><a href="main.jsp?cont_div=800201">공지사항</a></td>
     </tr>
     <tr >
      <td align=left><a href="main.jsp?cont_div=1">자유게시판</a></td>
     </tr>
   </table>
   <%
      }else{
   %>
    <table  width=150>
     <tr >
      <td align=left><a href="main.jsp?cont_div=500105">홈</a></td>
     </tr>
     <tr >
      <td align=left><a href="main.jsp?cont_div=3">회원가입</a></td>
     </tr>
     <tr >
      <td align=left><a href="main.jsp?cont_div=800201">공지사항</a></td>
     </tr>
   </table>  
   <%
      }
   %>
  </center>
</body>
</html>
</body>
</html>