import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class mainClass {

public static void main(String[] args) {
		
		ServerSocket serverSock = null;
		Socket socket = null;
		
		Vector<Socket> vec = new Vector<Socket>();
		
		try{
			serverSock = new ServerSocket(9000);
			
			while(true){
			
				System.out.println("접속 대기중...");
				socket = serverSock.accept();
				
				// vector에 담기
				vec.add(socket);			
			
				new EchoThread(socket, vec).start();
			}
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		

	}

}
