package com.revature.fantasyfootballapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.fantasyfootballapp.model.Injuries;
import com.revature.fantasyfootballapp.model.NFLSchedule;
import com.revature.fantasyfootballapp.model.NFLTeam;
import com.revature.fantasyfootballapp.model.Player;

public class AdminDAOImpl implements AdminDAO{
	
	private static Logger LOGGER = LogManager.getLogger();
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
			LOGGER.debug("at updateInjury");
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
			LOGGER.debug("at deleteFromIR");
			return false;
		}
	}

	@Override
	public boolean updateGame(NFLSchedule game) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE NFL_SCHEDULE SET result=? WHERE team=? AND week=?;");
			stmt.setString(1, game.getResult());
			stmt.setString(2, game.getTeam());
			stmt.setInt(3, game.getWeek());
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at updateGame");
			return false;
		}		
	}

	@Override
	public boolean updateTeam(NFLTeam team) {
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("UPDATE NFL_TEAM_STATS SET record=? WHERE team=?");
			stmt.setString(1, team.getRecord());
			stmt.setString(2, team.getTeam());
			if (stmt.executeUpdate() != 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			LOGGER.debug("at updateTeam");
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
			LOGGER.debug("at updatePlayer");
			return false;
		}		
	}

}
