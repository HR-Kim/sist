package sandGameUser2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;



public class WriteClass {
	private Socket soc;
	Scanner sc = new Scanner(System.in);
	
	public WriteClass(Socket s) {
		soc = s;
	}
	
	public void run() {
		PrintWriter writer = null;
		
		try{
			writer = new PrintWriter(soc.getOutputStream());
			System.out.println("보낼문자열:");
			String msg = sc.nextLine();
			writer.println(msg);
			writer.flush();

		}catch(IOException e){
			
		}
	}
}
