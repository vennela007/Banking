package com.ing.bank.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class InsufficientBalanceException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Please enter a valid amount...";

	public InsufficientBalanceException() {
		super(MESSAGE);

	}

}
