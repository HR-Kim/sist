package com.sist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BbsAccess implements IBbsAccess {
	private boolean isS = true;
	private static BbsAccess bbsAccess;
	
	private BbsAccess() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			log("1/6 Success");
		}catch(ClassNotFoundException e){
			log("1/6 Fail", e);
		}
	}
	
	public static BbsAccess getInstance(){
		if(bbsAccess == null){
			bbsAccess = new BbsAccess();
		}
		return bbsAccess;
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
	
	
	
	@Override
	public List<Bbs> getBbsList() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, PARENT, DEL, READCOUNT "
				+ " FROM BBS "
				+ " ORDER BY REF DESC, STEP ASC ";	//DESC : 역순, ASC : 정순
		
		List<Bbs> list = new ArrayList<Bbs>();
		
		try{
			conn = getConnection();
			log("2/6 Success getBbsList");
			
			psmt = conn.prepareStatement(sql);
			log("3/6 Success getBbsList");
			
			rs = psmt.executeQuery();
			log("4/6 Success getBbsList");
			
			while(rs.next()){
				int i = 1;
				Bbs bbs = new Bbs(rs.getInt(i++),	//seq
								rs.getString(i++),	//id
								rs.getInt(i++),
								rs.getInt(i++),
								rs.getInt(i++),
								rs.getString(i++),
								rs.getString(i++),
								rs.getString(i++),
								rs.getInt(i++),
								rs.getInt(i++),
								rs.getInt(i++));	//readcount
				list.add(bbs);
			}
			log("5/6 Success getBbsList");
		}catch(SQLException e){
			log("Fail getBbsList", e);
		}finally {
			close(conn, psmt, rs);
			log("6/6 Success getBbsList");
		}
		return list;
	}

	@Override
	public boolean writeBbs(Bbs bbs) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = " INSERT INTO BBS "
				+ " (SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, PARENT, DEL, READCOUNT) "
				+ " VALUES(SEQ_BBS.NEXTVAL, ?, "
				+ " (SELECT NVL(MAX(REF),0)+1 FROM BBS), "
				+ " 0, 0, ?, ?, SYSDATE, 0, 0, 0)";
		
		int count = 0;
		
		try{
			conn = getConnection();
			log("2/6 Success writeBbs");
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, bbs.getId());
			psmt.setString(2, bbs.getTitle());
			psmt.setString(3, bbs.getContent());
			
			log("3/6 Success writeBbs");
			
			count = psmt.executeUpdate();
			log("4/6 Success writeBbs");
			
		}catch(SQLException e){
			log("Fail writeBbs", e);
		}finally {
			close(conn, psmt);
			log("5/6 Success writeBbs");
			
		}
		return count>0 ? true : false;
	}

	@Override
	public Bbs getBbs(int seq) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "SELECT ID, TITLE, CONTENT, WDATE, READCOUNT, SEQ, REF, STEP, DEPTH, PARENT, DEL "
				+ "FROM BBS "
				+ "WHERE SEQ=?";
		
		Bbs bbs = null;	
		try{
			conn = getConnection();
			log("2/6 Success getBbs");
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, seq);
			log("3/6 Success getBbs");
			
			rs = psmt.executeQuery();
			log("4/6 Success getBbs");
			
			while(rs.next()){
				bbs = new Bbs();
				bbs.setId(rs.getString(1));
				bbs.setTitle(rs.getString(2));
				bbs.setContent(rs.getString(3));
				bbs.setWdate(rs.getString(4));
				addReadCount(seq, rs.getInt(5));
				bbs.setReadcount(rs.getInt(5)+1);
				bbs.setSeq(rs.getInt(6));
				bbs.setRef(rs.getInt(7));
				bbs.setStep(rs.getInt(8));
				bbs.setDepth(rs.getInt(9));
				bbs.setParent(rs.getInt(10));
				bbs.setDel(rs.getInt(11));
				
			}
			
			log("5/6 Success getBbs");
		}catch(SQLException e){
			log("Fail getBbs", e);
		}finally {
			close(conn, psmt, rs);
			log("6/6 Success getBbs");
		}
		
		return bbs;
	}

	@Override
	public boolean addReadCount(int seq, int readcount) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		readcount++;
		
		String sql = " UPDATE BBS "
				+ " SET READCOUNT=? "
				+ " WHERE SEQ=? ";
		
		int count = 0;
		try{
			conn = getConnection();
			log("2/6 Success addReadCount");
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, readcount);
			psmt.setInt(2, seq);
			
			log("3/6 Success addReadCount");
			
			count = psmt.executeUpdate();
			log("4/6 Success addReadCount");
			
		}catch(SQLException e){
			log("Fail addReadCount", e);
		}finally {
			close(conn, psmt);
			log("5/6 Success addReadCount");
			
		}
		return count>0 ? true : false;
				
	}

	@Override
	public boolean answer(int seq, Bbs bbs) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		//한칸씩 밀기위해서
		String sql1 = " UPDATE BBS SET "
				+ " STEP=STEP+1 "
				+ " WHERE REF=(SELECT REF FROM BBS WHERE SEQ=? ) "	//1.같은 GROUP 번호일 때
				+ " AND STEP > (SELECT STEP FROM BBS WHERE SEQ=?)";	//2.같은 GROUP안에서 스텝이 더큰애들 밑으로 내리기
		
		String sql2 = " INSERT INTO BBS "
				+ " (SEQ, ID, REF, STEP, DEPTH, "
				+ " TITLE, CONTENT, WDATE, PARENT, DEL, READCOUNT) "
				+ " VALUES(SEQ_BBS.NEXTVAL, ?,"
				+ " (SELECT REF FROM BBS WHERE SEQ=?), "
				+ " (SELECT STEP FROM BBS WHERE SEQ=?)+1, "
				+ " (SELECT DEPTH FROM BBS WHERE SEQ=?)+1, "
				+ " ?, ?, SYSDATE, ?, 0, 0)";
		
		int count = 0;
		
		try{
			conn = getConnection();
			conn.setAutoCommit(false); //데이터베이스가 중간에 꺼졋을때 무결성 제약조건을 지켜주기위해 오토커밋을 끈다
			log("2/6 Success answer");
			
			psmt = conn.prepareStatement(sql1);
			
			psmt.setInt(1, seq);
			psmt.setInt(2, seq);
			log("3/6 Success answer");
			
			count = psmt.executeUpdate();
			psmt.clearParameters();
			
			psmt = conn.prepareStatement(sql2);
			
			psmt.setString(1, bbs.getId());
			psmt.setInt(2, seq);
			psmt.setInt(3, seq);
			psmt.setInt(4, seq);
			psmt.setString(5, bbs.getTitle());
			psmt.setString(6, bbs.getContent());
			psmt.setInt(7, seq);
			log("4/6 Success answer");
			
			count = psmt.executeUpdate();
			
			log("5/6 Success answer");
			conn.commit();
			log("6/6 Success answer");
		}catch(SQLException e){
			log("Fail answer", e);
			try{
				conn.rollback();
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}finally {
			try{
				conn.setAutoCommit(true);
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			close(conn, psmt);
			log("5/6 Success answer");
			
		}
		return count>0 ? true : false;
	}
	
	
	
}



















