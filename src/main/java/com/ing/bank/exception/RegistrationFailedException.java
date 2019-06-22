package com.ing.bank.exception;

public class RegistrationFailedException extends RuntimeException {
	

	private static final long serialVersionUID = 1L;
	

	
	
	public RegistrationFailedException() {
		super("Registration failed");
	}
}
