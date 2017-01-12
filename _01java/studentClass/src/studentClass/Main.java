package studentClass;

import java.util.Scanner;

import studentClass.dao.ClassDAO;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ClassDAO dao = new ClassDAO();
		int menuCh;
		boolean con;
		
		con = true;
		menuCh = 0;
		
		System.out.println("----------------student Info Management-----------------------");
		
		
		while(con){
			System.out.println("1 : 학생 정보 추가");
			System.out.println("2 : 학생 정보 삭제");
			System.out.println("3 : 학생 정보 수정");
			System.out.println("4 : 원하는 학생 선택");
			System.out.println("5 : 전체 학생 정보 출력");
			System.out.println("6 : 학생 성적 기입");
			System.out.println("7 : 학생 성적 관련 조회!!");
			System.out.println("8 : 종료!!");
			//어느 작업을 할것인지 번호를 입력해주시오!
			System.out.print("어느 작업을 할것인지 번호를 입력해주시오! :");
			menuCh = sc.nextInt();
			if(!(menuCh >= 1 && menuCh <= 8)) {
				System.out.println("1~8범위의 숫자를 입력하시오!!");
				continue;
			}
			
			switch(menuCh){
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
					dao.select();
					break;
				}case 5 : {
					dao.print();
					break;
				}case 6 : {
					dao.gradeManage();
					break;
				}case 7 : {
					dao.avg();
					dao.sum();
					dao.engAvg();
					dao.korAvg();
					dao.mathTop();
					dao.bestOfTheBase();
					
					break;
				}case 8 : {
					System.out.println("종료 하겠습니다. ~~");
					con = false;
					break;
				}default:
			}
		}
	}
}
