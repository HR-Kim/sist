package com.sist.jdbc;

import java.sql.Connection;

public class mainClass {

	public static void main(String[] args) {
		/*
		 * Java DataBase Connectivity
		 * 
		 */
		ConnectionTest ct = new ConnectionTest();
		Connection conn = ct.makeConnection();
	}

}
