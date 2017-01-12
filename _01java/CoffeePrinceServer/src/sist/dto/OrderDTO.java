package sist.dto;

import java.io.Serializable;

public class OrderDTO implements Serializable {
	private String id;
	private String choice;
	private String size;
	private String syrup;
	private boolean isShot;
	private boolean isCream;	
	private int count;
	private int total;
	private boolean confirm;
	private int auth;
	private int seqNum;
	
	public OrderDTO() {
	}

	public OrderDTO(String id, String choice, String size, String syrup, boolean isShot, boolean isCream, int count) {
		super();
		this.id = id;
		this.choice = choice;
		this.size = size;
		this.syrup = syrup;
		this.isShot = isShot;
		this.isCream = isCream;
		this.count = count;
	}
	
	

	public int getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isConfirm() {
		return confirm;
	}

	public void setConfirm(boolean confirm) {
		this.confirm = confirm;
	}

	public boolean isShot() {
		return isShot;
	}

	public void setShot(boolean isShot) {
		this.isShot = isShot;
	}

	public boolean isCream() {
		return isCream;
	}

	public void setCream(boolean isCream) {
		this.isCream = isCream;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSyrup() {
		return syrup;
	}

	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", choice=" + choice + ", size=" + size + ", syrup=" + syrup + ", isShot="
				+ isShot + ", isCream=" + isCream + ", count=" + count + ", total=" + total + ", confirm=" + confirm
				+ ", auth=" + auth + ", seqNum=" + seqNum + "]";
	}

	

	

	
	
}
