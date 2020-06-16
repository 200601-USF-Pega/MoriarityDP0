package com.revature.fantasyfootballapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.fantasyfootballapp.model.NFLTeam;

class NFLScheduleDAOImplTest {

	NFLScheduleDAO testInstance = new NFLScheduleDAOImpl();
	NFLTeam dummyTeam = new NFLTeam("Cincinnati Bengals", 1, 0, 0, "Cleveland Browns", -.155, -.193);
	
	@Test
	void getWeekTest() {
		assertNotNull(this.testInstance.getWeek(1));
	}

	@Test
	void getNextOpponentTest() {
		NFLTeam instance = new NFLTeam();
		instance.setTeam("Cleveland Browns");
		assertEquals(this.dummyTeam.toString(), this.testInstance.getNextOpponent(2, instance).toString());
	}
	
	@Test
	void getScheduleForTeamTest() {
		assertNotNull(this.testInstance.getScheduleForTeam(dummyTeam));
	}
}
