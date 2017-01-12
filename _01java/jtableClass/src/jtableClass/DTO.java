package jtableClass;

import java.io.Serializable;

public class DTO implements Serializable{
	private int seqNum;
	private int money;
	
	private String name;
	private String company;
	
	public DTO() {
	
	}

	public DTO(int seqNum, int money, String name, String company) {
		super();
		this.seqNum = seqNum;
		this.money = money;
		this.name = name;
		this.company = company;
	}

	public int getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "DTO [seqNum=" + seqNum + ", money=" + money + ", name=" + name + ", company=" + company + "]";
	}
	

}
