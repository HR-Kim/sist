package com.sist;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberAccess implements IMemberAccess {
	private boolean isS = true;
	private static MemberAccess memberAccess;
	
	public MemberAccess() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			log("1/6 Success");
		}catch(ClassNotFoundException e){
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
	
	public Connection getConnection() throws SQLException{
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		
		conn = DriverManager.getConnection(url, user, password);
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
		String sql = " INSERT INTO MEMBER "
				+ " (ID, NAME, PWD, EMAIL, AUTH) "
				+ " VALUES(?, ?, ?, ?, 3) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		try{
			conn = getConnection();
			log("2/6 Success addMember");
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getPwd());
			psmt.setString(4, member.getEmail());
			log("3/6 Success addMember");
			
			count = psmt.executeUpdate();
			log("4/6 Success addMember");
			
		}catch(SQLException e){
			log("Fail addMember", e);
		}finally {
			this.close(conn, psmt);
			log("5/6 Success addMember");
		}
		
		
		return count > 0 ? true : false;
	}
	@Override
	public Member login(Member member) {
		
		String sql = " SELECT ID, NAME, EMAIL, AUTH "
				+ "FROM MEMBER "
				+ " WHERE ID=? AND PWD=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		Member loginMember = null;
		
		try{
			conn = getConnection();
			
			log("2/6 Success login");
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPwd());
			
			log("3/6 Success addMember");
			
			rs = psmt.executeQuery();
			log("4/6 Success addMember");
			while (rs.next()){
				String id = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				int auth = rs.getInt(4);
				
				loginMember = new Member(id, name, null, email, auth);
			}
			log("5/6 Success addMember");
		}catch (SQLException e){
			log("Fail login", e);
		}finally {
			this.close(conn, psmt, rs);
			log("6/6 Success addMember");
		}
		
		return loginMember;
	}
	@Override
	public boolean selectId(String id) {
		
		String sql = " SELECT ID FROM MEMBER "
				+ " WHERE ID=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String findId = null;
		
		try{
			conn = getConnection();
			
			log("2/6 Success selectId");
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id.trim());
			
			log("3/6 Success addMember");
			
			rs = psmt.executeQuery();
			log("4/6 Success selectId");
			while (rs.next()){
				findId = rs.getString(1);
				
				
			}
			log("5/6 Success selectId");
		}catch (SQLException e){
			log("Fail selectId", e);
		}finally {
			this.close(conn, psmt, rs);
			log("6/6 Success selectId");
		}
		
		if (findId == null || findId.equals("")){
			return false;
		}
		
		return true;
	}
	
	
}





















