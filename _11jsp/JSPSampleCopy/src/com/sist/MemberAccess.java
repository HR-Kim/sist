package com.sist;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberAccess implements IMemberAccess{
	private static MemberAccess memberAccess;
	private boolean isS = true;
	
	private MemberAccess() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			log("1/6 Success");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			log("1/6 Fail", e);
		}
		
	}
	
	public void log(String msg){
		if(isS){
			System.out.println(getClass() + ": " + msg);
		}
	}
	
	public void log(String msg, Exception e){
		if(isS){
			System.out.println(e + " : " + getClass() + " : " + msg);
		}
	}
	
	public static MemberAccess getInstance(){
		if(memberAccess == null){
			memberAccess = new MemberAccess();
		}
		return memberAccess;
	}
	
	public Connection getConnection(){
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		try{
			conn = DriverManager.getConnection(url, user, password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void close(Connection conn, Statement stmt, ResultSet rs){
		if(rs != null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(conn != null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void close(Connection conn, Statement stmt){
		if(stmt != null){
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(conn != null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean addMember(Member member) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = " INSERT INTO MEMBERCOPY "
				+ " (ID, PWD, NAME, EMAIL, AUTH) "
				+ " VALUES(?, ?, ?, ?, 3) ";
		int count = 0;
		
		try{
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPwd());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getEmail());
			
			count = psmt.executeUpdate();
			
		}catch(SQLException e){
			log("add 실패", e);
		}finally {
			close(conn, psmt);

		}
		return count > 0 ? true : false;
	}

	@Override
	public Member login(Member member) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ID, NAME, EMAIL, AUTH "
				+ " FROM MEMBERCOPY "
				+ " WHERE ID=? AND PWD=? ";
		
		Member loginMember = null;
		try{
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPwd());
			
			rs = psmt.executeQuery();
			
			while(rs.next()){
				String id = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				int auth = rs.getInt(4);
				
				loginMember = new Member(id, null, name, email, auth);
			}
			
		}catch(SQLException e){
			log("Fail login", e);
		}finally {
			close(conn, psmt, rs);

		}
		return loginMember;
	}
	
	
}

















