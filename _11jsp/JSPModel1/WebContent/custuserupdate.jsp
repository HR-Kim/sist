<%@page import="sist.com.CustUserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
   CustUserDto cust = (CustUserDto)request.getAttribute("cust");
--%>
<c:set var="cust" value="${requestScope.cust }"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
</head>
<body>
   <div align="center">
      <form action="custusercontrol.jsp">
         <input type="hidden" name="command" value="updatemodel">
         <table style="width: 600;" cellpadding="0" cellspacing="0">
            <col width="200"><col width="400">
            <tr>
               <td height="2" bgcolor="#0000ff" colspan="2"></td>               
            </tr>
            <tr bgcolor="#f6f6f6">
               <td>아이디</td>
               <td>
                  <input type="text" name="id" value="${cust.id }" readonly="readonly">
               </td>
            </tr>
            <tr>
               <td height="2" bgcolor="#0000ff" colspan="2"></td>
            </tr>
            <tr bgcolor="#f6f6f6">
               <td>이름</td>
               <td>
                  <input type="text" name="name" value="${cust.name }">
               </td>
            </tr>
            <tr bgcolor="#f6f6f6">
               <td>주소</td>
               <td>
                  <input type="text" name="address" value="${cust.address }">
               </td>
            </tr>
            <tr>
               <td colspan="2">
                  <input type="submit" value="변경">
               </td>
            </tr>
            <tr>
               <td height="2" bgcolor="#0000ff" colspan="2"></td>
            </tr>
         </table>
      </form>
   </div>
</body>
</html>