package sutdaProject.DAO;

import java.util.ArrayList;

import sutdaProject.DTO.HumanClass;

public class SingletonClass {
	private static SingletonClass singleton = new SingletonClass(); 
	public ArrayList<HumanClass> list;
	public String readFileName;
	public int cnt;
	public HumanClass onGameHu;
	
	private SingletonClass() {
		readFileName = "sutda";
		cnt = 0;
	}
	
	public static SingletonClass getInstance(){
		return singleton;
	}
}
