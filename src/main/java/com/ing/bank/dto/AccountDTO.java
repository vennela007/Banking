package com.ing.bank.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long accountId;
	private String accountNumber;
	private String accountType;
	private LocalDate creationDate;
	private double balance;
	private String status;
	private Long userId;
	private String message;

}
