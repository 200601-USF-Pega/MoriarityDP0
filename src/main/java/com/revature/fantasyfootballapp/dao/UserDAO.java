package com.revature.fantasyfootballapp.dao;

import com.revature.fantasyfootballapp.model.User;

public interface UserDAO {

	public User getUser(String username);
	public boolean addUser(String username, String password);
	public boolean deleteUser(User user); 
}
