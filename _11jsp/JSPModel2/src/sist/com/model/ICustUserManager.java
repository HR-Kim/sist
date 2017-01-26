package sist.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import sist.com.dto.CustUserDto;

public interface ICustUserManager{
	public List<CustUserDto> getCustUserList();
	public int addCustUser(CustUserDto uDto);
	public CustUserDto getCustUser(String id);
	public int deleteCustUser(String id);
	public int updateCustUser(String id, String name, String address);
	public boolean deleteCustUser(String[] ids);
}
