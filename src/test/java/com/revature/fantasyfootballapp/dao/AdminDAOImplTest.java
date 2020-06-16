package com.revature.fantasyfootballapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.revature.fantasyfootballapp.model.Injuries;
import com.revature.fantasyfootballapp.model.NFLSchedule;

@Disabled
class AdminDAOImplTest {
	
	AdminDAO testInstance = new AdminDAOImpl();
	Injuries dummyInjury= new Injuries("Andy Dalton", 'Q', "Separated Throwing Shoulder", 14);
	NFLSchedule dummyGame= new NFLSchedule(2, "Cincinnati Bengals", "Cleveland Browns", "W (27-13");

	@Test
	void addToIRTest() {
		assertTrue(this.testInstance.addToIR(this.dummyInjury));
	}
	
	@Test
	void updateInjuryTest() {
		this.dummyInjury.setHealthStatus('D');
		assertTrue(this.testInstance.updateInjury(this.dummyInjury));
	}

	@Test
	void deleteFromIRTest() {
		assertTrue(this.testInstance.deleteFromIR(dummyInjury));
	}
	
	@Disabled
	@Test
	void updateGameTest() {
		assertTrue(this.testInstance.updateGame(this.dummyGame));
	}
	
	@Disabled
	@Test
	void updateWinsTest() {
		assertTrue(this.testInstance.updateWins());
	}
	
	@Disabled
	@Test 
	void updateLossesTest() {
		assertTrue(this.testInstance.updateLosses());
	}
	
	@Disabled
	@Test
	void updateTiesTest() {
		assertTrue(this.testInstance.updateTies());
	}
	
	@Disabled
	@Test
	void updateNextOpponentTest() {
		assertTrue(this.testInstance.updateNextOpponent());
	}
	
}
