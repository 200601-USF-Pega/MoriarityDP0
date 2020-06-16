package com.revature.fantasyfootballapp.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.fantasyfootballapp.model.Player;

class PlayerDAOImplTest {

	@Test
	void getPlayerByNameTest() {
		PlayerDAO testInstance = new PlayerDAOImpl();
		String name = "Matt Ryan";
		Player mattRyan = new Player("Matt Ryan", "QB", "Atlanta Falcons", 14.564, 'H', true, 13.234);
		assertEquals(mattRyan, testInstance.getPlayerByName(name));
	}

}
