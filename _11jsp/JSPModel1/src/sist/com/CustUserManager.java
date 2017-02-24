package sist.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustUserManager {
	public CustUserManager() {
		init();
		
	}
	
	private void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("1/6");
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		
		conn = DriverManager.getConnection(url, user, password);
		System.out.println("2/6");
		
		return conn;
	}
	
	private void close(Connection conn, PreparedStatement stmt, ResultSet rs){
		try{
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public List<CustUserDto> getCustUserList(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT ID, NAME, ADDRESS FROM CUSTUSER "
				+ " ORDER BY ID DESC ";
		
		List<CustUserDto> list = new ArrayList<CustUserDto>();
		try{
			conn = getConnection();
			System.out.println("2/6");
			stmt = conn.prepareStatement(sql);
			System.out.println("3/6");
			
			System.out.println("sql = " + sql);
			rs = stmt.executeQuery();
			System.out.println("4/6");
			while(rs.next()){
				CustUserDto cust = new CustUserDto();
				cust.setId(rs.getString("ID"));
				cust.setName(rs.getString("NAME"));
				cust.setAddress(rs.getString("ADDRESS"));
				list.add(cust);
			}
			System.out.println("5/6");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally {
			this.close(conn, stmt, rs);
		}
		System.out.println("6/6");
			
		return list;
	}
	
	public int addCustUser(String id, String name, String address) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		int count = 0;
		String sql = " INSERT INTO CUSTUSER VALUES(?,?,?)";
		System.out.println("sql = " + sql);
		try{
			conn = getConnection();
			System.out.println("2/6 ADD");
			stmt = conn.prepareStatement(sql);
			System.out.println("3/6 ADD");
			stmt.setString(1, id.trim());
			stmt.setString(2, name.trim());
			stmt.setString(3, address.trim());
			System.out.println("4/6 ADD");
			count = stmt.executeUpdate();
			System.out.println("5/6 ADD");
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			this.close(conn, stmt, rs);
		}
		System.out.println("6/6 ADD");
		
		return count;
	}
	
	public CustUserDto getCustUser(String id) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ID, NAME, ADDRESS "
				+ " FROM CUSTUSER"
				+ " WHERE ID=? ";
		
		CustUserDto cust = new CustUserDto();
		
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id.trim());
			
			System.out.println("sql = " + sql);
			
			rs = psmt.executeQuery();
			while(rs.next()){
				cust.setId(rs.getString("ID"));
				cust.setName(rs.getString("NAME"));
				cust.setAddress(rs.getString("ADDRESS"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(conn, psmt, rs);
		}
		return cust;
	}
	
	public int deleteCustUser(String id){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = " DELETE FROM CUSTUSER "
				+ " WHERE ID=? ";
		
		int count = 0;
		
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id.trim());
			count = psmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(conn, psmt, rs);
		}
		return count;
	}
	
	public int updateCustUser(String id, String name, String address){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "UPDATE CUSTUSER SET NAME=?, ADDRESS=? "
				+ "WHERE ID=? ";
		int count = 0;
		try{
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, name.trim());
			psmt.setString(2, address.trim());
			psmt.setString(3, id.trim());
			
			count = psmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(conn, psmt, rs);
		}
		
		return count;
	}
	
	public boolean deleteCustUser(String[] ids){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "DELETE FROM CUSTUSER "
				+ "WHERE ID=?";
		
		int count[] = new int[ids.length];
		// 값이 전부 0으로 셋팅
		
		try{
			conn = getConnection();
			System.out.println("2/6 DEL");
			conn.setAutoCommit(false);	//매우 중요!
			
			psmt = conn.prepareStatement(sql);
			System.out.println("3/6 DEL");
			for(int i = 0; i < count.length; ++i){
				psmt.setString(1, ids[i].trim());
				psmt.addBatch();	//처리할 쿼리문들을 쌓아 놓는다.
			}
			System.out.println("4/6 DEL");
			count = psmt.executeBatch();	//쿼리문을 한꺼번에 처리
			conn.commit();
			System.out.println("5/6 DEL");
		}catch(SQLException e){
			try{
				conn.rollback();
			}catch(SQLException ex){
				e.printStackTrace();
			}
		}finally {
			try{
				conn.setAutoCommit(true);
			}catch(SQLException ex1){
				
			}
			close(conn, psmt, rs);
		}
		
		boolean isS = true;
		System.out.println("6/6 DEL");
		for(int i = 0; i< count.length; i++){
			// 정상적으로 동작을 했을 경우 ==> -2
			if(count[i] != -2){
				isS = false;
				break;
			}
			
		}
		return isS;
	}
}


















