import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class WriteClass {
	
	Socket socket;
	ClientFrame cf;
	String str;
	String id;
	
	public WriteClass(ClientFrame cf) {
		// 전송하는 클래스
		this.cf = cf;
		this.socket = cf.socket;
		
	}
	

	
	public void sendMsg(){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = null;
		
		try {
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			if(cf.isFirst){	// 첫번째 Packet 전송
				InetAddress iaddr = socket.getLocalAddress();
				String ip = iaddr.getHostAddress();
				getId();
				System.out.println("ip : " + ip +  " id:" + id);
				str = "[" + id + "] 님 로그인 (" + ip + ")";
			}else{
				str = "[" + id + "] " + cf.txtF.getText();
			}
			pw.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getId() {
		this.id = Id.getId();
	}
}






