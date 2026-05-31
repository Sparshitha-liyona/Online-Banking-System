package com.jsp.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.bank.util.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<ApiResponse<String>> handleInsufficientBalanceException(InsufficientBalanceException exception)
	{
		ApiResponse<String> apiResponse = new ApiResponse<String>(HttpStatus.CONFLICT.value() , "insufficient balance" , exception.getMessage());
		return new ResponseEntity<ApiResponse<String>>(apiResponse , HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse<String>> handleResourceNotFoundException(ResourceNotFoundException exception)
	{
		ApiResponse<String> apiResponse = new ApiResponse<String>(HttpStatus.NOT_FOUND.value() , "Not Fount" , exception.getMessage());
		return new ResponseEntity<ApiResponse<String>>(apiResponse , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ApiResponse<String>> handleInvalidCredentialsException(InvalidCredentialsException exception)
	{
		ApiResponse<String> apiResponse = new ApiResponse<String>(HttpStatus.UNAUTHORIZED.value() , "Invalid Credentials" , exception.getMessage());
		return new ResponseEntity<ApiResponse<String>>(apiResponse , HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<String>> handleValidation(MethodArgumentNotValidException exception)
	{
		ApiResponse<String> apiResponse = new ApiResponse<String>(HttpStatus.BAD_REQUEST.value() , "Validation Error", exception.getMessage());
		return new ResponseEntity<ApiResponse<String>>(apiResponse , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<String>> handleGenericException(Exception exception) 
	{
	ApiResponse<String> apiResponse = new ApiResponse<String>( HttpStatus.INTERNAL_SERVER_ERROR.value() ,"Something went Wrong" , exception.getMessage());
	return new ResponseEntity<ApiResponse<String>>(apiResponse , HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
