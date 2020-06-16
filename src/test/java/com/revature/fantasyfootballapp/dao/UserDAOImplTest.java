package com.revature.fantasyfootballapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.fantasyfootballapp.model.User;

class UserDAOImplTest {

	UserDAO testInstance = new UserDAOImpl();
	User dummyUser = new User("username", "password");
	
	@Test
	void addUserTest() {
		assertTrue(this.testInstance.addUser(this.dummyUser.getUsername(), this.dummyUser.getPassword()));
	}
	
	@Test
	void getUserTest() {
		User getDummy = this.testInstance.getUser(this.dummyUser.getUsername());
		assertEquals(getDummy.getUsername(), "username");
		assertEquals(getDummy.getPassword(), "password");
	}
	
	

	@Test
	void deleteUserTest() {
		assertTrue(this.testInstance.deleteUser(dummyUser));
	}
}
