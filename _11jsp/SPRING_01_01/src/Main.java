import java.sql.SQLException;

import springbook.code.dao.CodeDao;
import springbook.code.dao.ConnectionMaker;
import springbook.code.dao.NConnectionMaker;
import springbook.code.doamin.CodeM;	

public class Main {
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
		
		ConnectionMaker connectionMaker = new NConnectionMaker();
		CodeDao dao = new CodeDao(connectionMaker);
		dao.add(codeM);
		
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
	public Main() {
		super();
	}

}