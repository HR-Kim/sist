package sandGameServerClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
	
	
	private Socket sock;
	private ArrayList<Socket> list;
	private static int num =(int)(Math.random()*85)+15;
	serverClass sc = new serverClass();
	public ServerThread() {
		
	}
	
	public ServerThread(Socket s, ArrayList<Socket> l) {
		sock = s;
		list = l;
		System.out.println("연결 IP: "+ sock.getInetAddress() + "연결 port : " + sock.getPort());
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		BufferedReader reader = null;	//recv
		PrintWriter sendout = null;		//send
		
		
		String msg = null;
		try {
				reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				
		game:	while(true){
					msg = reader.readLine();
					int number = Integer.parseInt(msg);
					
					if(msg != null){
						System.out.println("받은 Packet : " + msg);
					}
					if(this.sock == list.get(0) && sc.user1Turn){
						if(num - number > 0){
							num = num - number;
							for(int i=0; i < list.size(); ++i){
								Socket s = list.get(i);
								if(this.sock != s){
									sendout = new PrintWriter(s.getOutputStream());
									sendout.println("user1(상대편)이");
									sendout.println(msg+ "만큼 모래제거성공");							
									sendout.flush();
								}else{									
									sendout = new PrintWriter(s.getOutputStream());
									sendout.println(msg+ "모래제거성공");
									sendout.flush();
								}
								
							}
						}else{
							for(int i=0; i < list.size(); ++i){
								Socket s = list.get(i);
								
								if(this.sock != s){
									sendout = new PrintWriter(s.getOutputStream());
									sendout.println("user1이 깃발을 떨어뜨렸으므로");
									sendout.println("이겼습니다!!");	
									sendout.flush();
								}else{
									sendout = new PrintWriter(s.getOutputStream());
									sendout.println("깃발을 떨어뜨렸으므로");
									sendout.println("졌습니다..");
									sendout.flush();
								}
								
							}
							sc.gameExit = true;
							break game;
							
						}
						sc.user1Turn = false;
					}else if(this.sock == list.get(1) && !(sc.user1Turn)){
						if(num - number > 0){
							num = num - number;
							for(int i=0; i < list.size(); ++i){
								Socket s = list.get(i);
								if(this.sock != s){
									sendout = new PrintWriter(s.getOutputStream());
									sendout.println("(user2)상대편이");
									sendout.println(msg+ "만큼 모래제거성공");							
									sendout.flush();
								}else{									
									sendout = new PrintWriter(s.getOutputStream());
									sendout.println(msg+ "모래제거성공");
									sendout.flush();
								}
								
							}
						}else{
							for(int i=0; i < list.size(); ++i){
								Socket s = list.get(i);
								
								if(this.sock != s){
									sendout = new PrintWriter(s.getOutputStream());
									sendout.println("user2이 깃발을 떨어뜨렸으므로");
									sendout.println("이겼습니다!!");
									sendout.flush();
								}else{
									sendout = new PrintWriter(s.getOutputStream());
									sendout.println("깃발을 떨어뜨렸으므로");
									sendout.println("졌습니다..");
									sendout.flush();
								}
								sc.gameExit = true;
								break game;
								
							}
							
						}
						sc.user1Turn = true;
					}else{
						sendout = new PrintWriter(sock.getOutputStream());
						sendout.println("당신의 차례가 아닙니다!!");
						sendout.flush();
					}
					
					
					
					Thread.sleep(10);
					msg = null;
				}
			} catch (IOException e) {
				try {
					if(reader !=null){
						reader.close();
					}
					if(sock != null){
					
						sock.close();
					} 
				}catch (IOException e1) {
					
				}
		}catch (InterruptedException e2){
			
		} 
		
	}
	
}






