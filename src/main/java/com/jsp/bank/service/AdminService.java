package com.jsp.bank.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.bank.dao.AccountDao;
import com.jsp.bank.dao.TransactionDao;
import com.jsp.bank.dao.UserDao;
import com.jsp.bank.entity.Account;
import com.jsp.bank.entity.Transaction;
import com.jsp.bank.entity.User;
import com.jsp.bank.exception.ResourceNotFoundException;
import com.jsp.bank.util.ApiResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminService {
	
	private final UserDao userDao;
	private final AccountDao accountDao;
	private final TransactionDao transactionDao;
	
	public ResponseEntity<ApiResponse<List<User>>> fetchAllUsers()
	{
		List<User> list = userDao.findAll();
		if(! list.isEmpty())
		{
			ApiResponse<List<User>> apiResponse = new ApiResponse<List<User>>(HttpStatus.OK.value(), "User Fetched Successfully", list);
			return new ResponseEntity<ApiResponse<List<User>>>(apiResponse, HttpStatus.OK);
		}
		else 
			throw new ResourceNotFoundException("No Users Exist");
	}
	 
	public ResponseEntity<ApiResponse<List<Account>>> fetchAllAccounts()
	{
		List<Account> list = accountDao.findAll();
		if(! list.isEmpty())
		{
			ApiResponse<List<Account>> apiResponse = new ApiResponse<List<Account>>(HttpStatus.OK.value(), "Accounts Fetched Successfully", list);
			return new ResponseEntity<ApiResponse<List<Account>>>(apiResponse, HttpStatus.OK);
		}
		else 
			throw new ResourceNotFoundException("No Accounts Exist");
	}

	public ResponseEntity<ApiResponse<List<Transaction>>> fetchAllTransactions() {
		List<Transaction> list = transactionDao.findAll();
		if(! list.isEmpty())
		{
			ApiResponse<List<Transaction>> apiResponse = new ApiResponse<List<Transaction>>(HttpStatus.OK.value(), "Transactions Fetched Successfully", list);
			return new ResponseEntity<ApiResponse<List<Transaction>>>(apiResponse, HttpStatus.OK);
		}
		else 
			throw new ResourceNotFoundException("No Transactions Exist");
		
		
		
		
	}
	

	
}
