package com.sist.jdbc;

public class mainClass {

	public static void main(String[] args) {
		DeleteTest dt = new DeleteTest();
		
		int age = 24;
		
		int cnt = dt.delete(age);
		
		System.out.println(cnt + "명 탈퇴 성공!");

	}

}
