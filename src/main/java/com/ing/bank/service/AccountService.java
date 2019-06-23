package com.ing.bank.service;

import java.util.List;

import com.ing.bank.dto.AccountDTO;
import com.ing.bank.dto.AccountRequestDTO;

public interface AccountService {

	public List<AccountDTO> fetchAccountSummary(Long userId);

	public AccountDTO approve(AccountRequestDTO accountRequestDTO);

	List<AccountDTO> fetchAccounts(String accountNumber);

}
