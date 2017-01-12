package sist.main;

import java.io.IOException;
import java.net.Socket;

import sist.dao.SingletonClass;
import sist.form.LoginFrame;
import sist.form.MenuFrame;
import sist.form.OrderFrame;
import sist.form.OrderHisFrame;
import sist.network.ReadThread;
import sist.network.MemWriteClass;
import sist.network.OrderWriteClass;

public class mainClass {

	public static void main(String[] args) {
		
		
		
		Socket socket = null;
		SingletonClass sc = SingletonClass.getInstance();
		
		
		try{	
			socket = new Socket("211.238.142.199", 9000);
			sc.socket = socket;
			sc.wc = new OrderWriteClass(sc.socket);
			sc.mwc = new MemWriteClass(sc.socket);
			System.out.println("연결 성공!!");
			
			new LoginFrame();
			
			new ReadThread(socket).start();
		}catch(IOException e){
			
		}
		

	}

}
