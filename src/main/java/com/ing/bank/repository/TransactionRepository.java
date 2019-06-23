package com.ing.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.bank.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long >{
	
	@Query("select t from Transaction t  where t.account.accountNumber=?1")
	List<Transaction> findByAccountNumber(@Param("number") String number);

}
