package sist.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import sist.dao.SingletonClass;
import sist.dto.MemDTO;
import sist.dto.OrderDTO;
import sist.form.OrderHisFrame;

public class ReadThread extends Thread {
	Socket socket;

	public ReadThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		OrderDTO odto = null;
		MemDTO mdto = null;
		
		try{	
			SingletonClass sc = SingletonClass.getInstance();
			while(true){
				ObjectInputStream ois 
					= new ObjectInputStream(socket.getInputStream());
				//JOptionPane.showMessageDialog(null, "전송받음!!!!!!!!!!!!!!!!!!!!!!!!");
				try{
					//JOptionPane.showMessageDialog(null, "readObject 전 ");
					Object ob = ois.readObject();
					//JOptionPane.showMessageDialog(null, "readObject 후 ");
					
					if(ob instanceof OrderDTO){
						odto = (OrderDTO)ob;
						if(odto.getAuth()==0){
							if(!sc.loginMem.getId().equals(odto.getId())){
								sc.orderDao.list.add(odto);
							}
							
							//JOptionPane.showMessageDialog(null, "dto.getAuth()==0" + dto.getAuth());
							
						}else{
							//JOptionPane.showMessageDialog(null, "dto.getAuth()==0 else");
							
							for(int i=0; i<sc.orderDao.list.size(); ++i){
								OrderDTO d = sc.orderDao.list.get(i);
								if(odto.getId().equals(d.getId())){
									if(odto.getSeqNum() == d.getSeqNum()){
									sc.orderDao.list.set(i, odto);
									}
								}
								
							}
							
						}
					}else if(ob instanceof MemDTO){
						mdto = (MemDTO)ob;
						if(mdto.isJoin()){
					
							boolean isExist = false;
							for(int i=0; i<sc.memDao.list.size(); ++i){
								MemDTO d = sc.memDao.list.get(i);
								if(d.getId().equals(mdto.getId())){
									isExist = true;
								}
							}
							mdto.setJoin(false);
							if(!isExist) sc.memDao.list.add(mdto);
						}else{
							for(int i=0; i<sc.memDao.list.size(); ++i){
								MemDTO d = sc.memDao.list.get(i);
								if(mdto.getId().equals(d.getId())){
									sc.memDao.list.set(i, mdto);
								}
								
							}
						}
					}
					
					
					/*if(dto.getAuth()==0){ // 유저에서 온 패킷		
						sc.orderDao.list.add(dto);				
					}else{		// 어드민에서 온 패킷
						JOptionPane.showMessageDialog(null, "dto.getAuth()==0 else");
						
						for(int i=0; i<sc.orderDao.list.size(); ++i){
							OrderDTO d = sc.orderDao.list.get(i);
							if(dto.getId().equals(d.getId())){
								sc.orderDao.list.set(i, dto);
								System.out.println("전송받음!!!!!!!!!!!!!!!!!!!!!!!!");
								System.out.println(sc.orderDao.list.get(i).toString());
							}
							
						}
						JOptionPane.showMessageDialog(null, "야호!");
					}*/
										
					/*if(dto.getAuth()==0){						
						sc.orderDao.list.add(dto);
						JOptionPane.showMessageDialog(null, "dto.getAuth()==0" + dto.getAuth());
						//JOptionPane.showMessageDialog(null, "야호!");
					}else{
						JOptionPane.showMessageDialog(null, "dto.getAuth()==0 else");
						
						for(int i=0; i<sc.orderDao.list.size(); ++i){
							OrderDTO d = sc.orderDao.list.get(i);
							if(dto.getId().equals(d.getId())){
								sc.orderDao.list.set(i, dto);
								System.out.println("전송받음!!!!!!!!!!!!!!!!!!!!!!!!");
								System.out.println(sc.orderDao.list.get(i).toString());
							}
							
						}
						JOptionPane.showMessageDialog(null, "야호!");
					}*/
				}catch(ClassNotFoundException e){e.printStackTrace();}
				
				
			}		
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
	
	
}
