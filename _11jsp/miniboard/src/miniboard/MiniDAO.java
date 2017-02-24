package miniboard;

import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MiniDAO {

	public MiniDAO() {
		init();
	}
	
	private void init(){
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
	
	private void close(Connection conn, Statement stmt, ResultSet rs){
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
	
	private void close(Connection conn, Statement stmt){
		try{
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
	/*CREATE TABLE MINI_BOARD (
	mi_id NUMBER NOT NULL,  ID 
	mi_name VARCHAR2(7) NOT NULL,  작성자 
	mi_date DATE DEFAULT sysdate NOT NULL,  작성일 
	mi_email VARCHAR2(320) NOT NULL,  E-MAIL 
	mi_passwd VARCHAR2(6) NOT NULL,  비번 
	mi_contents VARCHAR2(4000) NOT NULL,  내용 
	mi_view_yn CHAR(1) DEFAULT 'Y' NOT NULL  사용여부 
);*/
	public List<MiniBean> getList(){
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT MI_ID, MI_NAME, MI_DATE, MI_EMAIL, MI_CONTENTS, MI_PASSWD FROM MINI_BOARD "
				+ " WHERE MI_VIEW_YN='Y' "
				+ " ORDER BY MI_ID DESC";
		
		List<MiniBean> list = new ArrayList<MiniBean>();
		
		try{
			conn = getConnection();
			System.out.println("2/6");
			psmt = conn.prepareStatement(sql);
			System.out.println("3/6");
			
			System.out.println("sql = " + sql);
			rs = psmt.executeQuery();
			System.out.println("4/6");
			while(rs.next()){
				MiniBean bean = new MiniBean();
				bean.setMi_id(rs.getInt("mi_id"));
				bean.setMi_name(rs.getString("mi_name"));
				bean.setMi_date(rs.getString("mi_date"));
				bean.setMi_email(rs.getString("mi_email"));
				bean.setMi_contents(rs.getString("mi_contents"));
				bean.setMi_passwd(rs.getString("mi_passwd"));
				
				list.add(bean);
			}
			System.out.println("5/6");
			
			
		}catch(SQLException e){
			System.out.println("getList Fail");
			e.printStackTrace();
		}finally {
			close(conn, psmt, rs);
		}
		
		return list;
	}
	
	public boolean mergeDB(MiniBean bean)
    {
		Connection conn = null;
		PreparedStatement psmt = null;
    	
    	int retInt = 0;
    	try{
    		conn = this.getConnection();
    		
    		StringBuilder sql = new StringBuilder();
    		sql.append("MERGE INTO mini_board T1                       \n");
    		sql.append("USING ( SELECT ?        as mi_id               \n");
    		sql.append("               ,?       as mi_name             \n");
    		sql.append("               ,sysdate as mi_date             \n");
    		sql.append("               ,?       as mi_email            \n");
    		sql.append("               ,?       as mi_passwd           \n");
    		sql.append("               ,?       as mi_contents         \n");
    		sql.append("               ,'Y'     as mi_view_yn          \n");
    		sql.append("        FROM dual                              \n");
    		sql.append("       ) T2                                    \n");
    		sql.append("ON ( T1.mi_id = T2.mi_id)                      \n");
    		sql.append("WHEN MATCHED THEN                              \n");
    		sql.append("  UPDATE SET T1.mi_name    = T2.mi_name,       \n");
    		sql.append("            T1.mi_date     = T2.mi_date,       \n");
    		sql.append("            T1.mi_email    = T2.mi_email,      \n");
    		sql.append("            T1.mi_passwd   = T2.mi_passwd,     \n");
    		sql.append("            T1.mi_contents = T2.mi_contents,   \n");
    		sql.append("            T1.mi_view_yn  = T2.mi_view_yn     \n");
    		sql.append("WHEN NOT MATCHED THEN                          \n");
    		sql.append("INSERT (mi_id, mi_name, mi_date,mi_email,mi_passwd,mi_contents) \n");
    		sql.append("VALUES (mini_board_seq.nextval, T2.mi_name, T2.mi_date,T2.mi_email,T2.mi_passwd,T2.mi_contents)\n");    		
    		
    		
    		psmt = conn.prepareStatement(sql.toString());
    		System.out.println("1 pstmt"+psmt.toString());  
    		System.out.println("2 sql="+sql.toString());
    		psmt.setInt(1, bean.getMi_id());
    		psmt.setString(2, bean.getMi_name());
    		psmt.setString(3, bean.getMi_email());
    		psmt.setString(4, bean.getMi_passwd());
    		psmt.setString(5, bean.getMi_contents());
    		
    		System.out.println("3 toString="+bean.toString());  
    		retInt = psmt.executeUpdate();
    		
    		System.out.println("retInt="+retInt);  
    		System.out.println("mi_name="+bean.getMi_name());  
    		System.out.println("mi_email="+bean.getMi_email());  
    		System.out.println("mi_passwd="+bean.getMi_passwd());  
    		System.out.println("mib_contents="+bean.getMi_contents());      		
    		
    	}catch(Exception e){
    		return false;
    	}finally{
    		this.close(conn, psmt);
    	}
    	
    	return true; 
    }    
    
    
    /**
     * ���
     * @return boolean
     */
    public boolean insertClobDB(MiniBean bean)
    {
    	Connection conn = null;
		PreparedStatement psmt = null;
    	
		
    	int retInt = 0;
    	//
    	try{
    		conn = getConnection();
    		StringBuilder sql = new StringBuilder();
    		sql.append("INSERT INTO MINI_BOARD (mi_id                \n");
    		sql.append("                      ,mi_name               \n");
    		sql.append("                      ,mi_email              \n");
    		sql.append("                      ,mi_passwd             \n");
    		sql.append("                      ,mi_contents           \n");
    		sql.append("                      ,mi_date               \n");
    		sql.append("                      ,mi_view_yn)           \n");    		
    		sql.append("                VALUES(mini_board_seq.nextval \n");
    		sql.append("                      ,?                     \n");
    		sql.append("                      ,?                     \n");
    		sql.append("                      ,?                     \n");
    		sql.append("                      ,?                     \n");
    		sql.append("                      ,sysdate               \n");
    		sql.append("                      ,'Y'                   \n");
    		sql.append("                      )                      \n");
    		psmt = conn.prepareStatement(sql.toString());
    		System.out.println("1 pstmt"+psmt.toString());  
    		System.out.println("2 sql="+sql.toString());  
    		psmt.setString(1, bean.getMi_name());
    		psmt.setString(2, bean.getMi_email());
    		psmt.setString(3, bean.getMi_passwd());
    		
    		Clob clobCon = conn.createClob();
    		clobCon.setString(1, bean.getMi_contents());
    		
    		psmt.setClob(4, clobCon);
    		System.out.println("3 toString="+bean.toString());  
    		retInt = psmt.executeUpdate();    		
    		System.out.println("retInt="+retInt);  
    		System.out.println("mi_name="+bean.getMi_name());  
    		System.out.println("mi_email="+bean.getMi_email());  
    		System.out.println("mi_passwd="+bean.getMi_passwd());  
    		System.out.println("mib_contents="+bean.getMi_contents());      		
    		
    	}catch(Exception e){
    		return false;
    	}finally{
    		this.close(conn, psmt);
    	}
    	
    	return true; 
    }
	
	public boolean editForm(MiniBean dto){
		Connection conn = null;
		PreparedStatement psmt = null;
	
		String sql = "UPDATE MINI_BOARD SET MI_DATE=SYSDATE, MI_EMAIL=?, MI_PASSWD=?, MI_CONTENTS=? "
				+ "WHERE MI_ID=? ";
		int count = 0;
		try{
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getMi_email().trim());
			psmt.setString(2, dto.getMi_passwd().trim());
			psmt.setString(3, dto.getMi_contents().trim());
			psmt.setInt(4, dto.getMi_id());
			
			count = psmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(conn, psmt);
		}
		
		return count > 0 ? true : false;
	}
	
	public boolean deleteForm(int mi_id){
		Connection conn = null;
		PreparedStatement psmt = null;
		
		StringBuilder sql = new StringBuilder();       
		sql.append("UPDATE MINI_BOARD SET MI_VIEW_YN='N' \n");
		sql.append("WHERE MI_ID=? \n");
		
		int count = 0;
		try{
			conn = getConnection();
			
			psmt = conn.prepareStatement(sql.toString());
			
			psmt.setInt(1, mi_id);
			
			count = psmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(conn, psmt);
		}
		
		return count > 0 ? true : false;
	}
	
	public ArrayList<HashMap> selectDBList() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		HashMap<String, String> data = null;
		ArrayList data_list = new ArrayList();

		try{
			conn = getConnection();
			StringBuilder sql = new StringBuilder();
    		sql.append("SELECT mi_id	       \n");
    		sql.append("      ,mi_name	       \n");                    
    		sql.append("      ,mi_email	       \n");
    		sql.append("      ,mi_passwd	   \n");
    		sql.append("      ,mi_passwd       \n");
    		sql.append("      ,mi_contents	   \n");
    		sql.append("      ,mi_date	       \n");
    		sql.append("  FROM  MINI_BOARD     \n");
    		sql.append("  WHERE mi_view_yn ='Y' \n");
    		sql.append(" ORDER BY mi_date DESC  \n");
    		
    		psmt = conn.prepareStatement(sql.toString());
    		System.out.println("sql="+sql.toString());
			rs = psmt.executeQuery();

			while(rs.next()) {
				data = new HashMap();
				data.put("mi_id",rs.getString("mi_id"));
				data.put("mi_name", rs.getString("mi_name"));
				data.put("mi_email", rs.getString("mi_email"));
				data.put("mi_passwd", rs.getString("mi_passwd"));
				data.put("mi_contents", rs.getString("mi_contents"));
				data.put("mi_date", rs.getString("mi_date"));
				data_list.add(data);
			}
		}
		catch(Exception e) {
			System.out.println("selectDBList() : "+e);
		}
		finally {
			this.close(conn, psmt, rs);
		}
		return data_list;
	}
}
















