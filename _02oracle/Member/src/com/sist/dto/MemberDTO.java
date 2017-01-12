package com.sist.dto;

import java.io.Serializable;

public class MemberDTO implements Serializable {
	private String id;
	private String name;
	private String pw;
	private String email;
	private int auth;
	
	public MemberDTO() {}

	public MemberDTO(String id, String name, String pw, String email, int auth) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.email = email;
		this.auth = auth;
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

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
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
		return "MemberDTO [id=" + id + ", name=" + name + ", pw=" + pw + ", email=" + email + ", auth=" + auth + "]";
	}

}
