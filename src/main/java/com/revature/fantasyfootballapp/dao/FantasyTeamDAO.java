package com.revature.fantasyfootballapp.dao;

import com.revature.fantasyfootballapp.model.FantasyTeam;

public interface FantasyTeamDAO {

	public FantasyTeam getFantasyTeam(String user);
	public void makeNewFantasyTeam(FantasyTeam newTeam);
	public void dropFantasyTeam(FantasyTeam team);
	public void replaceQB(String oldQb, String newQb);
	public void replaceRB1(String oldRb1, String newRb1);
	public void replaceRB2(String oldRb2, String newRb2);
	public void replaceWR1(String oldWr1, String newWr1);
	public void replaceWR2(String oldWr2, String newWr2);
	public void replaceTE(String oldTe, String newTe);
	public void replaceFlex(String oldFlex, String newFlex);
	public void replaceDST(String oldDSt, String newDSt);
	public void replaceK(String oldK, String newK);
}
