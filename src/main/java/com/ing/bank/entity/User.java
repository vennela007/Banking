package com.ing.bank.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;
	private String userName;
	private String accountType;
	@Column(unique=true)
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
	@JsonManagedReference
	@OneToMany(mappedBy = "user")
	private List<Account> accounts;
}
