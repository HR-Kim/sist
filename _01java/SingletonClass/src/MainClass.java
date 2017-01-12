
public class MainClass {

	public static void main(String[] args) {
		MyClass cls = new MyClass();
		YouClass ycls = new YouClass();
				
		//cls.setNumber(22);
		
		ycls.Func();
		cls.method();
		//ycls.method(cls.getNumber());
		System.out.println("MyClass의 str : " +cls.getStr());
	}

}
