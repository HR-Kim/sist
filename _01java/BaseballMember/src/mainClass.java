import java.util.Scanner;

import baseball.dao.BaseBallDAO;
import baseball.dto.Batter;
import baseball.dto.Human;
import baseball.dto.InstanceofClass;
import baseball.dto.Pitcher;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Human py[] = new Human[5];
		
		py[0] = new Batter(1, "batter", "이대호", "820621", 34, 194, 292, 74, 0.253);
		py[1] = new Pitcher(2, "pitcher", "오승환", "820715", 34, 178, 6, 3, 1.92);
		py[2] = new Batter(3, "batter", "강정호", "870405", 29, 183, 318, 81, 0.255);
		py[3] = new Pitcher(4, "pitcher", "류현진", "870325", 29, 189, 0, 1, 11.57);
		py[4] = new Batter(5, "batter", "김현수", "880112", 28, 190, 305, 92, 0.302);
		
		for(int i=0; i<py.length; ++i){
			System.out.println(py[i].toString());
		}
		
		for(int i=0; i<py.length; ++i){
			new InstanceofClass(py[i]);
		}*/
		Scanner sc = new Scanner(System.in);
		BaseBallDAO dao = new BaseBallDAO();
		int menuCh1, menuCh2;
		String name;
		boolean con;
		boolean continu;
		boolean readSuccess = false;
		
		continu = con = true;
		menuCh2 = menuCh1 = 0;
		
		
		
		
		
		while(continu){
			readSuccess = false;
			System.out.println("----------------baseball team Info Management-----------------------");
			System.out.println("1 : 팀 추가 생성");
			System.out.println("2 : 팀 불러오기");
			System.out.println("3 : 종료!!");
			
			System.out.print("어느 작업을 할것인지 번호를 입력해주시오! :");
			menuCh2 = sc.nextInt();
			if(!(menuCh2 >= 1 && menuCh2 <= 3)) {
				System.out.println("1~3범위의 숫자를 입력하시오!!");
				continue;
			}
			
			switch(menuCh2){
			case 1:{
				dao.newTeamInsert();
				break;
			}
			case 2:{
				readSuccess = dao.TeamsRead();
				while(readSuccess){
					//어느 작업을 할것인지 번호를 입력해주시오!
					System.out.println("----------------baseball player Info Management-----------------------");
					System.out.println("1 : 선수 정보 추가");
					System.out.println("2 : 선수 정보 삭제");
					System.out.println("3 : 선수 정보 수정");
					System.out.println("4 : 원하는 선수 선택");
					System.out.println("5 : 전체 선수 정보 출력");
					System.out.println("6 : 종료!!");
					
					
					System.out.print("어느 작업을 할것인지 번호를 입력해주시오! :");
					menuCh1 = sc.nextInt();
					if(!(menuCh1 >= 1 && menuCh1 <= 6)) {
						System.out.println("1~6범위의 숫자를 입력하시오!!");
						continue;
					}
					
					switch(menuCh1){
						case 1 : {
							dao.insert();
							break;
						}case 2 : {
							dao.delete();
							break;
						}case 3 : {
							dao.update();
							break;
						}case 4 : {
							System.out.println("검색하고자 하는 선수의 이름을 입력하시오!");
							name = sc.next();
							dao.select(name);
							break;
						}case 5 : {
							dao.print();
							break;
						}case 6 : {
							System.out.println("종료 하겠습니다. ~~");
							dao.updateFile();
							readSuccess = false;
							break;
						}default:
					}
				}
				break;
			}
			case 3:{
				System.out.println("종료 하겠습니다. ~~");
				continu = false;
				break;
			}
			}
		}
		
		
		
		
		
	}

}
