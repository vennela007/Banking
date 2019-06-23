package com.ing.bank.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor



	

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long userId;
	private String userName;
	private String accountType;
	private Long mobileNumber;
	private String email;
	private String address;
	private String nominee;
	private String nomineeRelation;
	private int age;
	private LocalDate creationDate;
	private Long aadharNumber;
	private String loginName;
	private String password;
	private String role;

	private String status;



}
