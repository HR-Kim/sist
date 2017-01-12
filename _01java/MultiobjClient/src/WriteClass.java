import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class WriteClass {
	
	// 전송하는 클래스
		Socket socket;
		ClientFrame cf;
		String str;
		String id;
		
		NetworkDTO dto;

		public WriteClass(ClientFrame cf) {
			this.cf = cf;
			this.socket = cf.socket;
				
		}
		
		public void sendMsg() {
			
			ObjectOutputStream oos;		
			try{
				oos = new ObjectOutputStream(socket.getOutputStream());
				
				dto = cf.dto;
				
				dto.setName(cf.txtF.getText());
							
				oos.writeObject(dto);
				oos.flush();		
				
			}catch(IOException e){
			}
		}
	
	
}






