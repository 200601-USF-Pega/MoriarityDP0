package com.revature.fantasyfootballapp.menu;

public class MenuFactory {

	public IMenu changeMenu(String userType) {
		IMenu newMenu;
		
		switch(userType) {
			case "MainMenu": {
				newMenu = new MainMenu();
				return newMenu;
			}
			case "User": {
				newMenu = new UserMenu();
				return newMenu;
			}
			case "Admin": {
				newMenu = new AdminMenu();
				return newMenu;
			}
			case "NonUser": {
				newMenu = new NonUserMenu();
				return newMenu;
			}
			default:
				System.out.println("Error: something went wrong. Please relaunch the program");
				System.exit(0);
				return null;
		}
		
	}
}
