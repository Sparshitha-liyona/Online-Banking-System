package com.jsp.bank.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank.dto.TransactionRequest;
import com.jsp.bank.entity.Account;
import com.jsp.bank.entity.Transaction;
import com.jsp.bank.service.TransactionService;
import com.jsp.bank.util.ApiResponse;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/transaction/api")
@AllArgsConstructor
public class TransactionController {
	
	private final TransactionService transactionService;
	
	@PostMapping("/deposit")
	public ResponseEntity<ApiResponse<Double>> deposit(@Valid @RequestBody TransactionRequest transactionRequest)
	{
		return transactionService.deposit(transactionRequest);
	}
	
	@PostMapping("/withdraw")
	public ResponseEntity<ApiResponse<Double>> withDraw(@Valid @RequestBody TransactionRequest transactionRequest)
	{
		return transactionService.withDraw(transactionRequest);
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<ApiResponse<Double>> transfer(@Valid @RequestBody TransactionRequest transactionRequest)
	{
		return transactionService.transfer(transactionRequest);
	}
	
	@GetMapping("/history/{accountNumber}")
	public ResponseEntity<ApiResponse<List<Transaction>>> fetchTransactionHistory(@PathVariable long accountNumber)
	{
		return transactionService.fetchTransactionHistory(accountNumber);
	}
	
	

}
