package DataAccessLoop;

import java.util.Iterator;
import java.util.Scanner;

import baseball.dto.Batter;
import baseball.dto.Human;
import baseball.dto.Pitcher;
import baseball.file.FileClass;

public class TeamIn {
	FileClass fc = new FileClass();
	
	public TeamIn() {}
	
	
	public void newTeamInsert() {
		//파일생성
		String fileName = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("추가할 팀의 이름을 입력하시오!");
		fileName = sc.next();
		fc.fileCreate(fileName);
		fc.filePrint();
	}
	
	public boolean TeamsRead(){
		SingletonClass singleton = SingletonClass.getInstance();
		singleton.readFileName = null;
		String[] temp;
		String[] split;
		Human hu_temp;
		Scanner sc = new Scanner(System.in);
		boolean readSuccess = false;
		//singleton.list.removeAll(singleton.list);
		singleton.map.clear();
		
		System.out.print("정보를 읽어올 팀의 이름을 입력하시오!");
		singleton.readFileName = sc.next();
		if(fc.checkBeforeReadFile(singleton.readFileName)){
			readSuccess = true;
			temp = fc.fileRead(singleton.readFileName);
			for(int i=0; i<temp.length; ++i){
				split = temp[i].split("-");
				if(split[1].equals("pitcher")){
					hu_temp = new Pitcher(Integer.parseInt(split[0]),
							split[1], split[2], split[3], Integer.parseInt(split[4]),
							Double.parseDouble(split[5]), Integer.parseInt(split[6]),
							Integer.parseInt(split[7]), Double.parseDouble(split[8]));
					singleton.map.put(Integer.parseInt(split[0]), hu_temp);
				}else{
					hu_temp = new Batter(Integer.parseInt(split[0]),
							split[1], split[2], split[3], Integer.parseInt(split[4]),
							Double.parseDouble(split[5]), Integer.parseInt(split[6]),
							Integer.parseInt(split[7]), Double.parseDouble(split[8]));
					singleton.map.put(Integer.parseInt(split[0]), hu_temp);
				}
				
			}
		}else{
			System.out.println("해당하는 팀이 존재하지 않습니다.");
			readSuccess = false;
		}
		
		return readSuccess;
	}
	
	public void updateFile(){
		SingletonClass singleton = SingletonClass.getInstance();
		
		Human hu;
		String[] temp = new String[singleton.map.size()];
		Iterator<Integer> itKey = singleton.map.keySet().iterator();
		int i= 0;
		while(itKey.hasNext()){
			int no = itKey.next();
			temp[i] = singleton.map.get(no).toString();
			i++;
		}
		fc.fileWrite(singleton.readFileName, temp);
		/*
		for(int i=0; i<singleton.list.size(); ++i){
			temp[i] = singleton.list.get(i).toString();
		}*/
	}
}
