package com.revature.fantasyfootballapp.model;

public class NFLSchedule {

	private int week;
	private String team;
	private String opponent;
	private String result;
	
	public NFLSchedule() {
		
	}

	public NFLSchedule(int week, String team, String opponent, String result) {
		this.week = week;
		this.team = team;
		this.opponent = opponent;
		this.result = result;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getOpponent() {
		return opponent;
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "[week=" + week + ", team=" + team + ", opponent=" + opponent + ", result=" + result + "]";
	}
	
	
}
