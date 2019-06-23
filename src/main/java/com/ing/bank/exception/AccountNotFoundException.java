package com.ing.bank.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountNotFoundException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "No Accounts Found! Please contact BankS";
	
	public AccountNotFoundException() {
		super(MESSAGE);
	}
}
