package com.ing.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { LoginNotFoundException.class })
	public ResponseEntity<ResponseError> loginError(Exception e) {
		ResponseError loginError = new ResponseError(e.getMessage());
		return new ResponseEntity<>(loginError, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ResponseError> mapException(Exception e) {
		ResponseError error = new ResponseError();
		error.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.CREATED);

	}

}
