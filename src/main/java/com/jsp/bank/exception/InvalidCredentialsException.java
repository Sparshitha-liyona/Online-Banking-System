package com.jsp.bank.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvalidCredentialsException extends RuntimeException {
	
	private String message;

}
