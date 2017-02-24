package springbook.code.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NCodeDao extends CodeDao {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
			Connection conn = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";	
			
			conn = DriverManager.getConnection(url, user, password);
			
			return conn;
	}

}
