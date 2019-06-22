package com.ing.bank.service;

import com.ing.bank.dto.AccountDTO;

public interface AccountService {

	AccountDTO fetchAccountSummary(Long userId);

}
