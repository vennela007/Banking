package com.ing.bank.service;

import java.util.ArrayList;
import java.util.List;
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
import com.ing.bank.entity.Account;
import com.ing.bank.entity.User;
import com.ing.bank.exception.AccountNotFoundException;
import com.ing.bank.repository.AccountRepository;
import com.ing.bank.repository.UserRepository;

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

	List<Account> accounts;

	Account account;

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
		accounts = new ArrayList<>();
		account = new Account();
		account.setAccountId(1L);
		account.setAccountNumber("45678");
		accounts.add(account);
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

	@Test
	public void fetchAccountSummarySucess() {
		Mockito.when(accountRepository.findUser(Mockito.anyLong())).thenReturn(accounts);
		List<AccountDTO> accountDTOs = accountServiceImpl.fetchAccountSummary(Mockito.anyLong());
		Assert.assertEquals("45678", accountDTOs.get(0).getAccountNumber());
	}

	@Test(expected = AccountNotFoundException.class)
	public void fetchAccountSummaryFailure() {
		accounts = new ArrayList<>();
		Mockito.when(accountRepository.findUser(Mockito.anyLong())).thenReturn(accounts);
		accountServiceImpl.fetchAccountSummary(Mockito.anyLong());
	}
}