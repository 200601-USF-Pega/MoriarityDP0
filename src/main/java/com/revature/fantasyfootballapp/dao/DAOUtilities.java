package com.revature.fantasyfootballapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DAOUtilities {

	private static final String CONNECTION_USERNAME = "postgres";
	private static final String CONNECTION_PASSWORD = "Aubreenoel";
	private static final String URL = "jdbc:postgresql://localhost:5432/fantasy_predictor";
	
	private static UserDAOImpl userDAOImpl;
	private static Connection connection;
	
	public static synchronized UserDAO getUserDAO() {
		if (userDAOImpl == null) {
			userDAOImpl = new UserDAOImpl();
		}
		return userDAOImpl;
	}
	
	public static synchronized Connection getConnection() throws SQLException {
		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Could not register driver!");
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		
		//If connection was closed then retrieve a new connection
		if (connection.isClosed()){
			System.out.println("Opening new connection...");
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		return connection;
	}
}
