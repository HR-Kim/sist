package sist.network;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import sist.dao.SingletonClass;
import sist.dto.OrderDTO;

public class OrderWriteClass {
	Socket socket;
	OrderDTO dto;

	public OrderWriteClass(Socket socket) {
		super();
		this.socket = socket;
	}
	
	public void sendMsg() {
	//	ObjectOutputStream oos;
		SingletonClass sc = SingletonClass.getInstance();
		try{
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			dto = sc.networkDto;
	
			oos.writeObject(dto);
			oos.flush();		
			
			System.out.println("send 완료 : " + dto.toString() );
			
		}catch(IOException e){
		}
	}
}
