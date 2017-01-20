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

<h1>HR Tab</h1>

<pre>	<!-- p tag 단락 -->
SELECT * FROM TAB
모든 테이블의 목록을 뿌려준다
</pre>

<%!	// 선언부는 한번만 실행된다.
public boolean has$(String msg){
	// contains == 지정된 문자열("$")이 포함되었는지 검사합니다
	// $가 포함되어 있는 테이블을 링크하지 않기 위해서
	return msg.contains("$");
}
%>

<%
//JDBC 부분
Class.forName("oracle.jdbc.driver.OracleDriver"); //클래스가 있느냐 없느냐 확인하는 함수

System.out.println("1/6");
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "hr";
String password = "hr";

Connection conn = DriverManager.getConnection(url, user, password);

System.out.println("2/6");

String sql = " SELECT * FROM TAB";
PreparedStatement psmt = conn.prepareStatement(sql);

System.out.println("3/6");

ResultSet rs = psmt.executeQuery();

System.out.println("4/6");
ResultSetMetaData rsmd = rs.getMetaData(); //컬럼 정보 * 일반 정보
int count = rsmd.getColumnCount(); //컬럼갯수
%>

<table border="1">
<tr>
	<%
	for(int i=1; i< count + 1; ++i){
	%>
	<td><%=rsmd.getColumnClassName(i) %></td>
	<%
	}
	%>
</tr>

<%
while(rs.next()){
%>
	<tr>
	<%
		for(int i = 1; i < count + 1; ++i){
			String cols = rs.getString(i);
			if(i == 1 && !has$(cols)){
				%>
				<td>
					<a href="table.jsp?tname=<%=cols%>"><%=cols%></a>
				</td>
			<%	
			}else{
				%>
				<td><%=rs.getString(i) %></td>
			<%
			}
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






























