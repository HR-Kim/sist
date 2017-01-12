package sutdaProject.DAO;

import java.util.Iterator;
import java.util.Scanner;


import sutdaProject.DTO.HumanClass;
import sutdaProject.File.FileClass;


public class Gamein {
	FileClass fc;
	
	public Gamein() {
		fc = new FileClass();
	}
	public boolean TeamsRead(){
		SingletonClass singleton = SingletonClass.getInstance();
		singleton.readFileName = null;
		String[] temp;
		String[] split;
		HumanClass hu_temp;
		Scanner sc = new Scanner(System.in);
		boolean readSuccess = false;
		//singleton.list.removeAll(singleton.list);
		singleton.list.removeAll(singleton.list);
		
		if(fc.checkBeforeReadFile(singleton.readFileName)){
			readSuccess = true;
			temp = fc.fileRead(singleton.readFileName);
			for(int i=0; i<temp.length; ++i){
				split = temp[i].split("-");
				
				hu_temp = new HumanClass(Integer.parseInt(split[0]),
						Integer.parseInt(split[1]), Integer.parseInt(split[2]),
						split[3], Integer.parseInt(split[4]), Integer.parseInt(split[5]));
				singleton.list.add(hu_temp);
			}
		}else{
			System.out.println("해당하는 파일이 존재하지 않습니다.");
			readSuccess = false;
		}
		
		return readSuccess;
	}
	
	public void updateFile(){
		SingletonClass singleton = SingletonClass.getInstance();
		
		HumanClass hu;
		String[] temp = new String[singleton.list.size()];
		/*
		Iterator<Integer> itKey = singleton.map.keySet().iterator();
		int i= 0;
		while(itKey.hasNext()){
			int no = itKey.next();
			temp[i] = singleton.map.get(no).toString();
			i++;
		}*/
		for(int i=0; i<singleton.list.size(); ++i){
			temp[i] = singleton.list.get(i).toString();
		}
		fc.fileWrite(singleton.readFileName, temp);
	}
}
