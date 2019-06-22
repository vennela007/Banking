package com.ing.bank.exception;

<<<<<<< HEAD
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
=======
import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class UserNotFoundException extends RuntimeException implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE ="User Not Found";
	
	public UserNotFoundException(Long id) {
		super(MESSAGE +"With Id : "+id);
>>>>>>> de16fd191f44660469f99536045ce97c7bd33989
	}

}
