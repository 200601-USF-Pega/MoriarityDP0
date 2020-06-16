package com.revature.fantasyfootballapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.revature.fantasyfootballapp.model.FantasyTeam;

class FantasyTeamDAOImplTest {

	FantasyTeamDAO testInstance = new FantasyTeamDAOImpl();
	FantasyTeam dummyTeam = new FantasyTeam("user2", "Patrick Mahomes", "Nick Chubb", "Joe Mixon", "Michael Thomas", "Sterling Shepard", "Kyle Rudolph", "Mike Evans", "Arizona Cardinals", "Nick Folk");
	
	@Test
	void makeNewFantasyTeamTest() {
		assertTrue(this.testInstance.makeNewFantasyTeam(dummyTeam));
	}
	
	@Disabled
	@Test
	void getFantasyTeamTest() {
		FantasyTeam getDummy = this.testInstance.getFantasyTeam(dummyTeam.getUser());
		assertEquals(getDummy.getUser(), "user2");
		assertEquals(getDummy.getQb(), "Patrick Mahomes");
		assertEquals(getDummy.getRb1(), "Nick Chubb");
		assertEquals(getDummy.getRb2(), "Joe Mixon");
		assertEquals(getDummy.getWr1(), "Michael Thomas");
		assertEquals(getDummy.getWr2(), "Sterling Shepard");
		assertEquals(getDummy.getTe(), "Kyle Rudolph");
		assertEquals(getDummy.getFlex(), "Mike Evans");
		assertEquals(getDummy.getDSt(), "Arizona Cardinals");
		assertEquals(getDummy.getK(), "Nick Folk");
	}

	@Test
	void replaceQBTest() {
		assertTrue(this.testInstance.replaceQB(this.dummyTeam.getUser(), "Drew Brees"));
	}
	
	@Test
	void dropFantasyTeamTest() {
		assertTrue(this.testInstance.dropFantasyTeam(this.dummyTeam));
	}
}
