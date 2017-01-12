package net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class clientClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int timeout = 10000;
		try{
			InetSocketAddress sockAddress = new InetSocketAddress("211.238.142.18", 9500);
			Socket socket = new Socket();
			socket.connect(sockAddress, timeout);
			
			InetAddress inetAd;
			if((inetAd = socket.getInetAddress()) != null){
				System.out.println("연결 : " + inetAd);
			}else{
				System.out.println("연결 실패");
				socket.close();
				return;
			}
			
			// recv - 대기 == Thread
			Thread tr = new ReadThread(socket);
			tr.start();
			while(true){
				// send != Thread
				new WriteClass(socket).run();
			}

			
			/*
			// 보낼 메세지
			String msg = "삽입~~!!";
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			System.out.println("보내는 메세지 : " + msg);
			
			writer.println(msg);	//send
			
			writer.flush();		//중요!!
			
			// Packet 받기
			
			BufferedReader reader = null;
			
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = reader.readLine();	//receive
			
			// 전송된 문자열
			System.out.println("수신 메시지 : " + line);
			
			reader.close();
			writer.close();
			socket.close();
			*/	
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		
	}

}
