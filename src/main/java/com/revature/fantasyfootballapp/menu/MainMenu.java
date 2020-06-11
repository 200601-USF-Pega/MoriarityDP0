package com.revature.fantasyfootballapp.menu;

import java.util.Scanner;

import com.revature.fantasyfootballapp.dao.UserDAO;
import com.revature.fantasyfootballapp.dao.UserDAOImpl;
import com.revature.fantasyfootballapp.model.User;

public class MainMenu implements IMenu{

	@Override
	public void getMenu(Scanner sc, String user) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		MenuFactory factory = new MenuFactory();
		IMenu currentMenu;
		UserDAO checkUser = new UserDAOImpl();
		
		while (true) {
			System.out.println("Welcome to the Fantasy Football App!");
			System.out.println("Please choose an option:");
			System.out.println("[0] Log In");
			System.out.println("[1] Create account");
			System.out.println("[2] Exit");
			String choice = sc.nextLine();
			
			switch (choice) {
				case "0": {
					System.out.println("Please enter your username: ");
					String username = sc.nextLine();
					System.out.println("Please enter your password: ");
					String password = sc.nextLine();
					User authenticate = checkUser.getUser(username);
					while (!authenticate.getPassword().equals(password)) {
						System.out.println("ERROR: Incorrect password."
								+ " Please retype your password!");
						password = sc.nextLine();
					}
					
					if (username.equals("admin")) {
						currentMenu = factory.changeMenu("Admin");
						currentMenu.getMenu(sc, authenticate.getUsername());
						break;
					} else {
						currentMenu = factory.changeMenu("User");
						currentMenu.getMenu(sc, authenticate.getUsername());
						break;
					}
				} case "1": {
					currentMenu = factory.changeMenu("NonUser");
					currentMenu.getMenu(sc, "new user");
					break;
				}default : {
					System.out.println("Goodbye!");
					System.exit(0);
				}
			}
		}
		
	}
}
