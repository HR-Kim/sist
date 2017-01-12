package sandGameServerClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class serverClass {
	public static boolean user1Turn = true;
	public static boolean gameExit;
	
	public static void main(String[] args) {
		
		ServerSocket servSock = null;
		ArrayList<Socket> socList = new ArrayList<Socket>();
		gameExit = false;
		
		try {
			servSock = new ServerSocket(9000);
			Socket sock = null;
			Socket sock2 = null;
			BufferedReader br = null;
			
			System.out.println("대기중...");
			sock = servSock.accept();
			socList.add(sock);
			System.out.println("사용자1접속!!");
			System.out.println("대기중...");
			sock2 = servSock.accept();
			System.out.println("사용자2접속!!");
			socList.add(sock2);
			Thread th1 = new ServerThread(socList.get(0), socList);
			th1.start();
			Thread th2 = new ServerThread(socList.get(1), socList);
			th2.start();
			
			while(true){
				if(gameExit){
					th1.stop();
					th2.stop();
					sock.close();
					sock2.close();
					break;
				}
			}
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
