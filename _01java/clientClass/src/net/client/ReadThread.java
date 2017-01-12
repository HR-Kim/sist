package net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread {

	private Socket soc;
	
	public ReadThread(Socket soc) {
		this.soc = soc;
	}
	
	@Override
	public void run() {
		super.run();
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			
			while(true){
				String msg = reader.readLine();
				if(msg == null) break;
				System.out.println("받은 메시지 : " + msg);
			}
			
		} catch (IOException e) {
		}
	}
	
}
