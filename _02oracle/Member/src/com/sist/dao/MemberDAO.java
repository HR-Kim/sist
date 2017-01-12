package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sist.dto.MemberDTO;

public class MemberDAO {
	private static MemberDAO dao = null;
	public List<MemberDTO> list = null;
	public MemberDTO loginMem = null;
	
	private MemberDAO() {
		list = new ArrayList<MemberDTO>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection makeConnection() throws SQLException{
		Connection conn = null;
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@211.238.142.199:1521:xe", "hr", "hr");
		System.out.println("DB Connection Success!!");
		
		return conn;
	}
	
	public void close(Statement stmt, Connection conn, ResultSet rs){
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
	
	public static MemberDAO getInstance(){
		if(dao == null){
			dao = new MemberDAO();
		}
		return dao;
	}
	
	public boolean addMember(MemberDTO dto){
		
		String sql = " insert into member "
				+ " (id, name, pw, email, auth)"
				+ " values(?, ?, ?, ?, 3) ";
		
		int count = 0;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = makeConnection();
			
			System.out.println("2/6 add addMember");
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getPw());
			psmt.setString(4, dto.getEmail());
			
			System.out.println("3/6 add addMember");
			
			count = psmt.executeUpdate();
			
			System.out.println("4/6 add addMember");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			this.close(psmt, conn, rs);
			System.out.println("6/6 add addMember");
		}
		return count > 0?true:false;
	}
	
	public boolean checkId(String id){
		boolean chId = true;
		String sql = "Select id \n"
				+ "from MEMBER\n";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = makeConnection();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			list.removeAll(list);
			while(rs.next()){
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			this.close(stmt, conn, rs);
		}
		
		for(MemberDTO d : list){
			if(id.equals(d.getId())){
				chId = false;
				break;
			}	
		}
		return chId;
	}
	
	public boolean checkEmail(String email){
		boolean chMail = true;
		String sql = "Select email \n"
				+ "from MEMBER\n";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = makeConnection();
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			list.removeAll(list);
			while(rs.next()){
				MemberDTO dto = new MemberDTO();
				dto.setEmail(rs.getString("email"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			this.close(stmt, conn, rs);
		}
		
		for(MemberDTO d : list){
			if(email.equals(d.getEmail())){
				chMail = false;
				break;
			}	
		}
		return chMail;
	}
	
	private List<MemberDTO> loadAll(){
		String sql = "select * \n"
				+ "from MEMBER \n";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = makeConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			list.removeAll(list);
			while(rs.next()){
				MemberDTO d = new MemberDTO();
				d.setId(rs.getString("id"));
				d.setPw(rs.getString("pw"));
				d.setName(rs.getString("name"));
				d.setAuth(rs.getInt("auth"));
				list.add(d);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			this.close(stmt, conn, rs);
		}
		return list;
	}
	
	public MemberDTO login(MemberDTO dto){
		
		list = loadAll();
		
		if(list.size() == 0){
			System.out.println("아이디가 존재하지 않습니다.");
			return null;
		}
		for(MemberDTO d : list){
			if(dto.getId().equals(d.getId())){
				if(dto.getPw().equals(d.getPw())){
					return d;
				}else{
					System.out.println("비밀번호가 틀렸습니다.");
					return null;
				}
			}
		}
			System.out.println("아이디가 존재하지않습니다.");
		return null;
	}
	
	public boolean update(MemberDTO dto){
		String sql = "update member set name = ?, email = ? \n"
						+ "where id = ?";
		
		int count = 0;
		boolean suc = false;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try{
			conn = makeConnection();
			System.out.println("2/6 add addMember");
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getEmail());
			psmt.setString(3, dto.getId());
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
			loginMem = dto;
		}else{
			suc = false;
		}
		return suc;
	}
	
	public boolean delete(){
		String sql = "delete member \n"
				+ "where id = ?";
		int count = 0;
		boolean suc = false;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			conn = makeConnection();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, loginMem.getId());
			
			count = pstm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			this.close(pstm, conn, rs);
		}
		if(count >0){
			suc = true;
			loginMem = null;
		}else{
			suc = false;
		}
		return suc;
	}
	
	public boolean updatePw(String id, String pw){
		String sql = "update member set pw = ? \n"
				+ "where id = ?";

		int count = 0;
		boolean suc = false;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try{
			conn = makeConnection();
			System.out.println("2/6 add addMember");
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, pw);
			psmt.setString(2, id);
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
			loginMem.setPw(pw);
		}else{
			suc = false;
		}
		return suc;
	}
}


































