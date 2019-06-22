package com.ing.bank.service;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.AccountDTO;
import com.ing.bank.dto.AccountRequestDTO;
import com.ing.bank.entity.Account;
import com.ing.bank.entity.User;
import com.ing.bank.exception.UserNotFoundException;
import com.ing.bank.repository.AccountRepository;
import com.ing.bank.repository.UserRepository;

@Service
public class AccountServiceImpl implements AccountService {
	private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public AccountDTO fetchAccountSummary(Long userId) {
		AccountDTO accountDTO = new AccountDTO();
		Account account = accountRepository.findUser(userId);
		accountDTO.setAccountId(account.getAccountId());
		accountDTO.setAccountNumber(account.getAccountNumber());
		accountDTO.setAccountType(account.getAccountType());
		accountDTO.setBalance(account.getBalance());
		accountDTO.setCreationDate(account.getCreationDate());
		accountDTO.setStatus(account.getUser().getStatus());
		return accountDTO;
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

}
