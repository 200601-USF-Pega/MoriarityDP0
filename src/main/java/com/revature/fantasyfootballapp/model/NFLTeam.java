package com.revature.fantasyfootballapp.model;

public class NFLTeam {

	private String team;
	private int wins;
	private int losses;
	private int ties;
	private String nextOpponent;
	private double offensiveEfficiency;
	private double defensiveEfficiency;
	
	public NFLTeam() {
		
	}

	public NFLTeam(String team, int wins, int losses, int ties, String nextOpponent, double offensiveEfficiency,
			double defensiveEfficiency) {
		super();
		this.team = team;
		this.wins = wins;
		this.losses = losses;
		this.ties = ties;
		this.nextOpponent = nextOpponent;
		this.offensiveEfficiency = offensiveEfficiency;
		this.defensiveEfficiency = defensiveEfficiency;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}

	public int getTies() {
		return ties;
	}

	public void setTies(int ties) {
		this.ties = ties;
	}

	public String getNextOpponent() {
		return nextOpponent;
	}

	public void setNextOpponent(String nextOpponent) {
		this.nextOpponent = nextOpponent;
	}

	public double getOffensiveEfficiency() {
		return offensiveEfficiency;
	}

	public void setOffensiveEfficiency(double offensiveEfficiency) {
		this.offensiveEfficiency = offensiveEfficiency;
	}

	public double getDefensiveEfficiency() {
		return defensiveEfficiency;
	}

	public void setDefensiveEfficiency(double defensiveEfficiency) {
		this.defensiveEfficiency = defensiveEfficiency;
	}

	@Override
	public String toString() {
		return "[team=" + team + ", record=" + wins + "-" + losses + "-" + ties + ", nextOpponent=" + nextOpponent
				+ ", offensiveEfficiency=" + offensiveEfficiency + ", defensiveEfficiency=" + defensiveEfficiency + "]";
	}
	
	
}
