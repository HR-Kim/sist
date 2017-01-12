package sutdaProject.DAO;

import java.util.Scanner;

import sutdaProject.DTO.HumanClass;

public class LoginClass {
	public LoginClass() {
		// TODO Auto-generated constructor stub
	}
	
	public HumanClass login(){
		SingletonClass singleton = SingletonClass.getInstance();
		HumanClass hu = null;
		Scanner sc = new Scanner(System.in);
		int id;
		int pw;
		boolean ex_id;
		
		
		
suc :   while(true){
			ex_id = false;
			System.out.print("로그인 할 아이디를 입력하시오 : ");
			id = sc.nextInt();
			System.out.print("로그인 할 패스워드를 입력하시오 : ");
			pw = sc.nextInt();
			for(int i=0; i<singleton.list.size(); ++i){
				if(id == singleton.list.get(i).getId()){
					ex_id = true;
					if(pw == singleton.list.get(i).getPassword()){
						System.out.println("로그인 성공!!");
						hu = singleton.list.get(i);
						break suc;
					}else{
						System.out.println("패스워드 불일치!!");
						break suc;
					}
					
				}
			}
			if(!ex_id) System.out.println("해당 아이디는 존재하지 않습니다.");
			break;
		}
		
		
		
		
		return hu;
	}
}
