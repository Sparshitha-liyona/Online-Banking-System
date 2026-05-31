package com.jsp.bank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {
	
	@NotNull
	private long sourceAccountNumber;
	private long destinationAccountNumber;
	@Positive
	@NotNull
	private double amount;

}
