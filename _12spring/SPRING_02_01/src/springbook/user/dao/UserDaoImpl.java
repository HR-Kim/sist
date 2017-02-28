package springbook.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springbook.user.domain.Level;
import springbook.user.domain.User;

public class UserDaoImpl implements UserDao {
	private JdbcTemplate jdbcTemplate;
	private RowMapper<User> rowMapper = new RowMapper<User>() {
		public User mapRow(ResultSet rs, int rowNum)throws SQLException{
			User user = new User();
			user.setId(rs.getString("ID"));
			user.setName(rs.getString("name"));
			user.setLevel(Level.valueOf(rs.getInt("LVL")));
			user.setLogin(rs.getInt("LOGIN"));
			user.setRecommend(rs.getInt("RECOMMEND"));
			
			return user;
		}
	}; 
	
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	

	@Override
	public void add(User user) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT        \n");
		sb.append("INTO MEMBERS  \n");
		sb.append("  (           \n");
		sb.append("    ID,       \n");
		sb.append("    NAME,     \n");
		sb.append("    PASSWORD, \n");
		sb.append("    LVL,      \n");
		sb.append("    LOGIN,    \n");
		sb.append("    RECOMMEND \n");
		sb.append("  )           \n");
		sb.append("  VALUES      \n");
		sb.append("  (           \n");
		sb.append("    ?,        \n");
		sb.append("    ?,        \n");
		sb.append("    ?,        \n");
		sb.append("    ?,        \n");
		sb.append("    ?,        \n");
		sb.append("    ?         \n");
		sb.append("  )           \n");
		
		this.jdbcTemplate.update(sb.toString() 
				,user.getId()
				,user.getName()
				,user.getPassword()
				,user.getLevel().intValue()
				,user.getLogin()
				,user.getRecommend());
	}

	@Override
	public User get(String id) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ID,     \n");
		sb.append("	NAME,         \n");
		sb.append("	PASSWORD,     \n");
		sb.append("	LVL,          \n");
		sb.append("	LOGIN,        \n");
		sb.append("	RECOMMEND     \n");
		sb.append("FROM MEMBERS   \n");
		sb.append("WHERE ID=?     \n");
		
		return this.jdbcTemplate.queryForObject(sb.toString(), new Object[]{id}, rowMapper);
	}

	@Override
	public List<User> getAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ID,     \n");
		sb.append("	NAME,         \n");
		sb.append("	PASSWORD,     \n");
		sb.append("	LVL,          \n");
		sb.append("	LOGIN,        \n");
		sb.append("	RECOMMEND     \n");
		sb.append("FROM MEMBERS   \n");
		
		return this.jdbcTemplate.query(sb.toString(), rowMapper);
	}

	@Override
	public void deleteAll() {
		this.jdbcTemplate.update("DELETE FROM MEMBERS");
	}

	@Override
	public int getCount() {
		StringBuilder sb = new StringBuilder();
		sb.append("select count(*) \n");
		sb.append("from members    \n");
		
		return jdbcTemplate.queryForInt(sb.toString());
	}

}
