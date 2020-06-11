package com.revature.fantasyfootballapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.fantasyfootballapp.model.NFLSchedule;
import com.revature.fantasyfootballapp.model.NFLTeam;

public class NFLScheduleDAOImpl implements NFLScheduleDAO{

	static Logger LOGGER = LogManager.getLogger();
	Connection connection = null;
	PreparedStatement stmt = null;
	
	@Override
	public List<NFLSchedule> getWeek(int weekNumber) {
		List<NFLSchedule> games = new ArrayList<>();
		
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM NFL_SCHEDULE WHERE week= ?");
			stmt.setInt(1, weekNumber);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NFLSchedule game = new NFLSchedule();
				game.setWeek(rs.getInt("week"));
				game.setTeam(rs.getString("team"));
				game.setOpponent(rs.getString("opponent"));
				game.setResult(rs.getString("result"));
				games.add(game);
			}
		} catch (SQLException e) {
			LOGGER.debug("at getWeek");
		}
		
		return games;
	}


	@Override
	public String getNextOpponent(int weekNumber, NFLTeam team) {
		String opponent;
		
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM NFL_SCHEDULE WHERE week= ? AND team= ?");
			stmt.setInt(1, weekNumber);
			stmt.setString(2, team.getTeam());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				opponent = rs.getString("opponent");
			} else {
				opponent = "BYE";
			}
			
		} catch (SQLException e) {
			LOGGER.debug("at getNextOpponent");
			opponent = "";
		}
		return opponent;
	}

	@Override
	public List<NFLSchedule> getFullSchedule() {
		List<NFLSchedule> schedule = new ArrayList<>();
		
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM NFL_SCHEDULE");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NFLSchedule week = new NFLSchedule();
				week.setWeek(rs.getInt("week"));
				week.setTeam(rs.getString("team"));
				week.setOpponent(rs.getString("opponent"));
				week.setResult(rs.getString("result"));
				schedule.add(week);
			}
		} catch (SQLException e) {
			LOGGER.debug("at getFullSchedule");
		}
		return schedule;
	}

	@Override
	public List<NFLSchedule> getRemainingSchedule(int currentWeek) {
		List<NFLSchedule> schedule = new ArrayList<>();
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM NFL_SCHEDULE WHERE week > ?");
			stmt.setInt(1, currentWeek);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NFLSchedule week = new NFLSchedule();
				week.setWeek(rs.getInt("week"));
				week.setTeam(rs.getString("team"));
				week.setOpponent(rs.getString("opponent"));
				week.setResult(rs.getString("result"));
				schedule.add(week);
			}
		} catch (SQLException e) {
			LOGGER.debug("at getRemainingSchedule");
		}
		return schedule;
	}

	@Override
	public List<NFLSchedule> getScheduleForTeam(NFLTeam team) {
		List<NFLSchedule> schedule = new ArrayList<>();
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM NFL_SCHEDULE WHERE team= ?");
			stmt.setString(1, team.getTeam());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NFLSchedule week = new NFLSchedule();
				week.setWeek(rs.getInt("week"));
				week.setTeam(rs.getString("team"));
				week.setOpponent(rs.getString("opponent"));
				week.setResult(rs.getString("result"));
				schedule.add(week);
			}
			
		} catch (SQLException e) {
			LOGGER.debug("at getScheduleForTeam");
		}
		return schedule;
	}
}
