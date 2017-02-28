package springbook.code.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EmptyStackException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import springbook.code.doamin.CodeM;


public class CodeDaoImpl implements Code {
	private JdbcTemplate jdbcTemplate;
	private RowMapper<CodeM> codeMapper = new RowMapper<CodeM>(){
		public CodeM mapRow(ResultSet rs, int rowNum)throws SQLException{
			CodeM codeM = new CodeM();
			codeM.setCd_id(rs.getInt("CD_ID"));
			codeM.setCd_nm(rs.getString("CD_NM" ));
			codeM.setReg_id(rs.getString("REG_ID"));
			codeM.setReg_dt(rs.getString("REG_DT"));
			codeM.setMod_id(rs.getString("MOD_ID"));
			codeM.setMod_dt(rs.getString("MOD_DT"));
			
			return codeM;
		}
	};

	/**
	 * 
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private CodeDaoImpl() {}
	
	public int selectAll(){
		String sql = "SELECT count(*)cnt FROM CODE_M ";
		
		return this.jdbcTemplate.queryForInt(sql.toString());
	}
	
	public void deleteAll(){
		jdbcTemplate.update("DELETE from code_m");
	}
	
	public int add(CodeM codeM)
	{
		StringBuilder sql = new StringBuilder();
		int flag = 0;
		sql.append("INSERT INTO CODE_M(                  \n");
		sql.append("	CD_ID,                  	     \n");
		sql.append("	CD_NM,              	         \n");
		sql.append("	REG_ID,         	             \n");
		sql.append("	REG_DT,     	                 \n");
		sql.append("	MOD_ID, 	                     \n");
		sql.append("	MOD_DT 	                    	 \n");
		sql.append(")VALUES(?, ?, ?, ?, ?, ?)\n");
		  try{
	            flag = this.jdbcTemplate.update(sql.toString(), 
	                  codeM.getCd_id(),
	                  codeM.getCd_nm(),
	                  codeM.getReg_id(),
	                  codeM.getReg_dt(),
	                  codeM.getMod_id(),
	                  codeM.getMod_dt());         

	         }catch(DuplicateKeyException e){
	            throw new DuplicatedIdException(e);
	           
	         }
	         catch(DataAccessException e){
	            throw new RuntimeException(e);
	         }
	      return flag;
	}
	
	public CodeM get(String code_id) 
	{
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
		 
		 return this.jdbcTemplate.queryForObject(sql.toString(), new Object[]{code_id}, 
		          codeMapper);
	}
	
	public List<CodeM> getAll() 
	{
		StringBuilder sql = new StringBuilder();

		 sql.append(" select        \n");
		 sql.append(" CD_ID         \n");
		 sql.append(" ,CD_NM      \n");
		 sql.append(" ,REG_ID       \n");
		 sql.append(" ,to_char(REG_DT, 'YYYYMMDD') as REG_DT       \n");
		 sql.append(" ,MOD_ID       \n");
		 sql.append(" ,to_char(MOD_DT, 'YYYYMMDD') as MOD_DT     \n");
		 sql.append(" from CODE_M  \n");
		 sql.append(" order by cd_id \n");
		 
		return this.jdbcTemplate.query(sql.toString(), codeMapper);
	}
	
}


































