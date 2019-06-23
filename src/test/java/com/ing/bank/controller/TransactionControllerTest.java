package com.ing.bank.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.bank.dto.TransactionDTO;
import com.ing.bank.entity.Transaction;
import com.ing.bank.service.TransactionService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TransactionController.class)
public class TransactionControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	TransactionService transactionService;
	
	Transaction transaction;
	TransactionDTO transactionDTO;
	
	@Test
	public void fundTransferTest() throws Exception {
		transactionDTO = new TransactionDTO();
		transaction =  new Transaction();
		transaction.setRemarks("ATM");
		Mockito.when(transactionService.fundTransfer(transactionDTO)).thenReturn(transactionDTO);
		mockMvc.perform(post("/api/transfer").contentType(MediaType.APPLICATION_JSON).content(asJsonString(transactionDTO)))
		.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	}
	

