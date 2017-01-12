package com.sist.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBClose {
	public static void close(Statement stmt, Connection conn){
		try{
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt, Connection conn, ResultSet rs){
		try{
			if(rs != null)
				rs.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
