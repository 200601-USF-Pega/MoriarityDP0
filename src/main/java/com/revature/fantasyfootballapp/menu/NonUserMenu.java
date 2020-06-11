package com.revature.fantasyfootballapp.menu;

import java.util.Scanner;

import com.revature.fantasyfootballapp.dao.UserDAO;
import com.revature.fantasyfootballapp.dao.UserDAOImpl;

public class NonUserMenu implements IMenu{

	@Override
	public void getMenu(Scanner sc, String user) {
		IMenu currentMenu;
		MenuFactory factory = new MenuFactory();
		UserDAO createUser = new UserDAOImpl();
		System.out.println("Welcome! Please select the username"
				+ " you would like to use: ");
		String username = sc.nextLine();
		System.out.println("Please type your new password: ");
		String password = sc.nextLine();
		while (!(createUser.addUser(username, password))) {
			System.out.println("ERROR: User already exists. Please use "
					+ "a different username: ");
			username = sc.nextLine();
			System.out.println("Please type your new password: ");
			password = sc.nextLine();
		}
		System.out.println("Account created successfully!");
		currentMenu = factory.changeMenu("User");
		currentMenu.getMenu(sc, username);
	}
}
