
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass cls = new MyClass();
		YouClass ycls = new YouClass();
		
		cls.setNum(123);
		cls.setStr("Hello");
		
		cls.toSingleton();
		
		ycls.fromSingleton();
		
		System.out.println("YouClass의 num : " + ycls.getNum());
		System.out.println("YouClass의 str : " + ycls.getStr());
		
		ycls.setNum(321);
		ycls.setStr("Hi");

		ycls.toSingleton();
		cls.fromSingleton();
		
		System.out.println("MyClass의 num : " + cls.getNum());
		System.out.println("MyClass의 str : " + cls.getStr());
		
	}

}
