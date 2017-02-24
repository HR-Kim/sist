package springbook.code.dao;

import java.sql.SQLException;
import java.util.EmptyStackException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.code.doamin.CodeM;

public class CodeTest {

	@Test(expected=EmptyStackException.class)
	public void getCodeFailure() throws SQLException, ClassNotFoundException{
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		CodeDao dao = context.getBean("codeDao", CodeDao.class);
		dao.deleteAll();
		assertThat(dao.selectAll(), is(0));
		
		dao.get("1");
		
		
	}
	
	@Test
	public void allAndGet() throws SQLException, ClassNotFoundException{
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		CodeDao dao = context.getBean("codeDao", CodeDao.class);
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


































