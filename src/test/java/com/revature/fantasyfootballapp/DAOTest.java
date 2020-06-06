package com.revature.fantasyfootballapp;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.fantasyfootballapp.dao.AdminDAO;
import com.revature.fantasyfootballapp.dao.AdminDAOImpl;
import com.revature.fantasyfootballapp.dao.DAOUtilities;
import com.revature.fantasyfootballapp.dao.FantasyTeamDAO;
import com.revature.fantasyfootballapp.dao.FantasyTeamDAOImpl;
import com.revature.fantasyfootballapp.dao.InjuriesDAO;
import com.revature.fantasyfootballapp.dao.InjuriesDAOImpl;
import com.revature.fantasyfootballapp.dao.NFLScheduleDAO;
import com.revature.fantasyfootballapp.dao.NFLScheduleDAOImpl;
import com.revature.fantasyfootballapp.dao.NFLTeamDAO;
import com.revature.fantasyfootballapp.dao.NFLTeamDAOImpl;
import com.revature.fantasyfootballapp.dao.PlayerDAO;
import com.revature.fantasyfootballapp.dao.PlayerDAOImpl;
import com.revature.fantasyfootballapp.model.FantasyTeam;
import com.revature.fantasyfootballapp.model.Injuries;
import com.revature.fantasyfootballapp.model.NFLSchedule;
import com.revature.fantasyfootballapp.model.NFLTeam;
import com.revature.fantasyfootballapp.model.Player;

public class DAOTest {

	
	
	@Test
	public void test() {
		AdminDAO instance = new AdminDAOImpl();
		Player player = new Player("Lamar Jackson", "QB", "Baltimore Ravens", 25.98126, 'H', true, 23.13126);
		assertTrue(instance.updatePlayer(player));
		
	}

	
}
