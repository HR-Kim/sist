package hashmapClass;

public class DTO {
	int number;
	String name;
	
	public DTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public DTO(int number, String name) {
		super();
		this.number = number;
		this.name = name;
	}



	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void output() {
		System.out.println("number : " + number + " name : " + name);
	}
	
	
	
}









