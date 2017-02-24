package springbook.code.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springbook.code.doamin.CodeM;

public class CodeDao {
	
	private ConnectionMaker connectionMaker;
	
	private CodeDao() {}
	
	public CodeDao(ConnectionMaker connectionMaker){
		this.connectionMaker = connectionMaker;
	}
	
	public void add(CodeM codeM) throws ClassNotFoundException, SQLException 
	{
		Connection conn = connectionMaker.makeConnection();
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO CODE_M(                  \n");
		sql.append("	CD_ID,                  	     \n");
		sql.append("	CD_NM,              	         \n");
		sql.append("	REG_ID,         	             \n");
		sql.append("	REG_DT,     	                 \n");
		sql.append("	MOD_ID, 	                     \n");
		sql.append("	MOD_DT 	                    	 \n");
		sql.append(")VALUES(?, ?, ?, ?, ?, ?)\n");
		
		PreparedStatement psmt = null;
		psmt = conn.prepareStatement(sql.toString());
		
		psmt.setInt(1, codeM.getCd_id());
		psmt.setString(2, codeM.getCd_nm());
		psmt.setString(3, codeM.getReg_id());
		psmt.setString(4, codeM.getReg_dt());
		psmt.setString(5, codeM.getMod_id());
		psmt.setString(6, codeM.getMod_dt());
		psmt.executeUpdate();
		
		psmt.close();
		conn.close();
	}
	
	public CodeM get(String code_id) throws ClassNotFoundException, SQLException 
	{
		Connection conn = connectionMaker.makeConnection();
		
//		Connection conn = null;
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";/*jdbc:oracle:thin:@localhost:1521:xe*/
//		String user = "hr";
//		String password = "hr";
//		
//		conn = DriverManager.getConnection(url, user, password);
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT         	\n");
		sql.append("	CD_ID, 		\n");
		sql.append("	CD_NM, 		\n");
		sql.append("	REG_ID,		\n");
		sql.append("	REG_DT,		\n");
		sql.append("	MOD_ID,		\n");
		sql.append("	MOD_DT 		\n");
		sql.append("FROM CODE_M    	\n");
		sql.append("WHERE CD_ID=?  	\n");
		
		PreparedStatement psmt = null;
		psmt = conn.prepareStatement(sql.toString());
		
		psmt.setInt(1, Integer.parseInt(code_id));
		
		ResultSet rs = null;
		rs = psmt.executeQuery();
		
		CodeM codeM = null;
		
		while(rs.next()){
			codeM = new CodeM();
			codeM.setCd_id(rs.getInt("CD_ID"));
			codeM.setCd_nm(rs.getString("CD_NM" ));
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
	
	
}


































