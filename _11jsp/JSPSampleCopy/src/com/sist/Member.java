package com.sist;

import java.io.Serializable;

/*create table MEMBERCOPY(
		id varchar2(50) primary key,
		pwd varchar2(50) not null,
		name varchar2(50) not null,
		email varchar2(50) unique,
		auth number(1) not null
	);*/
public class Member implements Serializable {

	private static final long serialVersionUID = 7688236391822415445L;
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private int auth;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String id, String pwd, String name, String email, int auth) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.auth = auth;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", auth=" + auth + "]";
	}
	
	
}
