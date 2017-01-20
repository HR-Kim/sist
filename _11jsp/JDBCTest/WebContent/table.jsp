<%@ page import="java.sql.ResultSetMetaData" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HR Table</h1>

<pre>
SELECT * FROM 테이블명
</pre>
<%
//JDBC 부분
Class.forName("oracle.jdbc.driver.OracleDriver"); //클래스가 있느냐 없느냐 확인하는 함수

System.out.println("1/6");
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "hr";
String password = "hr";

Connection conn = DriverManager.getConnection(url, user, password);

System.out.println("2/6");

String tablename = request.getParameter("tname");

tablename = (tablename == null || tablename.equals("")) ? "TAB" : tablename.toUpperCase();

String sql = " SELECT * FROM " + tablename;
PreparedStatement psmt = conn.prepareStatement(sql);

System.out.println("3/6");
ResultSet rs = psmt.executeQuery();

System.out.println("4/6");

ResultSetMetaData rsmd = rs.getMetaData(); // 컬럼정보들
int count = rsmd.getColumnCount();
%>

<table border="1">
	<tr>
		<%
			for(int i = 1; i < count + 1; ++i){
			%>
				<td><%=rsmd.getColumnName(i) %></td>
			<%	
			}
		%>
	</tr>
	<%
	while(rs.next()){
	%>
		<tr>
			<%
			for(int i = 1; i < count +1; ++i){
			%>
				<td><%=rs.getString(i) %></td>
			<%	
			}
			%>
		</tr>	
	<%
	}
	%>
</table>

<%
if(rs != null){
	rs.close();
	psmt.close();
	conn.close();
}
%>

</body>
</html>



































