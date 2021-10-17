package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String URLB = "database-1.cpqgxx3t8nlb.us-east-2.rds.amazonaws.com";
	private static final String dbLocation = "localhost";
	private static final String URL= "jdbc:postgresql://" + URLB+ "/postgres";
	private static final String URSERNAME= "postgres";
	private static final String PASSWORD= "jabdulla";
	
	public Connection getConnection() throws SQLException {
		
		Connection con = DriverManager.getConnection(URL, URSERNAME, PASSWORD);
				return con;
		
	}
}
