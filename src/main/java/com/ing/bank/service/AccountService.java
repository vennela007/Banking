package com.ing.bank.service;

import com.ing.bank.dto.AccountDTO;
import com.ing.bank.dto.AccountRequestDTO;

public interface AccountService {

	AccountDTO fetchAccountSummary(Long userId);

	public AccountDTO approve(AccountRequestDTO accountRequestDTO);

}
