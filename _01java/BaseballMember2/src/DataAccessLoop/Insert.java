package DataAccessLoop;

import java.util.Scanner;

import baseball.dto.Batter;
import baseball.dto.Human;
import baseball.dto.Pitcher;

public class Insert {
	public Insert() {	}
	
	public void insert(){
		SingletonClass singleton = SingletonClass.getInstance();
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
		
		pos_num=0;
		while(true){
			no = singleton.cnt+1;
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
			height = sc.nextDouble();
			
			if(pos_num == 1){
				System.out.print("선수는 몇 승입니까? : ");
				win = sc.nextInt();
				
				System.out.print("선수는 몇 패입니까? : ");
				lose = sc.nextInt();
				
				System.out.print("선수의 방어율은 몇입니까? : ");
				era = sc.nextDouble();
				
				Human hu = new Pitcher(no, pos, name, birth, age, height, win, lose, era);
				singleton.map.put(no,hu);
				singleton.cnt++;
				break;
			}else if(pos_num == 2){
				System.out.print("선수의 타수는 몇입니까? : ");
				batCount = sc.nextInt();
				
				System.out.print("선수의 타점은 몇입니까? : ");
				hit = sc.nextInt();
				
				System.out.print("선수의 타율은 몇입니까? : ");
				hitAvg = sc.nextDouble();
				
				Human hu2 = new Batter(no, pos, name, birth, age, height, batCount, hit, hitAvg);
				singleton.map.put(no, hu2);
				singleton.cnt++;
				break;
			}
	
		}
	}
}
