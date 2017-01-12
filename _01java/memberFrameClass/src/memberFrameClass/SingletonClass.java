package memberFrameClass;

import memberFrameDAO.BbsDAO;
import memberFrameDAO.memberDAO;
import memberFrameDTO.BbsDTO;
import memberFrameDTO.memberDTO;

public class SingletonClass {

	private static SingletonClass single = null; // static 변수 : 공동 변수  클래스가 여러개라 하더라도 한 저장공간에서 사용
	public memberDAO memDao = new memberDAO();
	public memberDTO loginMem = new memberDTO();
	public BbsDAO bbsDao = new BbsDAO();
	public BbsDTO selBbs = new BbsDTO();
	
	private SingletonClass() {
		
	}
	public static SingletonClass getInstance(){
		if(single == null){
			single = new SingletonClass();
		}
		return single;
	}
}
