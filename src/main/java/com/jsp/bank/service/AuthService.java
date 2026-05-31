package com.jsp.bank.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.bank.dao.UserDao;
import com.jsp.bank.dto.LoginRequest;
import com.jsp.bank.dto.RegisterRequest;
import com.jsp.bank.entity.Account;
import com.jsp.bank.entity.User;
import com.jsp.bank.exception.InvalidCredentialsException;
import com.jsp.bank.exception.ResourceNotFoundException;
import com.jsp.bank.util.AccountUtil;
import com.jsp.bank.util.ApiResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
	
	private final UserDao userDao;
	
	public ResponseEntity<ApiResponse<User>> registerUser(RegisterRequest registerRequest)
	{
		User user = new User(registerRequest.getName(), registerRequest.getPhone() , registerRequest.getEmail(), registerRequest.getPassword(), registerRequest.getRole());
		Account account = new Account("SAVINGS", AccountUtil.generateAccountNumber(), 0, user);
		user.setAccount(account);
		User user2 = userDao.save(user);
		ApiResponse<User> apiResponse = new ApiResponse<User>(HttpStatus.CREATED.value(), "User and Account Created Successfully", user2);
		return new ResponseEntity<ApiResponse<User>>(apiResponse, HttpStatus.CREATED);
		
	}

	public ResponseEntity<ApiResponse<User>> loginUser(LoginRequest loginRequest) 
	{
		Optional<User> optional = userDao.findByEmail(loginRequest.getEmail());
		if(optional.isPresent())
		{
			User user = optional.get();
			if(! user.getPassword().equals(loginRequest.getPassword()))
			{
				throw new InvalidCredentialsException("Invalid Password");
			}
			ApiResponse<User> apiResponse = new ApiResponse<User>(HttpStatus.OK.value() , "User Successfully Logged in",user);
			return new ResponseEntity<ApiResponse<User>>(apiResponse , HttpStatus.OK);
		}
		else
			throw new ResourceNotFoundException("User With The Email Not Found");
	}
	
	

}
