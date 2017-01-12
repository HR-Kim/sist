package sandGameUser1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientClass {
	public static void main(String[] args) {
		int timeout = 10000;
		
		try {
			InetSocketAddress sockAd = new InetSocketAddress("211.238.142.199", 9000);
			Socket socket = new Socket();
			socket.connect(sockAd, timeout);
			
			
			InetAddress inetAd;
			if((inetAd = socket.getInetAddress()) != null){
				System.out.println("연결 : " + inetAd);
			}else{
				System.out.println("연결실패");
				socket.close();
				return;
			}
			
			new ReadThread(socket).start();
			while(true){
				if((inetAd = socket.getInetAddress()) != null){
					new WriteClass(socket).run();
				}else{
					System.out.println("게임종료");
					socket.close();
					break;
				}
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
