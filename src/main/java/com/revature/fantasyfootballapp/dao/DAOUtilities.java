package com.revature.fantasyfootballapp.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DAOUtilities {

	

	
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
			try {
				FileInputStream fis = new FileInputStream("connection.prop");
				Properties p = new Properties();
				p.load(fis);
				connection = DriverManager.getConnection(p.getProperty("URL"), p.getProperty("USERNAME"), p.getProperty("PASSWORD"));
			} catch (IOException e) {
				System.out.println("Could not get connection!");
				System.out.println(e.getMessage());
			}
			
		}
		
		if (connection.isClosed()) {
			try {
				FileInputStream fis = new FileInputStream("connection.prop");
				Properties p = new Properties();
				p.load(fis);
				connection = DriverManager.getConnection(p.getProperty("URL"), p.getProperty("USERNAME"), p.getProperty("PASSWORD"));
			} catch (IOException e) {
				System.out.println("Could not get connection!");
				System.out.println(e.getMessage());
			}
		}
		return connection;
	}
}
