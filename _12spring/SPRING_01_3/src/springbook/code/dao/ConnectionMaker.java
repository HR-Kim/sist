package springbook.code.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public interface ConnectionMaker {
	public Connection makeConnection() throws ClassNotFoundException, SQLException;
	
}
