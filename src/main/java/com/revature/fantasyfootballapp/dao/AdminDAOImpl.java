package com.revature.fantasyfootballapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.fantasyfootballapp.model.Injuries;
import com.revature.fantasyfootballapp.model.NFLSchedule;
import com.revature.fantasyfootballapp.model.NFLTeam;
import com.revature.fantasyfootballapp.model.Player;

public class AdminDAOImpl implements AdminDAO{

	Connection connection = null;
	PreparedStatement stmt = null;
	
	@Override
	public boolean updateInjury(Injuries injury) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE INJURIES SET health_status=?, injury=?, week_to_return=? WHERE name=?");
			stmt.setString(1, String.valueOf(injury.getHealthStatus()));
			stmt.setString(2, injury.getInjury());
			stmt.setInt(3, injury.getWeekToReturn());
			stmt.setString(4, injury.getName());
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Could not complete transaction!");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteFromIR(Injuries injury) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("DELETE FROM INJURIES WHERE name=?");
			stmt.setString(1, injury.getName());
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Could not complete transaction!");
			e.printStackTrace();
			return false;
		}
	}

	//check implementation
	@Override
	public boolean updateWeek(List<NFLSchedule> week) {
		try {
			connection = DAOUtilities.getConnection();
			for (int k = 0; k < week.size(); k++) {
				NFLSchedule game = week.remove(k);
				stmt = connection.prepareStatement("UPDATE NFL_SCHEDULE SET result=? WHERE week=? AND team=?");
				stmt.setString(1, game.getResult());
				stmt.setInt(2, game.getWeek());
				stmt.setString(3, game.getTeam());
				if (stmt.executeUpdate() == 0) {
					return false;
				}
			}
			return true;
		} catch (SQLException e) {
			System.out.println("Could not complete transaction!");
			e.printStackTrace();
			return false;
		}		
	}

	@Override
	public boolean updateTeam(NFLTeam team) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE NFL_TEAM_STATS SET record=?, next_opponent=?,"
					+ " offensive_efficiency=?, defensive_efficiency=? WHERE team=?");
			stmt.setString(1, team.getRecord());
			stmt.setString(2, team.getNextOpponent());
			stmt.setDouble(3, team.getOffensiveEfficiency());
			stmt.setDouble(4, team.getDefensiveEfficiency());
			stmt.setString(5, team.getTeam());
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Could not complete transaction!");
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatePlayer(Player player) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE PLAYERS SET avg_fantasy_pts=?, health_status=?,"
					+ " starting_status=?, predicted_pts=? WHERE name=? ");
			stmt.setDouble(1, player.getAvgFantasyPts());
			stmt.setString(2, String.valueOf(player.getHealthStatus()));
			stmt.setBoolean(3, player.isStartingStatus());
			stmt.setDouble(4, player.getPredictedPts());
			stmt.setString(5, player.getName());
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Could not complete transaction!");
			e.printStackTrace();
			return false;
		}		
	}

}
