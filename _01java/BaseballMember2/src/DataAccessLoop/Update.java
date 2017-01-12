package DataAccessLoop;

import java.util.Scanner;

import baseball.dto.Batter;
import baseball.dto.Human;
import baseball.dto.Pitcher;

public class Update {
	public Update() {}
	
	public void update() {
		Scanner sc = new Scanner(System.in);
		Select sel = new Select();
		SingletonClass singleton = SingletonClass.getInstance();
		
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
		
		seqNum = sel.select(name);
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
					height = sc.nextDouble();
					
					if(pos_num == 1){
						System.out.print("변경한 선수는 몇 승입니까? : ");
						win = sc.nextInt();
						
						System.out.print("변경한 선수는 몇 패입니까? : ");
						lose = sc.nextInt();
						
						System.out.print("변경한 선수의 방어율은 몇입니까? : ");
						era = sc.nextDouble();
						
						Human hu = new Pitcher(singleton.map.get(seqNum).getNo(), pos, name, birth, age, height, win, lose, era);
						singleton.map.put(seqNum, hu);
						
						break;
					}else if(pos_num == 2){
						System.out.print("변경한 선수의 타수는 몇입니까? : ");
						batCount = sc.nextInt();
						
						System.out.print("변경한 선수의 타점은 몇입니까? : ");
						hit = sc.nextInt();
						
						System.out.print("변경한 선수의 타율은 몇입니까? : ");
						hitAvg = sc.nextDouble();
						
						Human hu2 = new Batter(singleton.map.get(seqNum).getNo(), pos, name, birth, age, height, batCount, hit, hitAvg);
						singleton.map.put(seqNum, hu2);
						break;
					}
				}
			}
		}
	}
}
