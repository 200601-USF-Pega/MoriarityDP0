package com.revature.fantasyfootballapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.fantasyfootballapp.model.User;

public class UserDAOImpl implements UserDAO{

	static Logger LOGGER = LogManager.getLogger();
	Connection connection = null;
	PreparedStatement stmt = null;
	@Override
	public User getUser(String username) {
		User user = new User();
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM USERS WHERE username=?");
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			} else {
				System.out.println("User does not exist!");
			}
			
		} catch (SQLException e) {
			LOGGER.debug("at getUser");
		}
		return user;	
	}

	@Override
	public boolean addUser(String username, String password) {
		// TODO Auto-generated method stub
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("INSERT INTO USERS VALUES (?, ?)");
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at addUser");
			return false;
		}
	}

	@Override
	public boolean deleteUser(User user) {
		// TODO Auto-generated method stub
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("DELETE FROM USERS WHERE username=? AND password=?");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at deleteUser");
			return false;
		}
	}

}
