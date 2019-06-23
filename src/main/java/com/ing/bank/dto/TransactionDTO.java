package com.ing.bank.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long transactionId;
	private String fromAccount;
	private String toAccount;
	private LocalDate transactionDate;
	private Double transactionAmount;
	private String remarks;
	private String transactionType;
}
