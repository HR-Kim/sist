package springbook.code.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EmptyStackException;

import javax.sql.DataSource;

import springbook.code.doamin.CodeM;

public class CodeDao {
	
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setdataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private CodeDao() {}
	
	public CodeDao(DataSource dataSource){
		super();
		this.dataSource = dataSource;
	}
	
	
	public int selectAll()throws ClassNotFoundException, SQLException{
		int flag = 0;
		Connection conn = dataSource.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		StatementStrategy ss = new StatementStrategy(){
			@Override
			public PreparedStatement makePreparedStatement(Connection c)throws ClassNotFoundException, SQLException {
				PreparedStatement psmt = null;
				psmt = c.prepareStatement("SELECT count(*)cnt FROM CODE_M ");
				
				return psmt;
			}
		};
		try{

		psmt = ss.makePreparedStatement(conn);
		
		
		rs = psmt.executeQuery();
		
		
		if(rs.next()){
			flag = rs.getInt("cnt");
		}
		}catch(SQLException e){
			throw e;
		}finally{
			if(null!=rs){
				try{
					rs.close();
				}catch(SQLException sql){
					throw sql;
				}
			}
			if(null!=psmt){
				try{
					psmt.close();
				}catch(SQLException sql){
					throw sql;
				}
			}
			if(null!=conn){
				try{
					conn.close();
				}catch(SQLException sql){
					throw sql;
				}
			}
		}
		
		return flag;
	}
	
	public void deleteAll()throws ClassNotFoundException, SQLException{
		Connection conn = dataSource.getConnection();
		PreparedStatement psmt = null;
		
		try{
		StringBuilder sql = new StringBuilder();
		
		sql.append("DELETE FROM CODE_M \n");
				
		
		
		psmt = conn.prepareStatement(sql.toString());
		psmt.executeUpdate();
		}catch(SQLException e){
			throw e;
		}finally{
			if(null!=psmt){
				try{
					psmt.close();
				}catch(SQLException sql){
					throw sql;
				}
			}
			if(null!=conn){
				try{
					conn.close();
				}catch(SQLException sql){
					throw sql;
				}
			}
		}
	}
	
	public void add(CodeM codeM) throws ClassNotFoundException, SQLException 
	{
		Connection conn = dataSource.getConnection();
		PreparedStatement psmt = null;
		StatementStrategy ss = new StatementStrategy(){
			@Override
			public PreparedStatement makePreparedStatement(Connection c) throws ClassNotFoundException, SQLException {
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
				psmt = c.prepareStatement(sql.toString());    	   
					   
				psmt.setInt(1, codeM.getCd_id());
				psmt.setString(2, codeM.getCd_nm());
				psmt.setString(3, codeM.getReg_id());
				psmt.setString(4, codeM.getReg_dt());
				psmt.setString(5, codeM.getMod_id());
				psmt.setString(6, codeM.getMod_dt());
				psmt.executeUpdate();	  		
				
				return psmt;
			}
		};
			
		
		
		try{
			psmt = ss.makePreparedStatement(conn);
		
		}catch(SQLException e){
			throw e;
		}finally{
			if(null!=psmt){
				try{
					psmt.close();
				}catch(SQLException sql){
					throw sql;
				}
			}
			if(null!=conn){
				try{
					conn.close();
				}catch(SQLException sql){
					throw sql;
				}
			}
		}
	}
	
	public CodeM get(String code_id) throws ClassNotFoundException, SQLException 
	{
		Connection conn = dataSource.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		CodeM codeM = null;
		
		try{
		StringBuilder sql = new StringBuilder();
		
		 sql.append(" select        \n");
		 sql.append(" CD_ID         \n");
		 sql.append(" ,CD_NM      \n");
		 sql.append(" ,REG_ID       \n");
		 sql.append(" ,to_char(REG_DT, 'YYYYMMDD') as REG_DT       \n");
		 sql.append(" ,MOD_ID       \n");
		 sql.append(" ,to_char(MOD_DT, 'YYYYMMDD') as MOD_DT     \n");
		 sql.append(" from CODE_M  \n");
		 sql.append(" where CD_ID=? \n");
		
		
		psmt = conn.prepareStatement(sql.toString());
		
		psmt.setInt(1, Integer.parseInt(code_id));
		
		
		rs = psmt.executeQuery();
		
		
		
		while(rs.next()){
			codeM = new CodeM();
			codeM.setCd_id(rs.getInt("CD_ID"));
			codeM.setCd_nm(rs.getString("CD_NM" ));
			codeM.setReg_id(rs.getString("REG_ID"));
			codeM.setReg_dt(rs.getString("REG_DT"));
			codeM.setMod_id(rs.getString("MOD_ID"));
			codeM.setMod_dt(rs.getString("MOD_DT"));
		}
		}catch(SQLException e){
			throw e;
		}finally{
			if(null!=rs){
				try{
					rs.close();
				}catch(SQLException sql){
					throw sql;
				}
			}
			if(null!=psmt){
				try{
					psmt.close();
				}catch(SQLException sql){
					throw sql;
				}
			}
			if(null!=conn){
				try{
					conn.close();
				}catch(SQLException sql){
					throw sql;
				}
			}
		}
		
		if(codeM==null)throw new EmptyStackException();
		
		return codeM;
	}
}


































