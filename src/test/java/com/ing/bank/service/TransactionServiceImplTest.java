package com.ing.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.bank.controller.AccountController;
import com.ing.bank.dto.TransactionDTO;
import com.ing.bank.entity.Transaction;
import com.ing.bank.repository.TransactionRepository;

@RunWith(SpringRunner.class)
public class TransactionServiceImplTest {
	@Mock

	TransactionRepository transactionRepository;

	@InjectMocks

	TransactionServiceImpl transactionServiceImpl;

	@Test

	public void testGetAllTransactions() {

		List<Transaction> transactionList = new ArrayList<>();

		Transaction transaction = new Transaction();

		transaction.setRemarks("travel");

		transactionList.add(transaction);

		Mockito.when(transactionRepository.findByAccountNumber(Mockito.anyString())).thenReturn(transactionList);

		List<TransactionDTO> transactionDTO = transactionServiceImpl.getAllTransactions(Mockito.anyString());

		Assert.assertEquals("travel", transactionDTO.get(0).getRemarks());

	}

}
