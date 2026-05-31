package com.jsp.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.bank.entity.Account;
import com.jsp.bank.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	List<Transaction> findBySourceAccount_AccountNumberOrDestinationAccount_AccountNumber(long sourceAccount, long destinationAccount);
	
	
	
	

}
