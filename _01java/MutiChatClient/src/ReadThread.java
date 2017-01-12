import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String str = null;
			//receive
			while(true){
				str = br.readLine();
				if(str == null){ //상대가 접속을 끊었을 경우
					System.out.println("접속이 끊겼음");
					break;
				}
			}
			//send
			cf.txtA.append(str + "\n");
			
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	
}
