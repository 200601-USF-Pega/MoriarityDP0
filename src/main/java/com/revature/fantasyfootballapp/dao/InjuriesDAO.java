package com.revature.fantasyfootballapp.dao;

import java.util.List;

import com.revature.fantasyfootballapp.model.Injuries;
import com.revature.fantasyfootballapp.model.Player;

public interface InjuriesDAO {

	public Injuries getPlayerHealth(Player player);
	public List<Injuries> getIRList();
}
