package com.ing.bank.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends Exception {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "user not available";

	public UserNotFoundException() {
		super(MESSAGE);
	}

}
