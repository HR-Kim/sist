
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayQueue queue = new ArrayQueue(10);
		
		
		
	
	
		if(queue.isEmpty()){
			String str = "AAA";
			queue.push(str);

			String rstr = (String)queue.peek();
			System.out.println("front = " + rstr);
			
			str = "BBB";
			queue.push(str);

			rstr = (String)queue.peek();
			System.out.println("front = " + rstr);
			
			queue.pop();
			
			str = "CCC";
			queue.push(str);

			rstr = (String)queue.peek();
			System.out.println("front = " + rstr);
		}
	}

}
