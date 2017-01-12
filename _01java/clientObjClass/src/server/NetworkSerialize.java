package server;

import java.io.Serializable;

/*
 * Serializable : 직렬화
 * 
 * int char double boolean -> 크기 일정
 * 
 * 파일작성하는 경우, 네트워크 전송
 * 
 * 
 * 
 * 
 */




public class NetworkSerialize implements Serializable{
	private int num;
	private String name;

	public NetworkSerialize(int n, String s) {
		num = n;
		name = s;
	}

	@Override
	public String toString() {
		return "NetworkSerialize [num=" + num + ", name=" + name + "]";
	}
	
	
}
