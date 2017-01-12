package clientObjClass;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import server.NetworkSerialize;

public class mainClass {

	public static void main(String[] args) {
		try {
			Socket sock = new Socket("127.0.0.1", 9000);
			
			ObjectOutputStream oos = new ObjectOutputStream(sock.getOutputStream());
			
			//전송할 객체 생성
			NetworkSerialize ns = new NetworkSerialize(111, "홍길동");
			
			oos.writeObject(ns);
			oos.flush();
			
			sock.close();
			
			
		} catch (IOException e) {
		}
		
		
	}

}
