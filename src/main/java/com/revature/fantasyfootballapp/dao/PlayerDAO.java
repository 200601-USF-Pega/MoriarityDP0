package com.revature.fantasyfootballapp.dao;

import com.revature.fantasyfootballapp.model.Player;

public interface PlayerDAO {

	public Player getPlayerByName(String playerName);
}
