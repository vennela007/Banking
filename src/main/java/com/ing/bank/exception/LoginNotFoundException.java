package com.ing.bank.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class LoginNotFoundException extends RuntimeException implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "user not found";
	
	public LoginNotFoundException() {
		super(MESSAGE);
	}

}
