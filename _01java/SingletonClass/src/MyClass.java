
public class MyClass {
	
	private int number;
	private String str = "multiton";
	
	public MyClass() {
		number = 1123;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void method(){
		SingletonClass scls = SingletonClass.getInstance();
		scls.sNumber = number;
		str = scls.sStr;
		
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
