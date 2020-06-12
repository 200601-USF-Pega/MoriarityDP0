package com.revature.fantasyfootballapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.fantasyfootballapp.model.Injuries;

class AdminDAOImplTest {

	@BeforeAll
	void setUp() {
		AdminDAO testInstance = new AdminDAOImpl();
		Injuries dummyInjury = new Injuries("Andy Dalton", 'Q', "Separated Throwing Shoulder", 14);
		
	}
	
	@Test
	void updateInjuryTest() {
		
	}

	@Test
	void deleteFromIRTest() {
		
	}
	
	@Test
	void updateGameTest() {
		
	}
	
	@Test
	void updateWinsTest() {
		
	}
	
	@Test 
	void updateLossesTest() {
		
	}
	
	@Test
	void updateTiesTest() {
		
	}
	
	@Test
	void updateNextOpponentTest() {
		
	}
	
	@Test
	void updatePlayerTest() {
		
	}
}
