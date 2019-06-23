package com.ing.bank.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class TransactionNotFoundException extends RuntimeException implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private static final String MESSAGE = "Transactions not found!!!";
	
	public TransactionNotFoundException() {
		super(MESSAGE);
	}

}
