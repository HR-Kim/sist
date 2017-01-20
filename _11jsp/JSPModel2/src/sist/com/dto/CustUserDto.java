package sist.com.dto;

import java.io.Serializable;
/*
create table CUSTUSER(
		id varchar2(50)primary key,
		name varchar2(50) not null,
		address varchar2(200) not null
		
	);
*/
public class CustUserDto implements Serializable {
	private static final long serialVersionUID = 7234918514076607317L;
	
	private String id;
	private String name;
	private String address;
	
	public CustUserDto() {}

	
	
	public CustUserDto(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "CustUserDto [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
}
