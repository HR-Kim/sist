package springbook.code.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class JdbcContext {
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	protected void executeSQL(String sql)throws ClassNotFoundException,SQLException{
		workWithStatementStrategy(new StatementStrategy(){
			@Override
			public PreparedStatement makePreparedStatement(Connection c)throws ClassNotFoundException, SQLException {
				return c.prepareStatement(sql);
			}
		});
	}

	public void workWithStatementStrategy(StatementStrategy sst)
			throws ClassNotFoundException,SQLException{
		Connection conn = dataSource.getConnection();
		PreparedStatement psmt = null;
		try{
			psmt = sst.makePreparedStatement(conn);
			psmt.executeUpdate();
		}catch(SQLException e){
			throw e;
		}finally{
			if(null!=psmt){	try{psmt.close();}catch(SQLException sql){throw sql;}}
			if(null!=conn){	try{conn.close();}catch(SQLException sql){throw sql;}}
		}
	}
}
