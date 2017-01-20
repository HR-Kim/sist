package sist.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberAccess {
	public MemberAccess() {
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

	private Connection getConnection() throws SQLException {
		Connection conn = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";

		conn = DriverManager.getConnection(url, user, password);
		System.out.println("2/6");

		return conn;
	}

	private void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Member readMember(Member member) {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM MYMEMBER WHERE ID=? AND PASSWORD=?";
		
		try {
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPassword());
			
			rs = psmt.executeQuery();
			
			if(rs.next()  && !rs.next()) {	//무조건  rs행이 하나만 존재할때 true!!
				
				member.setAddress(rs.getString("ADDRESS"));
				member.setName(rs.getString("NAME"));
				
			}else{
				member = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			member = null;	// 그냥 try/catch만 묶는다고 예외처리가 다 된 것이 아니다!
		}finally {
			this.close(conn, psmt, rs);
		}

		return member;
	}

}
