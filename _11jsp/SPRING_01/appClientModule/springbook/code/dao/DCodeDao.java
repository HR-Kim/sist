package springbook.code.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DCodeDao extends CodeDaoMysql {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver"); 
		String url = "jdbc:mysql://localhost:3306/sist_git";        // 사용하려는 데이터베이스명을 포함한 URL 기술
		String user = "root";                                                    // 사용자 계정
		String password = "1234";                                                // 사용자 계정의 패스워드
		
		conn = DriverManager.getConnection(url, user, password);
			
		return conn;
	}

}
