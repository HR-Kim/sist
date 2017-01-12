package baseball.dao;


import java.util.ArrayList;
import java.util.Scanner;

import baseball.dto.Batter;
import baseball.dto.Human;
import baseball.dto.Pitcher;
import baseball.file.FileClass;

public class BaseBallDAO {
	FileClass fc = new FileClass();
	int cnt;
	String readFileName;
	
	// 배열
	ArrayList<Human> list;
	
	public BaseBallDAO() {
		cnt = 0;
		list = new ArrayList<Human>();
		Human human = new Pitcher(1, "pitcher", "류현진", "890213", 28, 185, 20, 5, 1.21);
		list.add(human);
		Human human2 = new Batter(2, "batter", "이대호", "870224", 30, 190, 250, 100, 0.4);
		list.add(human2);
	}
	
	
	public void newTeamInsert() {
		//파일생성
		String fileName = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("추가할 팀의 이름을 입력하시오!");
		fileName = sc.next();
		fc.fileCreate(fileName);
		fc.filePrint();
	}
	
	public boolean TeamsRead() {
		//파일읽어오기
		readFileName = null;
		String[] temp;
		String[] split;
		Human hu_temp;
		Scanner sc = new Scanner(System.in);
		boolean readSuccess = false;
		list.removeAll(list);
		
		System.out.print("정보를 읽어올 팀의 이름을 입력하시오!");
		readFileName = sc.next();
		if(fc.checkBeforeReadFile(readFileName)){
			readSuccess = true;
			temp = fc.fileRead(readFileName);
			for(int i=0; i<temp.length; ++i){
				split = temp[i].split("-");
				if(split[1].equals("pitcher")){
					hu_temp = new Pitcher(Integer.parseInt(split[0]),
							split[1], split[2], split[3], Integer.parseInt(split[4]),
							Double.parseDouble(split[5]), Integer.parseInt(split[6]),
							Integer.parseInt(split[7]), Double.parseDouble(split[8]));
					list.add(hu_temp);
				}else{
					hu_temp = new Batter(Integer.parseInt(split[0]),
							split[1], split[2], split[3], Integer.parseInt(split[4]),
							Double.parseDouble(split[5]), Integer.parseInt(split[6]),
							Integer.parseInt(split[7]), Double.parseDouble(split[8]));
					list.add(hu_temp);
				}
				
			}
		}else{
			System.out.println("해당하는 팀이 존재하지 않습니다.");
			readSuccess = false;
		}
		
		
		
		
		
		return readSuccess;
	}
	
	// Data Access Object
	// 작업을 총괄하는 클래스
	public void insert() {
		Scanner sc = new Scanner(System.in);
		
		//////////humanInfo
		int no;
		String pos;
		int pos_num;
		String name;
		String birth;
		int age;
		double height;
		//////////pitcherInfo
		int win;
		int lose;
		double era;
		//////////batterInfo
		int batCount;
		int hit;
		double hitAvg;
		if(list.size() !=0) cnt = list.get(list.size()-1).getNo();
		
		pos_num=0;
		while(true){
			no = cnt+1;
			System.out.print("추가할 선수의 포지션은 무엇입니까?(1- pitcher / 2- batter) : ");
			pos_num = sc.nextInt();
			if(pos_num == 1){
				pos = "pitcher";
			}else if(pos_num == 2){
				pos = "batter";
			}else{
				System.out.println("1과 2 중에서 선택하시오!");
				continue;
			}
			
			System.out.print("추가할 선수의 이름을 입력하시오 : ");
			name = sc.next();
			
			System.out.print("추가할 선수의 생일을 입력하시오(ex-161115) : ");
			birth = sc.next();
			
			System.out.print("추가할 선수의 나이를 입력하시오 : ");
			age = sc.nextInt();
			
			System.out.print("추가할 선수의 키를 입력하시오 : ");
			height = sc.nextInt();
			
			if(pos_num == 1){
				System.out.print("선수는 몇 승입니까? : ");
				win = sc.nextInt();
				
				System.out.print("선수는 몇 패입니까? : ");
				lose = sc.nextInt();
				
				System.out.print("선수의 방어율은 몇입니까? : ");
				era = sc.nextDouble();
				
				Human hu = new Pitcher(no, pos, name, birth, age, height, win, lose, era);
				list.add(hu);
				cnt++;
				break;
			}else if(pos_num == 2){
				System.out.print("선수의 타수는 몇입니까? : ");
				batCount = sc.nextInt();
				
				System.out.print("선수의 타점은 몇입니까? : ");
				hit = sc.nextInt();
				
				System.out.print("선수의 타율은 몇입니까? : ");
				hitAvg = sc.nextDouble();
				
				Human hu2 = new Batter(no, pos, name, birth, age, height, batCount, hit, hitAvg);
				list.add(hu2);
				cnt++;
				break;
			}
	
		}
		
		
	}
	
	public void delete() {
		Scanner sc = new Scanner(System.in);
		String name;
		int seqNum=-1;
		
		System.out.print("삭제하고 싶은 선수의 이름을 입력하시오 : ");
		name = sc.next();
		name = name.replace(" ", "");
		
		seqNum = this.select(name);
		
		if(seqNum != -1){
			list.remove(seqNum);
			System.out.println("삭제 완료!!");
		}
		
	}
	
	public void update() {
		Scanner sc = new Scanner(System.in);
		String name;
		int seqNum = -1;
		//////////humanInfo
		int no;
		String pos;
		int pos_num;
		String birth;
		int age;
		double height;
		//////////pitcherInfo
		int win;
		int lose;
		double era;
		//////////batterInfo
		int batCount;
		int hit;
		double hitAvg;
		
		System.out.print("수정하고 싶은 선수의 이름을 입력하시오 : ");
		name = sc.next();
		name = name.replace(" ", "");
		
		seqNum = this.select(name);
		if(seqNum != -1){
			while(true){
				if(seqNum != -1){
					System.out.print("변경할 선수의 포지션은 무엇입니까?(1- pitcher / 2- batter) : ");
					pos_num = sc.nextInt();
					if(pos_num == 1){
						pos = "pitcher";
					}else if(pos_num == 2){
						pos = "batter";
					}else{
						System.out.println("1과 2 중에서 선택하시오!");
						continue;
					}
					
					System.out.print("변경할 선수의 이름을 입력하시오 : ");
					name = sc.next();
					
					System.out.print("변경할 선수의 생일을 입력하시오(ex-161115) : ");
					birth = sc.next();
					
					System.out.print("변경할 선수의 나이를 입력하시오 : ");
					age = sc.nextInt();
					
					System.out.print("변경할 선수의 키를 입력하시오 : ");
					height = sc.nextInt();
					
					if(pos_num == 1){
						System.out.print("변경한 선수는 몇 승입니까? : ");
						win = sc.nextInt();
						
						System.out.print("변경한 선수는 몇 패입니까? : ");
						lose = sc.nextInt();
						
						System.out.print("변경한 선수의 방어율은 몇입니까? : ");
						era = sc.nextDouble();
						
						Human hu = new Pitcher(list.get(seqNum).getNo(), pos, name, birth, age, height, win, lose, era);
						list.set(seqNum, hu);
						cnt++;
						break;
					}else if(pos_num == 2){
						System.out.print("변경한 선수의 타수는 몇입니까? : ");
						batCount = sc.nextInt();
						
						System.out.print("변경한 선수의 타점은 몇입니까? : ");
						hit = sc.nextInt();
						
						System.out.print("변경한 선수의 타율은 몇입니까? : ");
						hitAvg = sc.nextDouble();
						
						Human hu2 = new Batter(list.get(seqNum).getNo(), pos, name, birth, age, height, batCount, hit, hitAvg);
						list.set(seqNum, hu2);
						cnt++;
						break;
					}
				}
			}
		}
		
	}
	public void updateFile(){
		String[] temp = new String[list.size()];
		for(int i=0; i<list.size(); ++i){
			temp[i] = list.get(i).toString();
		}
		fc.fileWrite(readFileName, temp);
	}
	
	public int select(String name) {
		
		int seqNum = -1;
		Human hu;
		
		for(int i = 0; i<list.size(); ++i){
			hu = list.get(i);
			if(hu.getName().equals(name)){
				seqNum = i;
			}
		}
		if(seqNum != -1){
			hu = list.get(seqNum);
			System.out.println(hu.toString());
			return seqNum;
		}else{
			System.out.println("해당 선수의 이름은 존재하지않습니다.");
			return seqNum;
		}
		
	}
	
	public void print() {
		for(int i=0; i<list.size(); ++i){
			Human hu = list.get(i);
			System.out.println(hu.toString());
		}
	}
	
	
	/*
	 * 추가
	 * 
	 * 삭제
	 * 
	 * 수정
	 * 
	 * 검색
	 * 
	 * 출력
	 * 
	 * 
	 * 
	 */
}
