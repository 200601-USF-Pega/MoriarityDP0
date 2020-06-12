package com.revature.fantasyfootballapp.menu;

import java.util.List;
import java.util.Scanner;

import com.revature.fantasyfootballapp.dao.FantasyTeamDAO;
import com.revature.fantasyfootballapp.dao.FantasyTeamDAOImpl;
import com.revature.fantasyfootballapp.dao.InjuriesDAO;
import com.revature.fantasyfootballapp.dao.InjuriesDAOImpl;
import com.revature.fantasyfootballapp.dao.NFLScheduleDAO;
import com.revature.fantasyfootballapp.dao.NFLScheduleDAOImpl;
import com.revature.fantasyfootballapp.dao.NFLTeamDAO;
import com.revature.fantasyfootballapp.dao.NFLTeamDAOImpl;
import com.revature.fantasyfootballapp.dao.PlayerDAO;
import com.revature.fantasyfootballapp.dao.PlayerDAOImpl;
import com.revature.fantasyfootballapp.model.FantasyTeam;
import com.revature.fantasyfootballapp.model.Injuries;
import com.revature.fantasyfootballapp.model.NFLTeam;
import com.revature.fantasyfootballapp.model.Player;

public class UserMenu implements IMenu{

	@Override
	public void getMenu(Scanner sc, String user) {
		FantasyTeamDAO ftdb = new FantasyTeamDAOImpl();
		int choice = 0;
		while (choice != 5) {
			System.out.println("What would you like to do?");
			System.out.println("[0] Create a new Fantasy Team");
			System.out.println("[1] Update your lineup");
			System.out.println("[2] Search for a player");
			System.out.println("[3] Find a matchup");
			System.out.println("[4] Check IR");
			System.out.println("[5] Log Out");
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
				case 0: {
					FantasyTeam team = new FantasyTeam();
					boolean addedSuccessfully = false;;
					while (!addedSuccessfully) {
						team.setUser(user);
						System.out.println("Please select a QB: ");
						String qb = sc.nextLine();
						team.setQb(qb);
						System.out.println("Please select an RB1: ");
						String rb1 = sc.nextLine();
						team.setRb1(rb1);
						System.out.println("Please select an RB2: ");
						String rb2 = sc.nextLine();
						team.setRb2(rb2);
						System.out.println("Please select a WR1: ");
						String wr1 = sc.nextLine();
						team.setWr1(wr1);
						System.out.println("Please select a WR2: ");
						String wr2 = sc.nextLine();
						team.setWr2(wr2);
						System.out.println("Please select a TE: ");
						String te = sc.nextLine();
						team.setTe(te);
						System.out.println("Please select a FLEX: ");
						String flex = sc.nextLine();
						team.setFlex(flex);
						System.out.println("Please select a D/ST: ");
						String dst = sc.nextLine();
						team.setDSt(dst);
						System.out.println("Please select a K: ");
						String k = sc.nextLine();
						team.setK(k);
						addedSuccessfully = ftdb.makeNewFantasyTeam(team);
						if (addedSuccessfully == false) {
							System.out.println("Something went wrong. Please retry creating your team.");
						}
					}
					System.out.println("Team added successfully!");
					break;
				}
				case 1: {
					FantasyTeam team = ftdb.getFantasyTeam(user);
					System.out.println(team.toString());
					boolean replaced = false;
					while (!replaced) {
						System.out.println("What position would you like to drop?");
						String drop = sc.nextLine().toLowerCase();
						System.out.println("Please enter a player of the same position to add: ");
						String add = sc.nextLine();
						switch (drop) {
							case "qb" : {
								ftdb.replaceQB(user, add);
								replaced = true;
								break;
							} case "rb1" : {
								ftdb.replaceRB1(user, add);
								replaced = true;
								break;
							} case "rb2" : {
								ftdb.replaceRB2(user, add);
								replaced = true;
								break;
							} case "wr1" : {
								ftdb.replaceWR1(user, add);
								replaced = true;
								break;
							} case "wr2" : {
								ftdb.replaceWR2(user, add);
								replaced = true;
								break;
							} case "te" : {
								ftdb.replaceTE(user, add);
								replaced = true;
								break;
							} case "flex" : {
								ftdb.replaceFlex(user, add);
								replaced = true;
								break;
							} case "dst" : {
								ftdb.replaceDST(user, add);
								replaced = true;
								break;
							} case "k" : {
								ftdb.replaceK(user, add);
								replaced = true;
								break;
							} default : {
								System.out.println("Something went wrong. Please try again.");
							}
						}
					}
					System.out.println("Add/Drop successful!");
					break;	
				}
				case 2: {
					PlayerDAO players = new PlayerDAOImpl();
					int input = 0;
					while (input == 0) {
						System.out.println("Please type the name of the player you would like to search: ");
						String playerSearch = sc.nextLine();
						Player player = players.getPlayerByName(playerSearch);
						System.out.println(player.toString());
						
						System.out.println("What would you like to do?");
						System.out.println("[0] Search another player");
						System.out.println("[1] Return to user menu");
						input = Integer.parseInt(sc.nextLine());
						if (input == 1) {
							break;
						}
					}
					break;
				}
				
				case 3: {
					NFLScheduleDAO schedDb = new NFLScheduleDAOImpl();
					NFLTeamDAO teamDb = new NFLTeamDAOImpl();
					System.out.println("What week would you like to see?");
					int week = Integer.parseInt(sc.nextLine());
					System.out.println("What team are you searching for?");
					String teamName = sc.nextLine();
					NFLTeam team = teamDb.getNFLTeam(teamName);
					System.out.println(team.toString());
					System.out.println("vs"); 
					NFLTeam opponent = schedDb.getNextOpponent(week, team);
					System.out.println(opponent.toString());
					break;
				} 
				case 4: {
					InjuriesDAO irDb = new InjuriesDAOImpl();
					int input = 0;
					while (input != 2) {
						System.out.println("Would you like to: ");
						System.out.println("[0] see full IR");
						System.out.println("[1] find player on IR");
						System.out.println("[2] Return to user menu");
						input = Integer.parseInt(sc.nextLine());
						if (input == 0) {
							List<Injuries> ir = irDb.getIRList();
							for (Injuries injury : ir) {
								System.out.println(injury.toString());
							}
							System.out.println();
							System.out.println("[0] Return to user menu");
							System.out.println("[1] Log Out");
							input = Integer.parseInt(sc.nextLine());
							if (input == 0) {
								break;
							} else {
								IMenu mainMenu = new MainMenu();
								mainMenu.getMenu(sc, "login");
							}
						} else if (input == 1) {
							System.out.println("What player would you like to search for?");
							String playerName = sc.nextLine();
							Player player = new Player();
							player.setName(playerName);
							Injuries injury = irDb.getPlayerHealth(player);
							if (injury.getName() == null) {
								System.out.println("Player is not currently on IR");
							} else {
								System.out.println(injury.toString());
							}
							System.out.println();
							System.out.println("Would you like to continue on the IR Page? Y/N");
							char decision = Character.toLowerCase(sc.nextLine().charAt(0));
							if (decision == 'y') {
								input = 0;
							} else {
								input = 2;
							}
						} else {
							input = 2;
						}
					}
					break;
				}
				default: {
					choice = 5;
					break;
				}
			}
		}
	}
}
