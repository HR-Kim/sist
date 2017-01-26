package com.sist;

import java.io.Serializable;


/*create table MEMBER(
		id varchar2(50) primary key,
		name varchar2(50) not null,
		pwd varchar2(50) not null,
		email varchar2(50) unique,
		auth number(1) not null
	);*/
public class Member implements Serializable {

	private static final long serialVersionUID = -1584313014581280902L;
	
	private String id;
	private String name;
	private String pwd;
	private String email;
	private int auth;
	
	public Member() {}
	
	public Member(String id, String name, String pwd, String email, int auth) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.auth = auth;
	}
	
	

	public Member(String name, String pwd, String email) {
		this(null, name, pwd, email, 3);
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}
	
	

}
