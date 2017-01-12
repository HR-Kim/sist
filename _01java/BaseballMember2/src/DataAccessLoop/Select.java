package DataAccessLoop;

import java.util.Iterator;

import baseball.dto.Human;


public class Select {
	public Select() {
		// TODO Auto-generated constructor stub
	}
	
	public int select(String name) {
		SingletonClass singleton = SingletonClass.getInstance();
		
		int seqNum = -1;
		Human hu;
		/*
		for(int i = 0; i<singleton.list.size(); ++i){
			hu = singleton.list.get(i);
			if(hu.getName().equals(name)){
				seqNum = i;
			}
		}*/
		
		Iterator<Integer> itKey = singleton.map.keySet().iterator();
		while(itKey.hasNext()){
			
			int no = itKey.next();
			hu = singleton.map.get(no);
			if(hu.getName().equals(name)){
				seqNum = no;
			}
		}
		
		if(seqNum != -1){
			hu = singleton.map.get(seqNum);
			System.out.println(hu.toString());
			return seqNum;
		}else{
			System.out.println("해당 선수의 이름은 존재하지않습니다.");
			return seqNum;
		}
	}
}
