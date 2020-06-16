package com.revature.fantasyfootballapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.fantasyfootballapp.model.NFLTeam;

class NFLTeamDAOImplTest {

	@Test
	void getNFLTeamTest() {
		NFLTeamDAO testInstance = new NFLTeamDAOImpl();
		NFLTeam dummyTeam = new NFLTeam("Cincinnati Bengals", 1, 0, 0, "Cleveland Browns", -0.155, -0.193);
		assertEquals(dummyTeam.toString(), testInstance.getNFLTeam("Cincinnati Bengals").toString());
	}

}
