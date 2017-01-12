import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public class EchoThread extends Thread {
	
	Socket socket;
	Vector<Socket> vec;
	
	public EchoThread(Socket s, Vector<Socket> v) {
		socket = s;
		vec = v;
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
					vec.remove(this.socket);
					break;
				}
			}
			//send
			send(str);
			
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void send(String str) {
		try {
			for(Socket socket : vec){
				if(socket != this.socket){
					PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
					pw.println(str);
					pw.flush();
				}	//자신이 보낸 소켓은 자신한테 다시 보내지 않도록 한다!
			}
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
