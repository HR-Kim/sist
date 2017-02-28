

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

import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;


@RunWith(SpringJUnit4ClassRunner.class) //스프링 테스트 컨텍스트 JUnit 확장
@ContextConfiguration(locations="/applicationContext.xml")										//기능 지원
public class UserDaoTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	UserDao dao;
	
	@Autowired
	private ApplicationContext context;
	
	private User user1;
	private User user2;
	private User user3;
	
	@Before //메소드가 실행되기전에 무조건 한번 실행되는 구조다
	public void setUp(){
//		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
//		
		//dao = context.getBean("codeDao", CodeDaoImpl.class);
		user1 = new User("hanju", "배한주", "123", Level.BASIC, 1, 0);
		user2 = new User("yunhaeng", "조윤행", "123", Level.SILVER, 56, 10);
		user3 = new User("youngjae", "김영재", "123", Level.GOLD, 100, 40);
		System.out.println(dao);
		System.out.println("setUp context = " + context);
		System.out.println("setUp this = " + this);
	}
	
	
	@Test
	public void allAndGet() throws SQLException, ClassNotFoundException{
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		dao.add(user1);
		dao.add(user2);
		dao.add(user3);
		assertThat(dao.getCount(), is(3));
		User vsUser1 = dao.get(user1.getId());
		User vsUser2 = dao.get(user2.getId());
		
		checkSameCode(vsUser1, user1);
		checkSameCode(vsUser2, user2);
		//assertThat(dao.get(user1.getId()).getId(), is(user1.getId()));
		//assertThat(dao.get(user1.getId()).getName(), is(user1.getName()));
		
	}

	@Test
	public void getAll()throws SQLException, ClassNotFoundException {
		dao.deleteAll();
		dao.add(user1);
		dao.add(user2);
		dao.add(user3);
		
		List<User> list = dao.getAll();
		
		checkSameCode(list.get(0), user1);
		checkSameCode(list.get(1), user2);
		checkSameCode(list.get(2), user3);
	}
	
	private void checkSameCode(User code01, User code02){
		assertThat(code01.getId(), is(code02.getId()));
		assertThat(code01.getName(), is(code02.getName()));
	}
	
	//@Test(expected=DuplicatedIdException.class)
	public void duplicateKey()throws SQLException, ClassNotFoundException{
		
	}
	@Test
	public void exceptionTranse() throws SQLException,ClassNotFoundException{
	      
	   }
	
	@After //메소드가 끝난후 에 무조건 한번 실행되는 구조다
	public void end(){
		
		System.out.println("end");
	}
}


































