
public class Main {

	public static void main(String[] args) {
		// 재귀호출 -> Quick Sort
		/*
		 * 재귀호출 :
		 * 	메소드 안에서 본인 메소드를 호출
		 * 
		 */
		
		int input = 4;
		int r;
		
		r = method(input);
		
		System.out.println("r = " + r);
	}
	
	public static int method(int n){
		if(n<=1){
			return n;
		}
		else{
			return method(n-1) * n;
		}
	}
	
}

/*
 * method(4) == method(3) * 4
 * 				method(2) *3
 * 				method(1) *2
 *  		== 24;
 * 
 * 
 * 				
 */














