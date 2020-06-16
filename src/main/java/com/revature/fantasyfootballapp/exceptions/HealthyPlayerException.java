package com.revature.fantasyfootballapp.exceptions;

public class HealthyPlayerException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8108716865594547887L;

	@Override
	public String getMessage() {
		return "Healthy players cannot be added to the IR.";
	}
	
}
