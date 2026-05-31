package com.jsp.bank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
	
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	@Size(min = 4)
	private String password;
	private long phone;
	@NotBlank
	private String role;

}
