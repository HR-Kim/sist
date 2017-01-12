package net.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class serverClass {
	public static void main(String[] args) {
		/*
		 * Server
		 * 	
		 * 	버전확인
		 * 	1.Socket 생성
		 * 		Async(비동기) <-> sync
		 *  2.binding -> IP, port
		 *  3.listening -> Socket 열기
		 *  4.Accept(대기) <---> client
		 *  5.Packet 전송
		 *  6.뒷처리
		 * 
		 */
		
		ArrayList<Socket> socList = new ArrayList<Socket>();
		//서버 소켓 생성
		int port = Integer.parseInt("9000"); // 1~1024는 사용하지 마라
		try{
			ServerSocket srvSock = new ServerSocket(port);
			// 3번 작업까지 진행
			System.out.println("서버 소켓 생성 성공");
			Socket socket = null;
			BufferedReader reader = null;
			
			//무한루프
			while(true){
				System.out.println("대기중...");
				
				// 접속 대기
				socket = srvSock.accept();
				
				// 소켓 정보 추가
				socList.add(socket);
				
				//Thread 동작
				Thread th = new ServerThread(socket, socList);
				th.start();
				/*
				// packet 전송 recv(수신) send(송신)
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = reader.readLine();	//receive
				
				// 전송된 문자열
				System.out.println("수신 메시지 : " + line);
				
				
				
				//Packet 보내기
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				System.out.println("보내는 메세지 : " + line);
				
				writer.println("서버에서 " +line );	//send
				
				writer.flush();		//중요!!
				
				
				writer.close();*/
			}
			//reader.close();
			//socket.close();
			//srvSock.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
}











