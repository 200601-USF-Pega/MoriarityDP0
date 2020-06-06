package com.revature.fantasyfootballapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.fantasyfootballapp.model.Player;

public class PlayerDAOImpl implements PlayerDAO{

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
		} catch (SQLException e) {
			System.out.println("Could not get connection!");
			e.printStackTrace();
		}
		return player;
	}
}
