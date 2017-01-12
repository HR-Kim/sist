import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class mainClass {

	public static void main(String[] args) {
		
		Socket socket = null;
		ClientFrame cf;
		
		
		try {
			socket = new Socket("211.238.142.199", 9000);
			System.out.println("연결성공!!!");
			cf = new ClientFrame(socket);
			
			new ReadThread(socket, cf).start();
		}catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
