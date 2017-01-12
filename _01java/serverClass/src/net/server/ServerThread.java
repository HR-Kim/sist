package net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{

	private Socket soc;
	private ArrayList<Socket> list;
	
	public ServerThread(Socket soc, ArrayList<Socket> list) {
		this.soc = soc;
		this.list = list;
		
		// 연결된 client의 주소를 표시
		System.out.println("연결 IP: "+ soc.getInetAddress() + "연결 port : " + soc.getPort());
		
	}
	
	@Override
	public void run() {
		super.run();
		
		BufferedReader reader = null;	//recv
		PrintWriter sendout = null;		//send
		
		try{
			String msg = null;
			reader = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			
			while(true){
				//recv
				msg = reader.readLine();
				if(msg != null){
					System.out.println("받은 Packet : " + msg);
				}
				//send
				for(int i=0; i < list.size(); ++i){
					Socket s = list.get(i);
					
					if(this.soc != s){
						sendout = new PrintWriter(s.getOutputStream());
						sendout.println(msg);
						sendout.flush();
					}
					
				}
				
				Thread.sleep(10);
				msg = null;
			}
		}catch(IOException e){
			
		}catch (InterruptedException e) {
			try {
				if(reader !=null){
					reader.close();
				}
				if(soc != null){
				
					soc.close();
				} 
			}catch (IOException e1) {
				
			}
		}
		
	}
	
	
	
}
