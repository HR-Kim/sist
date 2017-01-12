package com.sist.jdbc;

import java.util.List;

import com.sist.jdbc.dto.UserDto;

public class mainClass {

	public static void main(String[] args) {
		SelectTest st = new SelectTest();
		
		String id = "RONALDO";
		System.out.println(id + "님 검색결과 ->");
		
		UserDto dto = st.search(id);
		
		if(dto != null){
			System.out.println("id:" + dto.getId());
			System.out.println("이름:" + dto.getName());
			System.out.println("나이:" + dto.getAge());
			System.out.println("가입일:" + dto.getJoinDate());
		}else{
			System.out.println(id + "님은 존재하지 않습니다." );
		}
		
		System.out.println("--------------모든 정보 목록--------------");
		System.out.println("이름\t아이디\t나이\t가입일");
		System.out.println("------------------------------------");
		
		List<UserDto> list = st.getList();
		
		for(UserDto d : list){
			System.out.println(d.getName() + "\t" + d.getId() + "\t" + d.getAge() + "\t" + d.getJoinDate());
		}
	}

}








