package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IMSConnection {
	
	//url, user, password
	private static final String DB_URL = "jdbc:mysql://34.76.73.3/ims?db_name&serverTimezome=UTC";
	private static String DB_USER;
	private static String DB_PASSWORD;
	
	private static IMSConnection instance;
	
	
	private IMSConnection(String username, String password) {
		IMSConnection.DB_USER = username;
		IMSConnection.DB_PASSWORD = password;
	}
	
	//method that lets you get connected to the db
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}

	//We have a private constructor, need something to access it
	public static IMSConnection connect(String DB_USER, String DB_PASSWORD) {
		if (instance == null){
			instance = new IMSConnection(DB_USER, DB_PASSWORD);
		}
		return instance;
	}
	
	// something to read through our executions
	//used for inserting,updating,and deleting
	public void executeUpdate(String query) throws SQLException {
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(query);
	}
	
	//to read from db
	//executeQuery - return 
	//table - ResultSet
	public ResultSet executeQuery(String query) throws SQLException {
		Connection con = getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
		
	}
	
	
	
	
}
