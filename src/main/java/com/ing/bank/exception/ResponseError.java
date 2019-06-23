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
public class ResponseError implements Serializable {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public ResponseError(String message) {
		this.errorMessage = message;
	}

}
	