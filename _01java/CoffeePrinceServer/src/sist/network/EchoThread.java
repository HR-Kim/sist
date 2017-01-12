package sist.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import sist.dto.MemDTO;
import sist.dto.OrderDTO;

public class EchoThread extends Thread {
	Socket socket;
	List<Socket> list;
	
	public EchoThread(Socket socket, List<Socket> list) {
		this.socket = socket;
		this.list = list;
	}

	@Override
	public void run() {
		OrderDTO odto = null;
		MemDTO mdto = null;
		
		try{
			while(true){
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				try {
					Object ob = ois.readObject();
					
					if(ob instanceof OrderDTO){
						odto = (OrderDTO)ob;
						System.out.println("네트워크로 전송된 객체는 " + odto.toString());
						sendMsg(odto);
					}else if(ob instanceof MemDTO){
						mdto = (MemDTO)ob;
						System.out.println("네트워크로 전송된 객체는 " + mdto.toString());
						sendMsg(mdto);
					}
					
				} catch (ClassNotFoundException e) {
				}	
					
			}
			
		}catch(IOException e){
			
		}
	}
	
	public void sendMsg(OrderDTO odto) {
		
		
		try{
			for (Socket socket:list) {				
				ObjectOutputStream oos 
					= new ObjectOutputStream(socket.getOutputStream());
				//if(socket != this.socket){
					oos.writeObject(odto);
					oos.flush();
					
					System.out.println("odto:" + odto.toString());
						
				//}				
			}			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
public void sendMsg(MemDTO mdto) {
		
		
		try{
			for (Socket socket:list) {				
				ObjectOutputStream oos 
					= new ObjectOutputStream(socket.getOutputStream());
				//if(socket != this.socket){
					oos.writeObject(mdto);
					oos.flush();
					
					System.out.println("mdto:" + mdto.toString());
						
				//}				
			}			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
}
