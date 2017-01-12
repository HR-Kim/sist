package sist.dao;

import java.net.Socket;

import sist.dto.MemDTO;
import sist.dto.OrderDTO;
import sist.network.MemWriteClass;
import sist.network.OrderWriteClass;

public class SingletonClass {
	private static SingletonClass single = null; // static 변수 : 공동 변수  클래스가 여러개라 하더라도 한 저장공간에서 사용
	public MemDAO memDao = new MemDAO();
	public OrderDAO orderDao = new OrderDAO();
	public MemDTO loginMem = null;
	public OrderDTO networkDto = null;
	public MemDTO networkDto1 = null;
	public Socket socket = null;
	public OrderWriteClass wc;
	public MemWriteClass mwc;
	
	public int seqNum = 0;
	
	private SingletonClass() {
		
	}
	public static SingletonClass getInstance(){
		if(single == null){
			single = new SingletonClass();
		}
		return single;
	}
}
