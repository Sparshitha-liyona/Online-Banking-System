package com.jsp.bank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
	
	@Email //email validation
	@NotBlank
	private String email;
	@NotBlank //because password can not be null
	private String password;

}
