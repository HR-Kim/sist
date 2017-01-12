package DataAccessLoop;

import java.util.Iterator;

import baseball.dto.Human;

public class Print {
	public Print() {}
	
	public void print() {
		SingletonClass singleton = SingletonClass.getInstance();
		Human hu;
		Iterator<Integer> itKey = singleton.map.keySet().iterator();
		
		while(itKey.hasNext()){
			int no = itKey.next();
			hu = singleton.map.get(no);
			System.out.println(hu.toString());
		}
		/*
		for(int i=0; i<singleton.list.size(); ++i){
			Human hu = singleton.list.get(i);
			System.out.println(hu.toString());
		}*/
	}
}
