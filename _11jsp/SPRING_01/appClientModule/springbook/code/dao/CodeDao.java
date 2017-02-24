package springbook.code.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import springbook.code.doamin.CodeM;

public abstract class CodeDao {
	public void add(CodeM codeM) 
			throws ClassNotFoundException,SQLException
	{	
		Connection conn= this.getConnection();
		 StringBuilder sql = new StringBuilder();
		 
		sql.append(" INSERT INTO CODE_M(             \n");
		sql.append("			CD_ID                \n");
		sql.append("			,CD_NM               \n");
		sql.append("			,REG_ID              \n");
		sql.append("			,REG_DT              \n");
		sql.append("			,MOD_ID              \n");
		sql.append("			,MOD_DT              \n");
		sql.append(")VALUES(?,?,?,SYSDATE,?,SYSDATE)  \n");
		PreparedStatement psmt = null;
		psmt = conn.prepareStatement(sql.toString());

		psmt.setInt(1, codeM.getCd_id());
		psmt.setString(2, codeM.getCd_nm());
		psmt.setString(3, codeM.getReg_id());
		psmt.setString(4, codeM.getMod_id());

		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
	}
	
	public CodeM get(String code_id) 
			throws ClassNotFoundException,SQLException
	{
		Connection conn= this.getConnection();
		
		 StringBuilder sql = new StringBuilder();
		 
		 sql.append(" select        \n");
		 sql.append(" CD_ID         \n");
		 sql.append(" ,CD_NM      \n");
		 sql.append(" ,REG_ID       \n");
		 sql.append(" ,to_char(REG_DT, 'YYYY/MM/DD') as REG_DT       \n");
		 sql.append(" ,MOD_ID       \n");
		 sql.append(" ,to_char(MOD_DT, 'YYYY/MM/DD') as MOD_DT     \n");
		 sql.append(" from CODE_M  \n");
		 sql.append(" where CD_ID=? \n");
		 
		PreparedStatement psmt = null;
		ResultSet rs = null;
		psmt = conn.prepareStatement(sql.toString());

		CodeM codeM = null;
		psmt.setString(1, code_id);

		rs = psmt.executeQuery();
		
		if(rs.next())
		{
			codeM= new CodeM();
			codeM.setCd_id(rs.getInt(1));
			codeM.setCd_nm(rs.getString("CD_NM"));
			codeM.setReg_id(rs.getString("REG_ID"));
			codeM.setReg_dt(rs.getString("REG_DT"));
			codeM.setMod_id(rs.getString("MOD_ID"));
			codeM.setMod_dt(rs.getString("MOD_DT"));
		}
		
		rs.close();
		psmt.close();
		conn.close();
		
		return codeM;
	}
	
	public abstract Connection getConnection()throws ClassNotFoundException,SQLException;
//	public Connection getConnection()throws ClassNotFoundException,SQLException{
//		Connection conn = null;
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "hr";
//		String password = "hr";	
//		
//		conn = DriverManager.getConnection(url, user, password);
//		
//		return conn;
//	}
}


































