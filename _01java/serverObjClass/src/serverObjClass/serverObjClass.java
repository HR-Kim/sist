package serverObjClass;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import server.NetworkSerialize;

public class serverObjClass {
	public static void main(String[] args) {
		ServerSocket servSock;
		Socket socket;
		ObjectInputStream ois;
		int port = Integer.parseInt("9000");
		
		try {
			servSock = new ServerSocket(port);
			System.out.println("서버 소켓 생성 성공");
			
			while(true){
				System.out.println("대기 중~~");
				socket = servSock.accept();
				
				ois = new ObjectInputStream(socket.getInputStream());
				
				//dto
				NetworkSerialize ns = (NetworkSerialize) ois.readObject();
				
				System.out.println("네트워크로 전송된 객체 : " + ns.toString());
				
				socket.close();
				
				servSock.close();
			}
			
		} catch (IOException e) {
		} catch	(ClassNotFoundException e){
			
		}
	}
}
