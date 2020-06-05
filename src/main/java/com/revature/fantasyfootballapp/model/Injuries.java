package com.revature.fantasyfootballapp.model;

public class Injuries {

	private String name;
	private char healthStatus;
	private String injury;
	private int weekToReturn;
	
	public Injuries() {
		
	}
	
	public Injuries(String name, char healthStatus, String injury, int weekToReturn) {
		this.name = name;
		this.healthStatus = healthStatus;
		this.injury = injury;
		this.weekToReturn = weekToReturn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(char healthStatus) {
		this.healthStatus = healthStatus;
	}

	public String getInjury() {
		return injury;
	}

	public void setInjury(String injury) {
		this.injury = injury;
	}

	public int getWeekToReturn() {
		return weekToReturn;
	}

	public void setWeekToReturn(int weekToReturn) {
		this.weekToReturn = weekToReturn;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", healthStatus=" + healthStatus + ", injury=" + injury + ", weekToReturn="
				+ weekToReturn + "]";
	}
	
	
}
