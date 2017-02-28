

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.code.dao.Code;
import springbook.code.dao.CodeDaoImpl;
import springbook.code.dao.DuplicatedIdException;
import springbook.code.doamin.CodeM;

@RunWith(SpringJUnit4ClassRunner.class) //스프링 테스트 컨텍스트 JUnit 확장
@ContextConfiguration(locations="/applicationContext.xml")										//기능 지원
public class CodeTestContext {
	private Code dao;
	
	@Autowired
	private DataSource dataSource;
	
	private CodeM code01;
	private CodeM code02;
	private CodeM code03;
	@Autowired
	private ApplicationContext context;
	
	@Before //메소드가 실행되기전에 무조건 한번 실행되는 구조다
	public void setUp(){
//		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
//		
		code01 = new CodeM();
		code02 = new CodeM();
		code03 = new CodeM();
		
		code01.setCd_id(1);
		code01.setCd_nm("paging");
		code01.setReg_id("admin");
		code01.setMod_id("admin");
		code01.setMod_dt("20170222");
		code01.setReg_dt("20170222");
		
		code02.setCd_id(2);
		code02.setCd_nm("paging");
		code02.setReg_id("admin");
		code02.setMod_id("admin");
		code02.setMod_dt("20170222");
		code02.setReg_dt("20170222");
		
		code03.setCd_id(3);
		code03.setCd_nm("paging");
		code03.setReg_id("admin");
		code03.setMod_id("admin");
		code03.setMod_dt("20170222");
		code03.setReg_dt("20170222");
		
		dao = context.getBean("codeDao", CodeDaoImpl.class);
		System.out.println(dao);
		System.out.println("setUp context = " + context);
		System.out.println("setUp this = " + this);
	}
	
	
	@Test
	public void allAndGet() throws SQLException, ClassNotFoundException{
		dao.deleteAll();
		
		CodeM codeM = new CodeM();
		codeM.setCd_id(99);
		codeM.setCd_nm("paging");
		codeM.setReg_id("admin");
		codeM.setMod_id("admin");
		codeM.setMod_dt("20170222");
		codeM.setReg_dt("20170222");
		
		CodeM codeM02 = new CodeM();
		codeM02.setCd_id(100);
		codeM02.setCd_nm("upload");
		codeM02.setReg_id("admin");
		codeM02.setMod_id("admin");
		codeM02.setMod_dt("20170224");
		codeM02.setReg_dt("20170224");
		
		dao.add(codeM);
		assertThat(dao.selectAll(), is(1));
		CodeM codeM2 = dao.get(codeM.getCd_id()+"");
		dao.add(codeM02);
		assertThat(dao.selectAll(), is(2));
		
		assertThat(codeM.getCd_nm(), is(codeM2.getCd_nm()));
		assertThat(codeM.getCd_id(), is(codeM2.getCd_id()));
		//assertThat(codeM.getReg_dt(), is(codeM2.getReg_dt()));
	}

	@Test
	public void getAll()throws SQLException, ClassNotFoundException {
		dao.deleteAll();
		
		dao.add(code01);
		List<CodeM> codeList = dao.getAll();
		assertThat(codeList.size(), is(1));
		checkSameCode(code01, codeList.get(0));
		
		codeList.removeAll(codeList);
		dao.add(code02);
		codeList = dao.getAll();
		assertThat(codeList.size(), is(2));
		checkSameCode(code02, codeList.get(1));
		
		codeList.removeAll(codeList);
		dao.add(code03);
		codeList = dao.getAll();
		assertThat(codeList.size(), is(3));
		checkSameCode(code03, codeList.get(2));
		
	}
	
	private void checkSameCode(CodeM code01, CodeM code02){
		assertThat(code01.getCd_id(), is(code02.getCd_id()));
		assertThat(code01.getCd_nm(), is(code02.getCd_nm()));
	}
	
	@Test(expected=DuplicatedIdException.class)
	public void duplicateKey()throws SQLException, ClassNotFoundException{
		dao.deleteAll();
		
		dao.add(code01);
		dao.add(code01);
	}
	@Test
	public void exceptionTranse() throws SQLException,ClassNotFoundException{
	      try{
	         dao.selectAll();
	         dao.add(code01);
	         dao.add(code01);
	      }catch (DuplicateKeyException e) {
	         SQLException sqlE = (SQLException)e.getRootCause();
	         SQLExceptionTranslator set = 
	               new SQLErrorCodeSQLExceptionTranslator(dataSource);
	         System.out.println(set.translate(null, null, sqlE));
	      }
	   }
	
	@After //메소드가 끝난후 에 무조건 한번 실행되는 구조다
	public void end(){
		
		System.out.println("end");
	}
}


































