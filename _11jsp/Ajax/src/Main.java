import java.util.Scanner;

public class Main {

	private int top;
	private static int[] stackArray;
	private static int[] ansArray;
	
	public Main() {
		this.top = -1;
		stackArray = new int[100000];
		ansArray = new int[100000];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		int orderNum = sc.nextInt();
		
		for(int i=0; i<orderNum; ++i){
			//System.out.print(i+"번째 배열 : ");
			ansArray[i] = sc.nextInt();
			/*if(!(ansArray[i] > 0 && ansArray[i]<=orderNum)){
				--i;
			}else{
				for(int j=0; j<i; ++j){
					
					if(ansArray[i] == ansArray[j]){
						--i;
						break;
					}
				}
			}*/
		}
		
		boolean isOk = m.isOk(orderNum);
		
		//System.out.println("되나?" + isOk);
		
		if(isOk){
			m.printout(orderNum);
		}else{
			System.out.println("NO");
		}
		
		sc.close();
		
	}
	
	public void printout(int num){
		boolean[] ascArr = new boolean[num];
		
		for(int i=0; i<ascArr.length; ++i){
			ascArr[i] = true;
		}
		
		for(int i=0; i<num; ++i){	
			if(top()==ansArray[i]){
				//push(ansArray[i]);
				pop();
			}else if(top() < ansArray[i]){
				for(int j=top(); j<ansArray[i]; j++){
					if(j == -1){
						j++;
					}
					
					if(ascArr[j]){
						push(j+1);
						ascArr[j] = false;
					}	
				}
				pop();
			}else{
				System.out.println("오류");
			}
			
		}
	}
	
	public boolean isOk(int num){
		int[] ascArr = new int[num];  
		
		int temp=1;
		for(int i=0; i<ascArr.length; ++i){
			ascArr[i] = temp;
			temp++;
		}
		
		int w=0;
		int gap = 0;
		ascArr[ansArray[0]-1] = 0;
		w++;
		while(w < num){
			gap = ansArray[w] - ansArray[w-1];
			if(gap < - 1){
				for(int i = ansArray[w]+1; i<ansArray[w-1]; i++){
					if(ascArr[i-1]==0){
						gap++;
					}
				}
				if(gap == -1){
					ascArr[ansArray[w]-1] = 0;
					w++;
				}else{
					return false;
				}
			}else{
				ascArr[ansArray[w]-1] = 0;
				w++;
			}
		}
		
		return true;
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
        System.out.println("+");
    }
	
	public int top(){
	    
		if(top == -1){
			//System.out.println(-1);
			return -1;
		}else{
			//System.out.println(stackArray[top]);
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
			System.out.println("-");
			return item;
		}
        
       
    }


}
