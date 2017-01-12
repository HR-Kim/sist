package studentClass.dto;

import java.util.Date;

public class StudentDTO {

	private int no;
	private String name;
	private Date date;
	private double height;
	
	public StudentDTO() {}

	public StudentDTO(int no, String name, Date date, double height) {
		super();
		this.no = no;
		this.name = name;
		this.date = date;
		this.height = height;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "StudentDTO [no=" + no + ", name=" + name + ", date=" + date + ", height=" + height + "]";
	}
	
	
	
	
}
