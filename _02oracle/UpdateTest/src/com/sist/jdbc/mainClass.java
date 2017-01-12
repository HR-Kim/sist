package com.sist.jdbc;

public class mainClass {

	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
		
		String id = "HongGD";
		int age = 26;
		
		int cnt = ut.update(id, age);
		System.out.println(cnt + "개 수정성공!");

	}

}
