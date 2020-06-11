package com.revature.fantasyfootballapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.fantasyfootballapp.model.NFLTeam;

public class NFLTeamDAOImpl implements NFLTeamDAO{

	static Logger LOGGER = LogManager.getLogger();
	Connection connection = null;
	PreparedStatement stmt = null;
	
	@Override
	public NFLTeam getNFLTeam(String teamName) {
		NFLTeam team = new NFLTeam();
		
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM NFL_TEAM_STATS WHERE team= ?");
			stmt.setString(1, teamName);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				team.setTeam(rs.getString("team"));
				team.setRecord(rs.getString("record"));
				team.setNextOpponent(rs.getString("next_opponent"));
				team.setOffensiveEfficiency(rs.getDouble("offensive_efficiency"));
				team.setDefensiveEfficiency(rs.getDouble("defensive_efficiency"));
			}
		} catch (SQLException e) {
			LOGGER.debug("at getNFLTeam");
		}
		
		return team;
	}
}
