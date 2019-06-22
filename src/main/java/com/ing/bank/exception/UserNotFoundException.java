package com.ing.bank.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserNotFoundException extends RuntimeException implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "User Not Found";

	public UserNotFoundException(Long id) {
		super(MESSAGE + "With Id : " + id);

	}

}
