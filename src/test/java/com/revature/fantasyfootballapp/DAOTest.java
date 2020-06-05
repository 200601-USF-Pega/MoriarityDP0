package com.revature.fantasyfootballapp;

import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.fantasyfootballapp.dao.PlayerDAO;
import com.revature.fantasyfootballapp.dao.PlayerDAOImpl;
import com.revature.fantasyfootballapp.model.Player;

public class DAOTest {

	@Test
	public void test() {
		PlayerDAO instance = new PlayerDAOImpl();
		String playerName = "Dak Prescott";
		Player dakPrescott = instance.getPlayerByName(playerName);
		System.out.println(dakPrescott.toString());
		assertEquals(dakPrescott.getName(), "Dak Prescott");
	}

}
