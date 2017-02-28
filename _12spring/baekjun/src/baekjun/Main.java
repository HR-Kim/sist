package baekjun;
import java.util.Scanner;

public class Main {

	private int top;
	private static int[] stackArray;
	private static String[] ansArray;
	
	public Main() {
		this.top = -1;
		stackArray = new int[30];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		
		int orderNum = 1; 
				//sc.nextInt();
		ansArray = new String[orderNum];
				
		ansArray[0] = "(()[[]])([])"; 
//		for(int i=0; i<orderNum; ++i){
//			ansArray[i] = sc.next();
//		}
		
		for(int i=0; i<orderNum; ++i){
			if(m.isVPS(ansArray[i])){
				System.out.println("YES");
			}else{
				System.out.println(0);
			}
		}
		
		sc.close();
		
	}
	
	public int calc(String str){
		for(int i=0; i<str.length(); ++i){
			
		}
	}
	
	public boolean isVPS(String str){
		top = -1;
		for(int i=0; i<str.length(); ++i){
			if(str.charAt(i) == '('){
				push(1);
				
			}else if(str.charAt(i) == ')'){
				if(top() == -1){
					return false;	
				}else if(top() == 2){
					return false;
				}else{
					pop();
				}
			}else if(str.charAt(i) == '['){
				push(2);
			}else if(str.charAt(i) == ']'){
				if(top() == -1){
					return false;	
				}else if(top() == 1){
					return false;
				}else{
					pop();
				}
			}
		}
		
		return pop()==-1 ? true : false;
	}
	
	public int empty(){
		if(top == -1){
			return 1;
		}else{
			return 0;
		}
	}
	
	
	public void push(int item){
        
        stackArray[++top] = item;
    }
	
	public int top(){
	    
		if(top == -1){
			
			return -1;
		}else{
			
			return stackArray[top];
		}
	        
		
	}
	
	public int size(){
		
		return top+1;
	}
	 
	public int pop(){
        
		if(top == -1){
			return -1;
		}else{
			int item = stackArray[top];
			top = top-1;
			return item;
		}
        
       
    }


}
