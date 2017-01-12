package net.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteClass {
	
	private Socket soc;
	Scanner sc = new Scanner(System.in);
	
	public WriteClass(Socket soc) { // soc : 서버에 대한 정보
		this.soc = soc;
	}
	
	public void run() {
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(soc.getOutputStream());
			System.out.print("보낼 문자 열 :");
			String msg = sc.nextLine();
			writer.println(msg);
			writer.flush();
			
		} catch (IOException e) {
		}
	}
}
