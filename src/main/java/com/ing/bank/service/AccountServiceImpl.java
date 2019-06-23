package com.ing.bank.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.AccountDTO;
import com.ing.bank.dto.AccountRequestDTO;
import com.ing.bank.entity.Account;
import com.ing.bank.entity.User;
import com.ing.bank.exception.AccountNotFoundException;
import com.ing.bank.exception.UserNotFoundException;
import com.ing.bank.repository.AccountRepository;
import com.ing.bank.repository.UserRepository;

@Service
public class AccountServiceImpl implements AccountService {
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountRepository accountRepository;

	private UserRepository userRepository;

	@Override
	public List<AccountDTO> fetchAccountSummary(Long userId) {
		logger.info("fetchAccountSummary in service");
		List<AccountDTO> accountDTOs = new ArrayList<>();
		List<Account> accounts = accountRepository.findUser(userId);
		if(!accounts.isEmpty()) {
		for (Account account : accounts) {
			AccountDTO accountDTO = new AccountDTO();
			BeanUtils.copyProperties(account, accountDTO);
			accountDTOs.add(accountDTO);
		}
		}else {
			throw new AccountNotFoundException();
		}
		return accountDTOs;

	}

	@Override
	public AccountDTO approve(AccountRequestDTO accountRequestDTO) {
		logger.info("approve in service");
		AccountDTO accountDTO = new AccountDTO();
		User user = userRepository.findById(accountRequestDTO.getUserId()).orElse(null);

		if (user != null) {
			if (accountRequestDTO.getStatus().trim().equalsIgnoreCase("approve")) {
				Account account = new Account();
				String mobString = String.valueOf(user.getMobileNumber());
				account.setAccountNumber("12345" + mobString.substring(0, 5));
				
				account.setAccountType(user.getAccountType());
				account.setBalance(500);
				account.setCreationDate(LocalDate.now());
				user.setLoginName(user.getUserName().trim().toLowerCase());
				user.setPassword("Hcl@123");
				user.setStatus(accountRequestDTO.getStatus());
				account.setUser(user);
				accountRepository.save(account);
				BeanUtils.copyProperties(account, accountDTO, "mesage");
				accountDTO.setMessage("Account created sucessfully");
			} else {
				user.setStatus(accountRequestDTO.getStatus());
				accountDTO.setMessage("Application Rejected");
			}

		} else {
			throw new UserNotFoundException(accountRequestDTO.getUserId());
		}
		return accountDTO;
	}

	@Override
	public List<AccountDTO> fetchAccounts(String accountNumber) {
		logger.info("fetch accounts");
		List<AccountDTO> listAccountDTO = null;
		AccountDTO accountDTO = null;
		listAccountDTO = new ArrayList<>();
		List<Account> listAccount = accountRepository.findByAccountNumberNotLike(accountNumber);
		for (Account account : listAccount) {
			accountDTO = new AccountDTO();
			accountDTO.setAccountId(account.getAccountId());
			accountDTO.setAccountNumber(account.getAccountNumber());
			accountDTO.setUserId(account.getUser().getUserId());
			accountDTO.setAccountType(account.getAccountType());
			accountDTO.setBalance(account.getBalance());
			accountDTO.setCreationDate(account.getCreationDate());
			// add accountDTO
			listAccountDTO.add(accountDTO);
		}
		return listAccountDTO;
	}

}
