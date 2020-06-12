package com.revature.fantasyfootballapp.driver;

import java.util.Scanner;
import org.apache.logging.log4j.*;
import com.revature.fantasyfootballapp.menu.IMenu;
import com.revature.fantasyfootballapp.menu.MainMenu;

public class Driver {
	
	static Logger LOGGER = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		IMenu menu = new MainMenu();
		menu.getMenu(sc, "login");
		sc.close();
	}

}
