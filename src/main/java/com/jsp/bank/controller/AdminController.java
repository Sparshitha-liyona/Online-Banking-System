package com.jsp.bank.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank.entity.Account;
import com.jsp.bank.entity.Transaction;
import com.jsp.bank.entity.User;
import com.jsp.bank.service.AdminService;
import com.jsp.bank.util.ApiResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/admin/api")
@AllArgsConstructor
public class AdminController {
	
	private final AdminService adminService;
	
	@GetMapping("/users")
	public ResponseEntity<ApiResponse<List<User>>> fetchAllUsers()
	{
		return adminService.fetchAllUsers();
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<ApiResponse<List<Account>>> fetchAllAccounts()
	{
		return adminService.fetchAllAccounts();
	}
	
	@GetMapping("/transactions")
	public ResponseEntity<ApiResponse<List<Transaction>>> fetchAllTransactions()
	{
		return adminService.fetchAllTransactions();
	}
}
