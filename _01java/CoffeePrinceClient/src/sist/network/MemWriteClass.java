package sist.network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import sist.dao.SingletonClass;
import sist.dto.MemDTO;
import sist.dto.OrderDTO;

public class MemWriteClass {
	Socket socket;
	MemDTO dto;

	public MemWriteClass(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void sendMsg() {
	//	ObjectOutputStream oos;
		SingletonClass sc = SingletonClass.getInstance();
		try{
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			dto = sc.networkDto1;
	
			oos.writeObject(dto);
			oos.flush();		
			
			System.out.println("send 완료 : " + dto.toString() );
			
		}catch(IOException e){
		}
	}
}
