package miniboard;

import java.io.Serializable;


/*CREATE TABLE MINI_BOARD (
		mi_id NUMBER NOT NULL,  ID 
		mi_name VARCHAR2(7) NOT NULL,  작성자 
		mi_date DATE DEFAULT sysdate NOT NULL,  작성일 
		mi_email VARCHAR2(320) NOT NULL,  E-MAIL 
		mi_passwd VARCHAR2(6) NOT NULL,  비번 
		mi_contents VARCHAR2(4000) NOT NULL,  내용 
		mi_view_yn CHAR(1) DEFAULT 'Y' NOT NULL  사용여부 
	);*/

public class MiniBean implements Serializable {

	private static long serialVersionUID = -2360519294479595671L;
	
	private int mi_id;
	private String mi_name;
	private String mi_date;
	private String mi_email;
	private String mi_passwd;
	private String mi_contents;
	private char mi_view_yn;
	
	public MiniBean() {}

	public MiniBean(int mi_id, String mi_name, String mi_date, String mi_email, String mi_passwd, String mi_contents,
			char mi_view_yn) {
		super();
		this.mi_id = mi_id;
		this.mi_name = mi_name;
		this.mi_date = mi_date;
		this.mi_email = mi_email;
		this.mi_passwd = mi_passwd;
		this.mi_contents = mi_contents;
		this.mi_view_yn = mi_view_yn;
	}
	
	public MiniBean(String mi_name, String mi_date, String mi_email, String mi_passwd, String mi_contents) {
		super();
		this.mi_name = mi_name;
		this.mi_date = mi_date;
		this.mi_email = mi_email;
		this.mi_passwd = mi_passwd;
		this.mi_contents = mi_contents;
		mi_view_yn = 'Y';
	}

	public int getMi_id() {
		return mi_id;
	}

	public void setMi_id(int mi_id) {
		this.mi_id = mi_id;
	}

	public String getMi_name() {
		return mi_name;
	}

	public void setMi_name(String mi_name) {
		this.mi_name = mi_name;
	}

	public String getMi_date() {
		return mi_date;
	}

	public void setMi_date(String mi_date) {
		this.mi_date = mi_date;
	}

	public String getMi_email() {
		return mi_email;
	}

	public void setMi_email(String mi_email) {
		this.mi_email = mi_email;
	}

	public String getMi_passwd() {
		return mi_passwd;
	}

	public void setMi_passwd(String mi_passwd) {
		this.mi_passwd = mi_passwd;
	}

	public String getMi_contents() {
		return mi_contents;
	}

	public void setMi_contents(String mi_contents) {
		this.mi_contents = mi_contents;
	}

	public char getMi_view_yn() {
		return mi_view_yn;
	}

	public void setMi_view_yn(char mi_view_yn) {
		this.mi_view_yn = mi_view_yn;
	}

	@Override
	public String toString() {
		return "MiniBean [mi_id=" + mi_id + ", mi_name=" + mi_name + ", mi_date=" + mi_date + ", mi_email=" + mi_email
				+ ", mi_passwd=" + mi_passwd + ", mi_contents=" + mi_contents + ", mi_view_yn=" + mi_view_yn + "]";
	}
	
}











