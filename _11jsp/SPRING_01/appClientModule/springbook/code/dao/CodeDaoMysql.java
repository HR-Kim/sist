package springbook.code.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import springbook.code.doamin.CodeM;

public abstract class CodeDaoMysql {
	public void add(CodeM codeM) 
			throws ClassNotFoundException,SQLException
	{
		Connection conn = null;
		conn = this.getConnection();
		
		
		 StringBuilder sql = new StringBuilder();
		 
		sql.append(" INSERT INTO CODE_M(             \n");
		sql.append("			CD_ID                \n");
		sql.append("			,CD_NM               \n");
		sql.append("			,REG_ID              \n");
		sql.append("			,REG_DT              \n");
		sql.append("			,MOD_ID              \n");
		sql.append("			,MOD_DT              \n");
		sql.append(")VALUES(?,?,?,SYSDATE(),?,SYSDATE())  \n");
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
		Connection conn = null;
		conn = this.getConnection();
		
		 StringBuilder sql = new StringBuilder();
		 
		 sql.append(" select        \n");
		 sql.append(" CD_ID         \n");
		 sql.append(" ,CD_NM      \n");
		 sql.append(" ,REG_ID       \n");
		 sql.append(" ,DATE_FORMAT(REG_DT, '%Y-%m-%d') AS REG_DT       \n");
		 sql.append(" ,MOD_ID       \n");
		 sql.append(" ,DATE_FORMAT(MOD_DT, '%Y-%m-%d') AS MOD_DT     \n");
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
//		Class.forName("com.mysql.jdbc.Driver"); 
//		String url = "jdbc:mysql://localhost:3306/sist_git";        // 사용하려는 데이터베이스명을 포함한 URL 기술
//		String user = "root";                                                    // 사용자 계정
//		String password = "1234";                                                // 사용자 계정의 패스워드
//	
//		
//		conn = DriverManager.getConnection(url, user, password);
//	}
}





















