package com.jsp.bank.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jsp.bank.entity.Account;
import com.jsp.bank.repository.AccountRespository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class AccountDao {
	
	private final AccountRespository accountRespository;
	
	public Account save(Account account)
	{
		return accountRespository.save(account);
		
	}
	
	public List<Account> findAll()
	{
		return accountRespository.findAll();
	}
	
	public Optional<Account> findByAccountNumber(long accountNumber)
	{
		return accountRespository.findByAccountNumber(accountNumber);
	}

}

