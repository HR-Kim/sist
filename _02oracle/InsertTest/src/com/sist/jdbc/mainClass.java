package com.sist.jdbc;

import java.sql.Connection;

public class mainClass {

	public static void main(String[] args) {
		InsertTest it = new InsertTest();
	
		String id = "JoYH";
		String name = "조윤행";
		int age = 24;
		
		int cnt = it.insert(id, name, age);
		System.out.println(cnt + "개 입력 성공!!");
	}

}
