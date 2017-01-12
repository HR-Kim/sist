package DataAccessLoop;

import java.util.ArrayList;
import java.util.HashMap;

import baseball.dto.Human;


public class SingletonClass {
	private static SingletonClass singleton = new SingletonClass();
	//public ArrayList<Human> list = new ArrayList<Human>();
	public HashMap<Integer, Human> map;
	public int cnt;
	public String readFileName;
	
	private SingletonClass() {
		cnt = 0;
		map = new HashMap<Integer, Human>();
	}
	
	public static SingletonClass getInstance(){
		return singleton;
	}
	
	
}
