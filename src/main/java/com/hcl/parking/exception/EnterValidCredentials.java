package com.hcl.parking.exception;

public class EnterValidCredentials extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public EnterValidCredentials(String message) {
		
		super(message);
	}

}