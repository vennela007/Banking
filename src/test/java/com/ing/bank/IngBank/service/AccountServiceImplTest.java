package com.ing.bank.ingbank.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.bank.dto.AccountDTO;
import com.ing.bank.dto.AccountRequestDTO;
import com.ing.bank.entity.User;
import com.ing.bank.repository.AccountRepository;
import com.ing.bank.repository.UserRepository;
import com.ing.bank.service.AccountServiceImpl;

@RunWith(SpringRunner.class)
public class AccountServiceImplTest {

	@Mock
	UserRepository userRepository;

	@Mock
	AccountRepository accountRepository;

	@InjectMocks
	AccountServiceImpl accountServiceImpl;

	AccountRequestDTO accountRequestDTO;
	User user;

	@Before
	public void setUp() {
		accountRequestDTO = new AccountRequestDTO();
		accountRequestDTO.setStatus("approve");
		accountRequestDTO.setUserId(1L);

		user = new User();
		user.setUserId(1L);
		user.setUserName("test");
		user.setMobileNumber(999999999L);
		user.setAccountType("Savings");
	}

	@Test
	public void approveSucess() {
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
		AccountDTO accountDTO = accountServiceImpl.approve(accountRequestDTO);
		Assert.assertEquals("Account created sucessfully", accountDTO.getMessage());

	}

	@Test
	public void approveFailure() {
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
		accountRequestDTO.setStatus("reject");
		AccountDTO accountDTO = accountServiceImpl.approve(accountRequestDTO);
		Assert.assertEquals("Application Rejected", accountDTO.getMessage());

	}
}