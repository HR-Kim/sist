
public class YouClass {
	private int num;
	private String str;
	
	public YouClass() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	public void fromSingleton(){
		SingletonClass scls = SingletonClass.getInstance();
		num = scls.num;
		str = scls.str;
	}
	public void toSingleton(){
		SingletonClass scls = SingletonClass.getInstance();
		scls.num = num;
		scls.str = str;
	}
	
}
