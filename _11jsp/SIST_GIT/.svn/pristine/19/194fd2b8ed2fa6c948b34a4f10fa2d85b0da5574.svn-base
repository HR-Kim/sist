package com.khy.cmn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDao {
	private boolean isS = true;
	private static MemberDao memberDao;
	
	private MemberDao() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			log("1/6 Success");
		}catch(ClassNotFoundException e){
			log("1/6 Fail", e);
		}
	}
	
	public static MemberDao getInstance() {
		if(memberDao == null){
			memberDao = new MemberDao();
		}
		return memberDao;
	}
	
	public Connection getConnection()throws SQLException {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@211.238.142.152:1521:orcl";
		conn = DriverManager.getConnection(url, "hr", "hr");
		return conn;
	}
	
	public void close(Connection conn, Statement psmt, ResultSet rs) {
		if(rs != null){
			try{
				rs.close();
			}catch(SQLException e){}
		}
		if(psmt != null){
			try{
				psmt.close();
			}catch(SQLException e){}
		}
		if(conn != null){
			try{
				conn.close();
			}catch(SQLException e){}
		}		
	}
		

	public boolean addMember(MemberDto dto) {  
		String sql = " INSERT INTO MEMBER "
				+ "(ID, NAME, PWD, EMAIL, AUTH) "
				+ " VALUES(?,?,?,?,3) ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		try{
			conn = getConnection();
			log("2/6 Success addMember");
			psmt = conn.prepareStatement(sql);
			
			int i = 1;
			psmt.setString(i++, dto.getId());
			psmt.setString(i++, dto.getName());
			psmt.setString(i++, dto.getPwd());
			psmt.setString(i++, dto.getEmail());
			log("3/6 Success addMember");
			
			count = psmt.executeUpdate();
			log("4/6 Success addMember");
			
		}catch(SQLException e){
			log("Fail addMember", e);
		}finally{
			this.close(conn, psmt, rs);
			log("5/6 Success addMember");
		}		
		
		return count>0?true:false;
	}


	public MemberDto login(MemberDto dto) {
		
		String sql = " SELECT ID, NAME, EMAIL, AUTH "
				+ "FROM MEMBER "
				+ "WHERE ID=? AND PWD=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		MemberDto mem = null;
		
		try{
			conn = getConnection();
			log("2/6 Success login");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPwd());
			log("3/6 Success login");
			
			rs=psmt.executeQuery();
			log("4/6 Success login");
			
			while(rs.next()){
				String id = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				int auth = rs.getInt(4);
				
				mem = new MemberDto(id, name, null, email, auth);
			}
			log("5/6 Success login");
			
		}catch(SQLException e){
			log("Fail login", e);
		}finally{
			this.close(conn, psmt, rs);
			log("6/6 Success login");
		}	
		
		return mem;
	}
	

	public boolean selectedId(String id) {
		
		String sql=" SELECT ID FROM MEMBER "
				+ " WHERE ID=? ";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String findId = null;
		
		try{
			conn=this.getConnection();
			log("2/6 Success selectedId");
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			log("3/6 Success selectedId");
			
			rs=psmt.executeQuery();
			log("4/6 Success selectedId");
			
			while(rs.next()){
				findId = rs.getString(1);
			}
			log("5/6 Success selectedId");			
		}catch(SQLException e){
			log("Fail selectedId", e);	
		}finally{
			close(conn, psmt, rs);
			log("6/6 Success selectedId");	
		}
		
		if(findId == null || findId.equals("")){
			return false; // id 없다 사용가능
		}		
		
		return true;	// id 있다
	}
	
	
	
	

	public void log(String msg){
		if(isS){
			System.out.println(getClass() + ": " + msg);
		}
	}
	public void log(String msg, Exception e){
		if(isS){
			System.out.println(e + ":" + getClass() + ": " + msg);
		}
	}
	
}

