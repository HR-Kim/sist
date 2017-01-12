package sutdaProject.DTO;

public class HumanClass {
	private int id;
	private int password;
	private int no;
	private String name;
	private int age;
	private int money;
	
	public HumanClass() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public HumanClass(int id, int password, int no, String name, int age, int money) {
		super();
		this.id = id;
		this.password = password;
		this.no = no;
		this.name = name;
		this.age = age;
		this.money = money;
	}

	@Override
	public String toString() {
		return id + "-" + password + "-" + no + "-" + name + "-" + age
				+ "-" + money;
	}
	
	
}


