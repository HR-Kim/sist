package com.sist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CalAccess implements ICalAccess {
	private boolean isS = true;
	private static CalAccess calAccess;
	
	private CalAccess() {
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
	
	public static CalAccess getInstance(){
		if(calAccess == null){
			calAccess = new CalAccess();
		}
		return calAccess;
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
	public boolean addCalendar(Cal cal) {
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = "INSERT INTO CALENDAR("
				+ " SEQ, ID, TITLE, CONTENT, RDATE, WDATE)"
				+ " VALUES(SEQ_CALENDAR.NEXTVAL, "
				+ " ?, ?, ?, ?, SYSDATE)";
		
		int count = 0;
		
		try{
			conn = getConnection();
			log("2/6 Success addCalendar");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cal.getId());
			psmt.setString(2, cal.getTitle());
			psmt.setString(3, cal.getContent());
			psmt.setString(4, cal.getRdate());
			log("3/6 Success addCalendar");
			
			count = psmt.executeUpdate();
			log("4/6 Success addCalendar");
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(conn, psmt);
			log("5/6 Success addCalendar");
			log("6/6 Success addCalendar");
		}
		return count > 0 ? true : false;
	}

	@Override
	public List<Cal> calList(String id, String yyyyMM) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT SEQ, ID, TITLE, CONTENT, RDATE, WDATE "
				+ " FROM( "
				+ " SELECT ROW_NUMBER()OVER(PARTITION BY SUBSTR(RDATE, 1, 8) "
				+ " ORDER BY RDATE ASC) RN, "
				+ " SEQ, ID, TITLE, CONTENT, RDATE, WDATE "
				+ " FROM CALENDAR "
				+ " WHERE ID=? AND SUBSTR(RDATE, 1, 6)=? "
				+ " )WHERE RN BETWEEN 1 AND 5 ";
		
		List<Cal> calList = new ArrayList<Cal>();
		
		try{
			conn = getConnection();
			log("2/6 Success calList");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			psmt.setString(2, yyyyMM.trim());
			log("3/6 Success calList");
			
			rs = psmt.executeQuery();
			log("4/6 Success calList");
			
			while(rs.next()){
				Cal cal = new Cal();
				cal.setSeq(rs.getInt(1));
				cal.setId(rs.getString(2));
				cal.setTitle(rs.getString(3));
				cal.setContent(rs.getString(4));
				cal.setRdate(rs.getString(5));
				cal.setWdate(rs.getString(6));
				calList.add(cal);
				log("5/6 Success calList");
			}
		}catch(SQLException e){
			log("Fail calList");
		}finally {
			close(conn, psmt, rs);
			log("6/6 Success calList");
		}
		return calList;
	}

	@Override
	public Cal getCal(String seq) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT SEQ, ID, TITLE, CONTENT, RDATE, WDATE "
				+ " FROM CALENDAR "
				+ " WHERE SEQ=?";
		
		Cal cal = null;
		try{
			conn = getConnection();
			log("2/6 Success getCal");
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, seq);
			log("3/6 Success getCal");
			
			rs = psmt.executeQuery();
			log("4/6 Success getCal");
			cal = new Cal();
			while(rs.next()){
				cal.setSeq(rs.getInt(1));
				cal.setId(rs.getString(2));
				cal.setTitle(rs.getString(3));
				cal.setContent(rs.getString(4));
				cal.setRdate(rs.getString(5));
				cal.setWdate(rs.getString(6));
			}
			log("5/6 Success getCal");
			
		}catch(SQLException e){
			log("Fail getCal", e);
		}finally {
			close(conn, psmt, rs);
			log("6/6 Success getCal");			
		}
		return cal;
	}

	@Override
	public List<Cal> getDayList(String id, String yyyymmdd) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT SEQ, ID, TITLE, CONTENT, RDATE, WDATE "
				+ " FROM CALENDAR "
				+ " WHERE ID=? AND SUBSTR(RDATE, 1, 8)=? "
				+ " ORDER BY RDATE ";
		
		List<Cal> callist = new ArrayList<Cal>();
		
		try{
			conn = getConnection();
			log("2/6 Success getDayList");
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, yyyymmdd);
			log("3/6 Success getDayList");
			
			rs = psmt.executeQuery();
			log("4/6 Success getDayList");
			
			while(rs.next()){
				Cal cal = new Cal(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6));
				callist.add(cal);		
			}
			
		}catch(SQLException e){
			
		}finally {
			close(conn, psmt, rs);
		}
		return callist;
	}
	
	
}
















