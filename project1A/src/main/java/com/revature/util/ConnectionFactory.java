package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL= "jdbc:postgresql://localhost/postgres";
	private static final String URSERNAME= "postgres";
	private static final String PASSWORD= "jabdulla";
	
	public Connection getConnection() throws SQLException {
		
		Connection con = DriverManager.getConnection(URL, URSERNAME, PASSWORD);
				return con;
		
	}
}
