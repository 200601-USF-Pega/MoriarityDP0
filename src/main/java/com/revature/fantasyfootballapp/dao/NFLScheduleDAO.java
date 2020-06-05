package com.revature.fantasyfootballapp.dao;

import java.util.List;

import com.revature.fantasyfootballapp.model.NFLSchedule;
import com.revature.fantasyfootballapp.model.NFLTeam;

public interface NFLScheduleDAO {

	public NFLSchedule getWeek(int weekNumber);
	public NFLSchedule getNextOpponent(int weekNumber, NFLTeam team);
	public List<NFLSchedule> getFullSchedule();
	public List<NFLSchedule> getRemainingSchedule();
	public List<NFLSchedule> getScheduleForTeam(NFLTeam team);
	
	public void updateWeek(NFLSchedule week); //admin only 
}
