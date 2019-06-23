package com.ing.bank.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AccountNumberDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String accountNumber;
}
