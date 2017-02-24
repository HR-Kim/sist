package springbook.code.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springbook.code.doamin.CodeM;

@RunWith(SpringJUnit4ClassRunner.class) //스프링 테스트 컨텍스트 JUnit 확장
@ContextConfiguration(locations="/applicationContext.xml")										//기능 지원
public class CodeTestContext {
	private CodeDao dao;
	@Autowired
	private ApplicationContext context;
	
	@Before //메소드가 실행되기전에 무조건 한번 실행되는 구조다
	public void setUp(){
//		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
//		
		dao = context.getBean("codeDao", CodeDao.class);
		System.out.println(dao);
		System.out.println("setUp context = " + context);
		System.out.println("setUp this = " + this);
	}
	@After //메소드가 끝난후 에 무조건 한번 실행되는 구조다
	public void end(){
		
		System.out.println("end");
	}
	@Test(expected=EmptyStackException.class)
	public void getCodeFailure() throws SQLException, ClassNotFoundException{
		
		dao.deleteAll();
		assertThat(dao.selectAll(), is(0));
		
		dao.get("1");
		
		
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

}


































