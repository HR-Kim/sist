package DataAccessLoop;

import java.util.Scanner;

public class Delete {
	public Delete() {}
	
	
	public void delete(){
		SingletonClass singleton = SingletonClass.getInstance();
		Select sel = new Select();
		Scanner sc = new Scanner(System.in);
		String name;
		int seqNum=-1;
		
		System.out.print("삭제하고 싶은 선수의 이름을 입력하시오 : ");
		name = sc.next();
		name = name.replace(" ", "");
		
		seqNum = sel.select(name);
		
		if(seqNum != -1){
			singleton.map.remove(seqNum);
			System.out.println("삭제 완료!!");
		}
	}
}
