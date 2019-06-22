package com.ing.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.AccountDTO;
import com.ing.bank.entity.Account;
import com.ing.bank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

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

	/*
	 * @Override public List<AccountDTO> fetchAccountSummary(Long userId) {
	 * AccountDTO accountDTO = null; List<AccountDTO> listDTO = null; User user =
	 * userRepository.findByUserById(userId); List<Account> listAccount =
	 * accountRepository.findByUserId(user.getUserId()); for (Account list :
	 * listAccount) { listDTO = new ArrayList<AccountDTO>(); accountDTO = new
	 * AccountDTO(); accountDTO.setAccountId(list.getAccountId());
	 * accountDTO.setAccountNumber(list.getAccountNumber());
	 * accountDTO.setAccountType(list.getAccountType());
	 * accountDTO.setBalance(list.getBalance());
	 * accountDTO.setCreationDate(list.getCreationDate());
	 * accountDTO.setStatus(list.getStatus()); listDTO.add(accountDTO); } return
	 * listDTO;
	 * 
	 * }
	 */
}
