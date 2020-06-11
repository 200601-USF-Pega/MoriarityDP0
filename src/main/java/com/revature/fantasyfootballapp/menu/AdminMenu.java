package com.revature.fantasyfootballapp.menu;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.fantasyfootballapp.dao.AdminDAO;
import com.revature.fantasyfootballapp.dao.AdminDAOImpl;
import com.revature.fantasyfootballapp.dao.NFLScheduleDAO;
import com.revature.fantasyfootballapp.dao.NFLScheduleDAOImpl;
import com.revature.fantasyfootballapp.dao.NFLTeamDAO;
import com.revature.fantasyfootballapp.dao.NFLTeamDAOImpl;
import com.revature.fantasyfootballapp.model.Injuries;
import com.revature.fantasyfootballapp.model.NFLSchedule;
import com.revature.fantasyfootballapp.model.NFLTeam;

public class AdminMenu implements IMenu{

	private static final Logger LOGGER = LogManager.getLogger();
	
	@Override
	public void getMenu(Scanner sc, String user) {
		AdminDAO adminDb = new AdminDAOImpl();
		int choice = 0;
		do {
			System.out.println("Welcome admin. What would you like to do?");
			System.out.println("[0] Update an injury?");
			System.out.println("[1] Update scores?");
			System.out.println("[2] Update team records?");
			System.out.println("[3] Log Out");
			choice = Integer.parseInt(sc.nextLine());
			if (choice == 0) {
				Injuries update = new Injuries();
				System.out.println("Player name: ");
				update.setName(sc.nextLine());
				System.out.println("New health status: ");
				update.setHealthStatus(sc.nextLine().charAt(0));
				System.out.println("Injury: ");
				update.setInjury(sc.nextLine());
				System.out.println("Updated week to return: ");
				update.setWeekToReturn(Integer.parseInt(sc.nextLine()));
				if (update.getHealthStatus() == 'H') {
					boolean delete = adminDb.deleteFromIR(update);
					if (delete) {
						System.out.println("Healthy player deleted from IR!");
					} else {
						System.out.println("IR could not be updated");
					}
				} else {
					boolean change = adminDb.updateInjury(update);
					if (change) {
						System.out.println("Injury successfully updated!");
					} else {
						System.out.println("IR could not be updated");
					}
				}
			} else if (choice == 1) {
				boolean done = false;
				while (!done) {
				System.out.println("What week would you like to update?");
				int weekNumber = Integer.parseInt(sc.nextLine());
				NFLScheduleDAO scheduleDb = new NFLScheduleDAOImpl();
				List<NFLSchedule> week = scheduleDb.getWeek(weekNumber);
				
					for (NFLSchedule game : week) {
							System.out.println(game.toString());
					}
					System.out.println();
					System.out.println("Please type the name of one of the teams in the"
							+ " matchup you'd like to update or type done to exit: ");
					String matchup = sc.nextLine();
					if (matchup.equals("done")) {
						break;
					}
					System.out.println("Please enter the result of this game for the above team: ");
					String result = sc.nextLine();
					// each matchup appears twice per week, so two update stmts are necessary
					NFLSchedule gameTeam = new NFLSchedule(); 
					gameTeam.setTeam(matchup);
					gameTeam.setWeek(weekNumber);
					gameTeam.setResult(result);
					adminDb.updateGame(gameTeam);
					NFLTeam team1 = new NFLTeam();
					team1.setTeam(gameTeam.getTeam());
					NFLSchedule gameOpponent = new NFLSchedule();
					String findOtherTeam = scheduleDb.getNextOpponent(weekNumber, team1);
					gameOpponent.setTeam(findOtherTeam);
					gameOpponent.setWeek(weekNumber);
					String newResult;
					if (result.contains("W")) {
						newResult = "L " + result.substring(2);
					} else if (result.contains("L")) {
						newResult = "W " + result.substring(2);
					} else {
						newResult = result;
					}
					gameOpponent.setResult(newResult);
					adminDb.updateGame(gameOpponent);
					if (week.size() == 0) {
						done = true;
					}
				}
			} else if (choice == 2) {
				boolean done = false;
				while (!done) {
					System.out.println("What team would you like to update? (Type done to quit)");
					String teamName = sc.nextLine();
					if (teamName.equals("done")) {
						break;
					}
					NFLTeamDAO teamDb = new NFLTeamDAOImpl();
					NFLTeam team = new NFLTeam();
					team.setTeam(teamName);
					System.out.println("What is their record?");
					String record = sc.nextLine();
					team.setRecord(record);
					boolean success = adminDb.updateTeam(team);
					if (success) {
						System.out.println("Team record updated successfully!");
					} else {
						System.out.println("Something went wrong. Please try another update.");
					}
				}
				
			}
		} while (choice != 3);
		
		
		
	}
}
