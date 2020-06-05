package com.revature.fantasyfootballapp.model;

public class NFLTeam {

	private String team;
	private String record;
	private String nextOpponent;
	private double offensiveEfficiency;
	private double defensiveEfficiency;
	
	public NFLTeam() {
		
	}

	public NFLTeam(String team, String record, String nextOpponent, double offensiveEfficiency,
			double defensiveEfficiency) {
		super();
		this.team = team;
		this.record = record;
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

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
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
		return "[team=" + team + ", record=" + record + ", nextOpponent=" + nextOpponent
				+ ", offensiveEfficiency=" + offensiveEfficiency + ", defensiveEfficiency=" + defensiveEfficiency + "]";
	}
	
	
}
