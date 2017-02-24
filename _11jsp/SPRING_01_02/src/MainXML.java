import java.sql.SQLException;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.code.dao.CodeDao;
import springbook.code.doamin.CodeM;	

public class MainXML {
	/**
	 * 이것은 클래스입니다...
	 * @author 배한주
	 * @param CODE
	 * @return VOID
	 * 
	 * */
	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		// TODO Auto-generated method stub
		CodeM codeM = new CodeM();
		codeM.setCd_id(99);
		codeM.setCd_nm("paging");
		codeM.setReg_id("admin");
		codeM.setMod_id("admin");
		codeM.setMod_dt("20170222");
		codeM.setReg_dt("20170222");
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		CodeDao dao = context.getBean("codeDao", CodeDao.class);
		System.out.println("dao : " + dao);
		CodeDao dao1 = context.getBean("codeDao", CodeDao.class);
		System.out.println("dao1 : " + dao1);
		dao.deleteAll();
		if(dao.selectAll()==0){
			dao.add(codeM);
		}
		
		
		
		String codeId = codeM.getCd_id() + "";
		CodeM vsCodeM = dao.get(codeId);
		
		if(codeM.getCd_id() != vsCodeM.getCd_id())
			System.out.println("등록오류");
		else if(!codeM.getCd_nm().equals(vsCodeM.getCd_nm()))
			System.out.println("등록오류:코드명 오류");
		else if(!codeM.getReg_id().equals(vsCodeM.getReg_id()))
			System.out.println("등록오류:Reg_id 오류");
		else
			System.out.println("등록성공");
	}
	

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public MainXML() {
		super();
	}

}