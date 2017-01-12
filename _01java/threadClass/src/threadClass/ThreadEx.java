package threadClass;

public class ThreadEx extends Thread{
	
	String msg;
	
	public ThreadEx(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		super.run();
		
		for (int i = 0; i < 50; i++) {
			System.out.println(msg);
			try{
				Thread.sleep(1000);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	

}
