package springbook.code.doamin;

public class CodeM {
	 private int cd_id ;	/* 코드_ID */
	 private String cd_nm ; /* 코드_명 */
	 private String reg_id; /* 등록자 */
	 private String reg_dt; /* 등록일 */
	 private String mod_id; /* 수정자 */
	 private String mod_dt; /* 수정일 */
	 
	 public CodeM() {}

	public int getCd_id() {
		return cd_id;
	}

	public void setCd_id(int cd_id) {
		this.cd_id = cd_id;
	}

	public String getCd_nm() {
		return cd_nm;
	}

	public void setCd_nm(String cd_nm) {
		this.cd_nm = cd_nm;
	}

	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	public String getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getMod_id() {
		return mod_id;
	}

	public void setMod_id(String mod_id) {
		this.mod_id = mod_id;
	}

	public String getMod_dt() {
		return mod_dt;
	}

	public void setMod_dt(String mod_dt) {
		this.mod_dt = mod_dt;
	}
	 
	 
}
