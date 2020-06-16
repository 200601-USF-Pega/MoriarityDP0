package com.revature.fantasyfootballapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.fantasyfootballapp.model.Injuries;
import com.revature.fantasyfootballapp.model.Player;

class InjuriesDAOImplTest {

	InjuriesDAO testInstance = new InjuriesDAOImpl();
	Injuries dummyInjury = new Injuries("Julio Jones", 'Q', "Right calf", 2);
	
	
	@Test
	void getPlayerHealthTest() {
		Player dummyPlayer = new Player();
		dummyPlayer.setName("Julio Jones");
		assertEquals(this.dummyInjury, this.testInstance.getPlayerHealth(dummyPlayer));
	}
	
	@Test
	void getIRListTest() {
		assertNotNull(this.testInstance.getIRList());
	}

}
