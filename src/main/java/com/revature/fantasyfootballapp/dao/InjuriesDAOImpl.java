package com.revature.fantasyfootballapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.fantasyfootballapp.model.Injuries;
import com.revature.fantasyfootballapp.model.Player;

public class InjuriesDAOImpl implements InjuriesDAO{

	static Logger LOGGER = LogManager.getLogger();
	Connection connection = null;
	PreparedStatement stmt = null;
	
	@Override
	public Injuries getPlayerHealth(Player player) {
		Injuries injury = new Injuries();
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM INJURIES WHERE name= ?");
			stmt.setString(1, player.getName());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				injury.setName(rs.getString("name"));
				injury.setHealthStatus(rs.getString("health_status").charAt(0));
				injury.setInjury(rs.getString("injury"));
				injury.setWeekToReturn(rs.getInt("week_to_return"));
			}
		} catch (SQLException e) {
			LOGGER.debug("at getPlayerHealth");
		}
		return injury;
	}

	@Override
	public List<Injuries> getIRList() {
		List<Injuries> injuries = new ArrayList<>()	;
		try {
			connection = DAOUtilities.getConnection();
			stmt = connection.prepareStatement("SELECT * FROM INJURIES");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Injuries injury = new Injuries();
				injury.setName(rs.getString("name"));
				injury.setHealthStatus(rs.getString("health_status").charAt(0));
				injury.setInjury(rs.getString("injury"));
				injury.setWeekToReturn(rs.getInt("week_to_return"));
				injuries.add(injury);
			} 
		}catch (SQLException e) {
				LOGGER.debug("at getIRList");
		}
		return injuries;
	}
}
