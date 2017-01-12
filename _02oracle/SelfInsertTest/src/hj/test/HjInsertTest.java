package hj.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hj.test.dto.HjDto;

public class HjInsertTest {
	public HjInsertTest() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("드라이버 로딩중");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			System.out.println("DB 연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public HjDto search(String id){
		HjDto dto = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = makeConnection();
		
		String sql = "select id, name, age, joindate \n";
		sql += "from userdto \n";
		sql += "where id ='" + id + "'";
		
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				dto = new HjDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setDate(rs.getString("joindate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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
		return dto;
		
	}
}













