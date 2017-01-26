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
	
	public int addCustUser(CustUserDto uDto){
		System.out.println("----------------7");
		return manager.addCustUser(uDto);
	}
	
	public CustUserDto getCustUser(String id) {
		return manager.getCustUser(id);
	}
	
	public int deleteCustUser(String id){
		return manager.deleteCustUser(id);
	}
	
	public int updateCustUser(String id, String name, String address){
		return manager.updateCustUser(id, name, address);
	}
	
	public boolean deleteCustUser(String[] ids){
		return manager.deleteCustUser(ids);
	}
}

































