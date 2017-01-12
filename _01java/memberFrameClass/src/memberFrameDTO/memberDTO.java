package memberFrameDTO;

import java.io.Serializable;

public class memberDTO implements Serializable {
	private int seqNum;
	private String id;
	private String pw;
	private String name;
	private String email;
	private int auth;	// 1 == 일반회원 	3 == 관리자
	
	public memberDTO() {}

	public memberDTO(String id, String pw, String name, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
	}


	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

	public int getSeqNum() {
		return seqNum;
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


	public void setAuth(int auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return seqNum + "-" + id + "-" + pw + "-" + name + "-" + email
				+ "-" + auth;
	}
	
	
	
}
