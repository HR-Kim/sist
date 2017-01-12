
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack stack = new ArrayStack(10);
		
		if(stack.isEmpty()){
			
			String str = "AAA";
			stack.push(str);
			
			String rstr = (String)stack.peek();
			System.out.println("rstr = " + rstr);
			
			
			
			
			str = "BBB";
			stack.push(str);
			rstr = (String)stack.peek();
			System.out.println("rstr = " + rstr);
			stack.pop();
			rstr = (String)stack.peek();
			System.out.println("rstr = " + rstr);
			
			str = "CCC";
			stack.push(str);
			rstr = (String)stack.peek();
			System.out.println("rstr = " + rstr);
			
		}
	}

}
