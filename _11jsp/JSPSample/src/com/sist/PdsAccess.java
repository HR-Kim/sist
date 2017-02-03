package com.sist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PdsAccess implements IPdsAccess {
	private boolean isS = true;
	private static PdsAccess pdsAccess = null;
	
	private PdsAccess() {
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
	
	public static PdsAccess getInstance(){
		if(pdsAccess == null){
			pdsAccess = new PdsAccess();
		}
		return pdsAccess;
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
	public boolean writePds(Pds pds) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = " INSERT INTO PDS("
				+ " SEQ, ID, TITLE, CONTENT,FILENAME, "
				+ " READCOUNT, DOWNCOUNT, REGDATE)"
				+ " VALUES(SEQ_PDS.NEXTVAL, "
				+ " ?, ?, ?, ?, 0, 0, SYSDATE)";
		
		int count = 0;
		try{
			conn = getConnection();
			log("2/6 Success writePds");
			
			psmt=conn.prepareStatement(sql);
			psmt.setString(1,  pds.getId());
			psmt.setString(2,  pds.getTitle());
			psmt.setString(3,  pds.getContent());
			psmt.setString(4,  pds.getFilename());
			log("3/6 Success writePds");
			
			count = psmt.executeUpdate();
			log("4/6 Success writePds");
		}catch(SQLException e){
			log("Fail writePds", e);
		}finally {
			close(conn, psmt);
			log("5/6 Success writePds");
		}
		
		return count > 0 ? true : false;
	}

	@Override
	public List<Pds> getPdss() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, "
				+ " FILENAME, READCOUNT, DOWNCOUNT, REGDATE "
				+ " FROM PDS"
				+ " ORDER BY SEQ ASC ";
		
		List<Pds> list = new ArrayList<Pds>();
		
		try{
			conn = getConnection();
			log("2/6 Success getPdss");
			psmt = conn.prepareStatement(sql);
			log("3/6 Success getPdss");
			
			rs = psmt.executeQuery();
			log("4/6 Success getPdss");
			
			while(rs.next()){
				Pds pds = new Pds(
						rs.getInt(1), //seq
						rs.getString(2), //id
						rs.getString(3), //title
						rs.getString(4), //content
						rs.getString(5), //filename
						rs.getInt(6), //readcount
						rs.getInt(7), //downcount
						rs.getString(8)); //regdate
				list.add(pds);
			
			}
			log("5/6 Success getPdss");
		}catch(SQLException e){
			log("Fail getPdss", e);
		}finally {
			close(conn, psmt);
			log("6/6 Success getPdss");
		}
		
		return list;
	}
	
	
}


















