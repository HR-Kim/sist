package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sist.dto.BoardDTO;
import com.sist.dto.MemberDTO;

public class BoardDAO {
	private static BoardDAO bdao = null;
	public List<BoardDTO> list = null;
	public BoardDTO selBoard = null;
	
	private BoardDAO() {
		list = new ArrayList<BoardDTO>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection makeConnection() throws SQLException{
		Connection conn = null;
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@211.238.142.199:1521:xe", "hr", "hr");
		System.out.println("DB Connection Success!!");
		
		return conn;
	}
	
	private void close(Statement stmt, Connection conn, ResultSet rs){
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
	
	public static BoardDAO getInstance(){
		if(bdao == null){
			bdao = new BoardDAO();
		}
		return bdao;
	}

	public boolean write(BoardDTO dto) {
		list = loadAll();
		int seq;
		boolean suc;
		int count = 0;
		
		if(list.size() == 0){
			seq = 0;
		}else{
			seq = list.get(list.size()-1).getSeq();
		}
		
		String sql = "insert into boarddto \n"
				+ "values(?, ?, ?, ?, sysdate, 0)\n";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			conn = makeConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, seq+1);
			pstm.setString(2, dto.getId());
			pstm.setString(3, dto.getTitle());
			pstm.setString(4, dto.getContent());
			
			count = pstm.executeUpdate();
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			this.close(pstm, conn, rs);
		}
		
		if(count > 0){
			suc = true;
		}else{
			suc = false;
		}
		return suc;
	}
	
	public List<BoardDTO> loadAll(){
		String sql = "select * \n"
				+ "from BOARDDTO \n";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = makeConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			list.removeAll(list);
			while(rs.next()){
				BoardDTO d = new BoardDTO();
				d.setSeq(rs.getInt("seq"));
				d.setId(rs.getString("id"));
				d.setTitle(rs.getString("title"));
				d.setContent(rs.getString("content"));
				d.setWdate(rs.getString("wdate"));
				d.setReadcount(rs.getInt("readcount"));
				list.add(d);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			this.close(stmt, conn, rs);
		}
		return list;
	}
	
	public boolean update(BoardDTO dto){
		String sql = "update boarddto set title = ?, content = ?\n"
				+ "where seq = ?";

		int count = 0;
		boolean suc = false;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try{
			conn = makeConnection();
			System.out.println("2/6 add addMember");
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, selBoard.getSeq());
			
			selBoard.setTitle(dto.getTitle());
			selBoard.setContent(dto.getContent());
			
			
			System.out.println("3/6 add addMember");
			count = psmt.executeUpdate();
			System.out.println("4/6 add addMember");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			this.close(psmt, conn, rs);
			System.out.println("6/6 add addMember");
		}
		if(count > 0){
			suc = true;
		}else{
			suc = false;
		}
		return suc;
	}

	public boolean updateReadCount(){
		String sql = "update boarddto set readcount = ? \n"
				+ "where seq = ?";

		int count = 0;
		boolean suc = false;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try{
			conn = makeConnection();
			System.out.println("2/6 add addMember");
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, selBoard.getReadcount());
			psmt.setInt(2, selBoard.getSeq());
			System.out.println("3/6 add addMember");
			count = psmt.executeUpdate();
			
			System.out.println("4/6 add addMember");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			this.close(psmt, conn, rs);
			System.out.println("6/6 add addMember");
		}
		if(count > 0){
			suc = true;
		}else{
			suc = false;
		}
		return suc;
	}

	public boolean deleteBbs() {
		String sql = "delete member \n"
				+ "where seq = ?";
		int count = 0;
		boolean suc = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			conn = makeConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, selBoard.getSeq());
			
			count = pstm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			this.close(pstm, conn, rs);
		}
		if(count >0){
			suc = true;
			selBoard = null;
		}else{
			suc = false;
		}
		return suc;
	}
}









