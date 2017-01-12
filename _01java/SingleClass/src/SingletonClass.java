
public class SingletonClass {
	private static SingletonClass singleton = null;
	public int num;
	public String str;
	
	private SingletonClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static SingletonClass getInstance(){
		if(singleton == null){
			singleton = new SingletonClass();
		}
		return singleton;
	}
	
}
