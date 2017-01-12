import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public class EchoThread extends Thread {
	
	Socket socket;
	Vector<Socket> vec;
	
	public EchoThread(Socket socket, Vector<Socket> vec) {
		this.socket = socket;
		this.vec = vec;
	}

	@Override
	public void run() {
		NetworkDTO ndto = null;		
		try{			
			while(true){
				// recv
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				Object ob = new Object();
				
				try{
					ndto = (NetworkDTO)ois.readObject();
					
					System.out.println("네트워크로 전송된 객체는 " + ndto.toString());
				}catch(ClassNotFoundException e){					
				}
				
				if(ndto.getPlay() == 1) ndto.setPlay(2);
				else					ndto.setPlay(1);
				
				// send
				sendMsg(ndto);
			}
		
		}catch(IOException e){
			
		}
	}
	
	public void sendMsg(NetworkDTO dto) {
		int num = 0;
		
		System.out.println("dto:" + dto.toString());
		
		try{
			for (Socket socket:vec) {				
				ObjectOutputStream oos 
					= new ObjectOutputStream(socket.getOutputStream());
				num++; 
				dto.setNumber(num);
				oos.writeObject(dto);
				oos.flush();				
			}			
		}catch(IOException e){			
		}
	}
	
}
