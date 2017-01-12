package server;

import java.io.Serializable;

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
