
public class YouClass {
	
	private int num;
	private String str = "singleton";
	
	public void method(int n){
		num = n;
		System.out.println("num = " + num);
	}
	public void Func(){
		SingletonClass sc = SingletonClass.getInstance();
		num = sc.sNumber;
		sc.sStr = str;
		//System.out.println("num = " + num);
	}
}
