import java.util.Scanner;

public class Main {

	private int top;
	private int[] stackArray;
	
	public Main() {
		this.top = -1;
		stackArray = new int[10000];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		int orderNum = sc.nextInt();
		
		String order = "";
		for(int i=0; i<orderNum; ++i){
			order = sc.next();
			if(order.equals("push")){
				int num = sc.nextInt();
				m.push(num);
			}else if(order.equals("pop")){
				m.pop();
			}else if(order.equals("size")){
				m.size();
			}else if(order.equals("empty")){
				m.empty();
			}else if(order.equals("top")){
				m.top();
			}
		}
		sc.close();
		
	}
	
	public int empty(){
		if(top == -1){
			System.out.println(1);
			return 1;
		}else{
			System.out.println(0);
			return 0;
		}
	}
	
	public void push(int item){
        
        stackArray[++top] = item;
    }
	
	public int top(){
	    
		if(top == -1){
			System.out.println(-1);
			return -1;
		}else{
			System.out.println(stackArray[top]);
			return stackArray[top];
		}
	        
		
	}
	
	public int size(){
		System.out.println(top+1);
		return top+1;
	}
	 
	public int pop(){
        
		if(top == -1){
			System.out.println(-1);
			return -1;
		}else{
			int item = stackArray[top];
			top--;
			System.out.println(item);
			return item;
		}
        
        
        
    }


}
