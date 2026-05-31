package com.jsp.bank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.bank.dto.LoginRequest;
import com.jsp.bank.dto.RegisterRequest;
import com.jsp.bank.entity.User;
import com.jsp.bank.service.AuthService;
import com.jsp.bank.util.ApiResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth/api")
@AllArgsConstructor

public class AuthController {
	
	public final AuthService authService;
	
	@PostMapping("/register")
	//@valid here if you didnt use @valid then @NotBalnk @Email wont work (i.e you have mentioned on above the variables)
	public ResponseEntity<ApiResponse<User>> registerUser(@Valid @RequestBody RegisterRequest registerRequest)
	{
		return authService.registerUser(registerRequest);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse<User>> loginUser(@Valid @RequestBody LoginRequest loginRequest)
	{
		return authService.loginUser(loginRequest);
	}

}
