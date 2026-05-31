package com.jsp.bank.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.bank.dao.AccountDao;
import com.jsp.bank.dao.TransactionDao;
import com.jsp.bank.dto.TransactionRequest;
import com.jsp.bank.entity.Account;
import com.jsp.bank.entity.Transaction;
import com.jsp.bank.exception.InsufficientBalanceException;
import com.jsp.bank.exception.ResourceNotFoundException;
import com.jsp.bank.util.ApiResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionService {
	
	private final AccountDao accountDao;
	private final TransactionDao transactionDao;

	public ResponseEntity<ApiResponse<Double>> deposit(TransactionRequest transactionRequest)
	{
		Optional<Account> optional = accountDao.findByAccountNumber(transactionRequest.getSourceAccountNumber());
		if(optional.isPresent())
		{
			Account account = optional.get();
			account.setBalance(account.getBalance() + transactionRequest.getAmount());
			
			Transaction transaction = new Transaction("DEPOSIT", transactionRequest.getAmount(), LocalDate.now(), account,null,"SUCCESS");
			Account acc = accountDao.save(account);
			transactionDao.save(transaction);
			ApiResponse<Double> apiResponse = new ApiResponse<Double>(HttpStatus.CREATED.value(), "Amount Successfully Deposited", acc.getBalance());
			return new ResponseEntity<ApiResponse<Double>>(apiResponse, HttpStatus.CREATED);
		}
		else
			throw new ResourceNotFoundException("Account Not Found");
	}

	public ResponseEntity<ApiResponse<Double>> withDraw(TransactionRequest transactionRequest) {
		Optional<Account> optional = accountDao.findByAccountNumber(transactionRequest.getSourceAccountNumber());
		if(optional.isPresent())
		{
			Account account = optional.get();
			if(transactionRequest.getAmount() > account.getBalance())
			{
				throw new InsufficientBalanceException("Request Amount Is More Than The Original Balance");
			}
			account.setBalance(account.getBalance() - transactionRequest.getAmount());
			
			Transaction transaction = new Transaction("WITHDRAW", transactionRequest.getAmount(), LocalDate.now(), account,null,"SUCCESS");
			Account acc = accountDao.save(account);
			transactionDao.save(transaction);
			ApiResponse<Double> apiResponse = new ApiResponse<Double>(HttpStatus.CREATED.value(), "Amount Successfully withdrawn", acc.getBalance());
			return new ResponseEntity<ApiResponse<Double>>(apiResponse, HttpStatus.CREATED);
		}
		else
			throw new ResourceNotFoundException("Account Not Found");
		
	}

	public ResponseEntity<ApiResponse<Double>> transfer(TransactionRequest transactionRequest) 
	{
		Optional<Account> optional1 = accountDao.findByAccountNumber(transactionRequest.getSourceAccountNumber());
		Optional<Account> optional2 = accountDao.findByAccountNumber(transactionRequest.getDestinationAccountNumber());
		if(optional1.isPresent() && optional2.isPresent())
		{
			Account sender = optional1.get();
			Account receiver = optional2.get();
			
			if(transactionRequest.getAmount() > sender.getBalance())
			{
				throw new InsufficientBalanceException("Request Amount Is More Than The Original Balance");
			}
			sender.setBalance(sender.getBalance() - transactionRequest.getAmount());
			receiver.setBalance(receiver.getBalance() + transactionRequest.getAmount());
			
			Transaction transaction = new Transaction("TRANSFER",transactionRequest.getAmount(), LocalDate.now(), sender, receiver,"SUCCESS");
			Account acc = accountDao.save(sender);
			accountDao.save(receiver);
			transactionDao.save(transaction);
			ApiResponse<Double> apiResponse = new ApiResponse<Double>(HttpStatus.CREATED.value(), "Amount Successfully Transferred", acc.getBalance());
			return new ResponseEntity<ApiResponse<Double>>(apiResponse, HttpStatus.CREATED);
		}
		else
			throw new ResourceNotFoundException("Account Not Found");
		 
	}

	public ResponseEntity<ApiResponse<List<Transaction>>> fetchTransactionHistory(long accountNumber) 
	{
		List<Transaction> list = transactionDao.findBySourceOrDestinationAccount(accountNumber, accountNumber);
		ApiResponse<List<Transaction>> apiResponse = new ApiResponse<List<Transaction>>(HttpStatus.OK.value(), "Transaction History Fetched Successfully", list);
		return new ResponseEntity<ApiResponse<List<Transaction>>>(apiResponse, HttpStatus.OK);
	
	}

}
