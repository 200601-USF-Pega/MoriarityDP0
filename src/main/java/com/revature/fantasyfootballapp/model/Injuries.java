package com.revature.fantasyfootballapp.model;

public class Injuries {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + healthStatus;
		result = prime * result + ((injury == null) ? 0 : injury.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weekToReturn;
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
		Injuries other = (Injuries) obj;
		if (healthStatus != other.healthStatus)
			return false;
		if (injury == null) {
			if (other.injury != null)
				return false;
		} else if (!injury.equals(other.injury))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weekToReturn != other.weekToReturn)
			return false;
		return true;
	}

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
