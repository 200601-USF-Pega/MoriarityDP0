package com.revature.fantasyfootballapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.fantasyfootballapp.model.Player;
import java.math.*;
public class PlayerDAOImpl implements PlayerDAO{

	static Logger LOGGER = LogManager.getLogger();
	Connection connection = null;
	PreparedStatement stmt = null;

	@Override
	public Player getPlayerByName(String playerName) {
		Player player = new Player();
		try {
			connection = DAOUtilities.getConnection();
			
			stmt = connection.prepareStatement("SELECT * FROM PLAYERS WHERE name= ?");
			stmt.setString(1, playerName);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				player.setName(rs.getString("name"));
				player.setPosition(rs.getString("position"));
				player.setTeam(rs.getString("team"));
				player.setAvgFantasyPts(rs.getDouble("avg_fantasy_pts"));
				player.setHealthStatus(rs.getString("health_status").charAt(0));
				player.setPredictedPts(rs.getDouble("predicted_pts"));
			}
			PreparedStatement predictedPts = connection.prepareStatement("select get_pred_pts(nfl_team_stats.defensive_efficiency, players.avg_fantasy_pts) "
					+ "from nfl_team_stats, players where nfl_team_stats.next_opponent= ? "
					+ "and players.name=?;");
			predictedPts.setString(1, player.getTeam());
			predictedPts.setString(2, playerName);
			ResultSet rs2 = predictedPts.executeQuery();
			while (rs2.next()) {
				player.setPredictedPts(rs2.getDouble("get_pred_pts"));
			}
		} catch (SQLException e) {
			LOGGER.debug("at getPlayerByName");
		}
		return player;
	}
}
