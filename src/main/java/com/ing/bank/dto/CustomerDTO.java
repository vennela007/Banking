package com.ing.bank.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CustomerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long customerId;
	private String customerName;
	private String accountType;
	private Long mobileNumber;
	private String email;
	private String address;
	private String nominee;
	private String nomineeRelation;
	private int age;
	private LocalDate creationDate;
	private Long aadharNumber;
}
