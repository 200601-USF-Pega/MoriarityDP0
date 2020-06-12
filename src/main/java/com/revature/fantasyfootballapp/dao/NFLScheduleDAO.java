package com.revature.fantasyfootballapp.dao;

import java.util.List;

import com.revature.fantasyfootballapp.model.NFLSchedule;
import com.revature.fantasyfootballapp.model.NFLTeam;

public interface NFLScheduleDAO {

	public List<NFLSchedule> getWeek(int weekNumber);
	public NFLTeam getNextOpponent(int weekNumber, NFLTeam team);
	public List<NFLSchedule> getFullSchedule();
	public List<NFLSchedule> getRemainingSchedule(int currentWeek);
	public List<NFLSchedule> getScheduleForTeam(NFLTeam team);
}
