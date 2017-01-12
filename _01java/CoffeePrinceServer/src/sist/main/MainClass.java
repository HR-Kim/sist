package sist.main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

import sist.network.EchoThread;

public class MainClass {
	public static void main(String[] args) {
		ServerSocket serverSock = null;
		Socket socket = null;
		
		List<Socket> list = new LinkedList<Socket>();
		
		try {
			serverSock = new ServerSocket(9000);
			
			while(true){
				
				System.out.println("접속대기중...");
				socket = serverSock.accept();
				
				list.add(socket);
				
				new EchoThread(socket, list).start();
			}
		} catch (IOException e) {
		}
		
		
	}
}
