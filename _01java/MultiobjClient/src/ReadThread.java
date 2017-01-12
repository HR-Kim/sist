import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ReadThread extends Thread {
	Socket socket;
	ClientFrame cf;
	
	public ReadThread(Socket socket, ClientFrame cf) {
		this.cf = cf;
		this.socket = socket;
	}
	@Override
	public void run() {
		NetworkDTO dto = null;	
		try{			
			while(true){
				ObjectInputStream ois 
					= new ObjectInputStream(socket.getInputStream());
				try{
					dto = (NetworkDTO)ois.readObject();
					
					cf.dto = dto;
					
					cf.txtA.append(dto.toString() + "\n");
					
				}catch(ClassNotFoundException e){}
				
				
			}		
		}catch(IOException e){			
		}		
	}	
	
	
}
