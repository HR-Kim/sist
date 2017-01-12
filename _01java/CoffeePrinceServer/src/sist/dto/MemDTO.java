package sist.dto;

import java.io.Serializable;

public class MemDTO implements Serializable {
	private String id;
	private String pw;
	private String name;
	private int age;
	private int auth;
	private boolean isConnect;
	
	
	public MemDTO() {}
	
	

	public MemDTO(String id, String pw, String name, int age, int auth) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.auth = auth;
	}
	

	public boolean isConnect() {
		return isConnect;
	}



	public void setConnect(boolean isConnect) {
		this.isConnect = isConnect;
	}



	public int getAuth() {
		return auth;
	}



	public void setAuth(int auth) {
		this.auth = auth;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return id + "-" + pw + "-" + name + "-" + age + "-" + auth + "-"
				+ isConnect;
	}		
	
}
