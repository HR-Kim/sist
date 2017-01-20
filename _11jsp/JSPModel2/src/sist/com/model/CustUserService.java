package sist.com.model;

import java.util.List;

import sist.com.dto.CustUserDto;

public class CustUserService {
	private static CustUserService custUserService;
	private ICustUserManager manager;
	
	private CustUserService(){
		System.out.println("----------------4");
		manager = new CustUserManager();
	}
	public static CustUserService getInstance() {
		System.out.println("----------------3");
		if(custUserService == null){
			custUserService = new CustUserService();
		}
		return custUserService;
	}
	
	public List<CustUserDto> getCustUserList(){
		System.out.println("----------------7");
		return manager.getCustUserList();
	}
	
	public int addCustUser(String id, String name, String address){
		System.out.println("----------------7");
		return manager.addCustUser(id, name, address);
	}
	
	public CustUserDto getCustUser(String id) {
		return manager.getCustUser(id);
	}
}

































