package threadClass;

public class mainClass {

	public static void main(String[] args) {
		/*
		 * Thread : 하나의 프로그램에서  여러개의 처리를 실행하기 위한 모델
		 *  == timer와 유사
		 *  
		 *  프로그램 : turn, realTime
		 * 
		 * 
		 */
		
		//Thread thread1 = new Thread();
		Thread thread1 = new ThreadEx("퐁");
		Thread thread2 = new ThreadEx("당");
		Thread thread3 = new ThreadEx("!!");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		System.out.println("프로그램종료");
	}	

}
