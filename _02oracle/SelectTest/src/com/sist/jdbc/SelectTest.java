package com.sist.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sist.jdbc.dto.UserDto;

public class SelectTest {
	public SelectTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@211.238.142.199:1521:xe", "hr", "hr");
			System.out.println("DB Connection Success!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public UserDto search(String id) {
		UserDto dto = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = makeConnection();
		
		String sql = "select id, name, age, joindate \n";
		sql += "from userdto \n";
		sql += "where id = '" + id + "'";
		
		try{
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql); 
			
			if(rs.next()){
				dto = new UserDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setJoinDate(rs.getString("joindate"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
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
	
	public List<UserDto> getList() {
		List<UserDto> list = new ArrayList<UserDto>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = makeConnection();
		
		String sql = "select id, name, age, joindate \n";
		sql += "from userdto \n";
		
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				UserDto dto = new UserDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setJoinDate(rs.getString("joindate"));
				
				list.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
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
		return list;
	}
}

















