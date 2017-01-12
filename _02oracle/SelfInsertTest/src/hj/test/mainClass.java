package hj.test;

import hj.test.dto.HjDto;

public class mainClass {

	public static void main(String[] args) {
		HjInsertTest ht = new HjInsertTest();
		
		String id = "BaeHJ";
		
		HjDto dto = ht.search(id);
		if(dto != null){
			System.out.println("id:" + dto.getId());
			System.out.println("이름:" + dto.getName());
			System.out.println("나이:" + dto.getAge());
			System.out.println("가입일:" + dto.getDate());
		}else{
			System.out.println(id + "님은 존재하지 않습니다." );
		}

	}

}
