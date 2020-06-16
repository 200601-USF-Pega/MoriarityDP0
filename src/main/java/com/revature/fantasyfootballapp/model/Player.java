package com.revature.fantasyfootballapp.model;

public class Player {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}

	private String name;
	private String position;
	private String team;
	private double avgFantasyPts;
	private char healthStatus;
	private boolean startingStatus;
	private double predictedPts;
	
	public Player() {
		
	}
	
	public Player(String name, String position, String team, double avgFantasyPts,
			char healthStatus, boolean startingStatus, double predictedPts) {
		this.name = name;
		this.position = position;
		this.team = team;
		this.avgFantasyPts = avgFantasyPts;
		this.healthStatus = healthStatus;
		this.startingStatus = startingStatus;
		this.predictedPts = predictedPts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public double getAvgFantasyPts() {
		return avgFantasyPts;
	}

	public void setAvgFantasyPts(double avgFantasyPts) {
		this.avgFantasyPts = avgFantasyPts;
	}

	public char getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(char healthStatus) {
		this.healthStatus = healthStatus;
	}

	public boolean isStartingStatus() {
		return startingStatus;
	}

	public void setStartingStatus(boolean startingStatus) {
		this.startingStatus = startingStatus;
	}

	public double getPredictedPts() {
		return predictedPts;
	}

	public void setPredictedPts(double predictedPts) {
		this.predictedPts = predictedPts;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", position=" + position + ", team=" + team + ", avgFantasyPts=" + avgFantasyPts
				+ ", healthStatus=" + healthStatus + ", startingStatus=" + startingStatus + ", predictedPts="
				+ predictedPts + "]";
	}
	
	
}
