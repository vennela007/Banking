package com.ing.bank.exception;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

<<<<<<< HEAD
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ResponseError implements Serializable {

=======
@Getter @Setter @NoArgsConstructor @ToString
public class ResponseError implements Serializable{
	
	
>>>>>>> de16fd191f44660469f99536045ce97c7bd33989
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	private String errorMessage;

	public ResponseError(String message) {
		this.errorMessage = message;
	}
=======
	
	private String message;

	public ResponseError(String message) {
		this.message = message;
		
	}

>>>>>>> de16fd191f44660469f99536045ce97c7bd33989
}
