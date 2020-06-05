package com.revature.fantasyfootballapp.dao;

import com.revature.fantasyfootballapp.model.NFLTeam;

public interface NFLTeamDAO {

	public NFLTeam getNFLTeam(String teamName);

	public void updateTeam(NFLTeam team); //admin only
}
