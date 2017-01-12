package memberClass;

import java.io.Serializable;

public class memberDTO implements Serializable {
	private int seqNum;
	private String id;
	private String pw;
	private String name;
	private String email;
	private int auth;	// 1 == 일반회원 	3 == 관리자
	
	public memberDTO() {}

	public memberDTO(int seqNum, String id, String pw, String name, String email, int auth) {
		super();
		this.seqNum = seqNum;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.auth = auth;
	}

	public int getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
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
		return "memberDTO [seqNum=" + seqNum + ", id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email
				+ ", auth=" + auth + "]";
	}
	
	
	
}
