package com.jsp.bank.dao;

import com.jsp.bank.repository.AccountRespository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsp.bank.entity.Account;
import com.jsp.bank.entity.Transaction;
import com.jsp.bank.repository.TransactionRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class TransactionDao {

	private final TransactionRepository transactionRepository;
	
	
	public Transaction save(Transaction transaction)
	{
		return transactionRepository.save(transaction);
	}
	
	public List<Transaction> findAll()
	{
		return transactionRepository.findAll();
	}
	
	public List<Transaction> findBySourceOrDestinationAccount(long sourceAccount , long destinationAccount)
	{
		return transactionRepository.findBySourceAccount_AccountNumberOrDestinationAccount_AccountNumber(sourceAccount, destinationAccount);
	}

}
