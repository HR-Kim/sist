package sandGameUser1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread{
	
	private Socket soc;
	
	public ReadThread(Socket s) {
		soc = s;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		BufferedReader reader = null;
		
		try{
			reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			while(true){
				String msg = reader.readLine();
				if(msg == null) break;
				System.out.println("받은 메시지 : " + msg);
			}
			
		}catch(IOException e){
			
		}
	}
	
}
