
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box = new Box(423);	//Integer
		System.out.println("box.i" + box.get());
		
		Box box1 = new Box(423.0);	//Double
		System.out.println("box1.i" + box1.get());
		
		Box box2 = new Box("Hello");	//String
		System.out.println("box1.i" + box2.get());
		
		
		Box<Integer> ibox 
			= new Box<Integer>(new Integer(123));
		
		Box ibox1 
		= new Box(new Integer(123));
		
		// Standard Template Library
		
		/*
		 * Generic : 자료형의 변수
		 * 자료형을 나중에 결정하도록 하는 기능
		 */
		
	}

}
