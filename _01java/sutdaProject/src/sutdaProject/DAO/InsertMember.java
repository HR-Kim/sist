package sutdaProject.DAO;

import java.util.Scanner;

import sutdaProject.DTO.HumanClass;

public class InsertMember {
	HumanClass hu;
	public InsertMember() {
		hu = null;
	}
	
	public void insert(){
		SingletonClass singleton = SingletonClass.getInstance();
		Scanner sc = new Scanner(System.in);
		int no;
		int id;
		
		no = singleton.cnt + 1;
		
		
		boolean ch_id = true;
		while(ch_id){
			System.out.print("아이디를 입력하시오 : ");
			id = sc.nextInt();
			for(int i=0; i<singleton.list.size(); ++i){
				if(id == singleton.list.get(i).getId()){
					System.out.println("아이디 중복!!");
					continue;
				}else{
					hu.setId(id);
					ch_id = false;
					break;
				}
			}
		}
		
		System.out.print("패스워드를 입력하시오(숫자) :");
		hu.setPassword(sc.nextInt());
		
		System.out.print("이름을 입력하시오 : ");
		hu.setName(sc.next());
		
		System.out.print("나이를 입력하시오 : ");
		hu.setAge(sc.nextInt());
		
		hu.setNo(no);
		hu.setMoney(100000);
		
		singleton.list.add(hu);
	}
}
