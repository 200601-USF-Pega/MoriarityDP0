package com.revature.fantasyfootballapp.dao;

import java.util.List;

import com.revature.fantasyfootballapp.model.Injuries;
import com.revature.fantasyfootballapp.model.NFLSchedule;
import com.revature.fantasyfootballapp.model.NFLTeam;
import com.revature.fantasyfootballapp.model.Player;

public interface AdminDAO {

	public boolean updateInjury(Injuries injury);
	public boolean deleteFromIR(Injuries injury);
	public boolean updateWeek(List<NFLSchedule> week); 
	public boolean updateTeam(NFLTeam team);
	public boolean updatePlayer(Player player);
}
