package baseball.dto;

//Date Transfer Object ( == DTO)
public class Human extends Object{
	private int no;
	private String pos;
	private String name;
	private String birth;
	private int age;
	private double height;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(int no, String pos, String name, String birth, int age, double height) {
		super();
		this.no = no;
		this.pos = pos;
		this.name = name;
		this.birth = birth;
		this.age = age;
		this.height = height;
	}

	

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return no + "-" + pos + "-" + name + "-" + birth + "-" + age + "-"
				+ height;
	}

	
	
	
}
