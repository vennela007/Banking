package com.ing.bank.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.TransactionDTO;
import com.ing.bank.entity.Account;
import com.ing.bank.entity.Transaction;
import com.ing.bank.exception.InsufficientBalanceException;
import com.ing.bank.exception.TransactionNotFoundException;
import com.ing.bank.repository.AccountRepository;
import com.ing.bank.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);
	@Autowired

	TransactionRepository transactionRepository;
	@Autowired
	AccountRepository accountRepository;

	public List<TransactionDTO> getAllTransactions(String accountNumber) {
		
		List<TransactionDTO> transactionDtoList = new ArrayList<>();
		List<Transaction> transactionList = transactionRepository.findByAccountNumber(accountNumber);
		logger.info("Account no...");
		if (!transactionList.isEmpty()) {
			for (Transaction transaction : transactionList) {
				TransactionDTO transactionDTO = new TransactionDTO();
				BeanUtils.copyProperties(transaction, transactionDTO);
				transactionDtoList.add(transactionDTO);

			}
		} else {
			throw new TransactionNotFoundException();
		}
		return transactionDtoList;

	}

	@Override
	public TransactionDTO fundTransfer(TransactionDTO transactionDTO) {
		
		TransactionDTO responseTransactionDTO = new TransactionDTO();
		Account debitedAccount = accountRepository.findByAccountNumber(transactionDTO.getFromAccount());
		Account creditedAccount = accountRepository.findByAccountNumber(transactionDTO.getToAccount());
		if (transactionDTO.getTransactionAmount() <= debitedAccount.getBalance()) {

			Double balanceAfterDebited = debitedAccount.getBalance() - transactionDTO.getTransactionAmount();
			Double balanceAfterCredited = creditedAccount.getBalance() + transactionDTO.getTransactionAmount();

			debitedAccount.setBalance(balanceAfterDebited);
			creditedAccount.setBalance(balanceAfterCredited);

			Transaction debitTransaction = new Transaction();
			debitTransaction.setFromAccount(transactionDTO.getFromAccount());
			debitTransaction.setToAccount(transactionDTO.getToAccount());
			debitTransaction.setRemarks(transactionDTO.getRemarks());
			debitTransaction.setTransactionAmount(transactionDTO.getTransactionAmount());
			debitTransaction.setTransactionType("Debited");
			debitTransaction.setTransactionDate(LocalDate.now());
			debitTransaction.setAccount(debitedAccount);
			logger.info("transferring amount.....");
			Transaction creditTransaction = new Transaction();
			creditTransaction.setFromAccount(transactionDTO.getFromAccount());
			creditTransaction.setToAccount(transactionDTO.getToAccount());
			creditTransaction.setRemarks(transactionDTO.getRemarks());
			creditTransaction.setTransactionAmount(transactionDTO.getTransactionAmount());
			creditTransaction.setTransactionType("Credited");
			creditTransaction.setTransactionDate(LocalDate.now());
			creditTransaction.setAccount(creditedAccount);

			Transaction responseTransaction = transactionRepository.save(debitTransaction);
			transactionRepository.save(creditTransaction);

			BeanUtils.copyProperties(responseTransaction, responseTransactionDTO);

			return responseTransactionDTO;
		} else {
			throw new InsufficientBalanceException();
		}

	}
}
