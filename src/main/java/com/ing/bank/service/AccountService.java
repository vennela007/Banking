package com.ing.bank.service;

import com.ing.bank.dto.AccountDTO;
import com.ing.bank.dto.AccountRequestDTO;

public interface AccountService {

	public AccountDTO approve(AccountRequestDTO accountRequestDTO);
}
