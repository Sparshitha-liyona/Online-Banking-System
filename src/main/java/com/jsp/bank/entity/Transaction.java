package com.jsp.bank.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private double amount;
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "source_account_id")
	private Account sourceAccount;
	@ManyToOne
	@JoinColumn(name = "destination_account_id")
	private Account destinationAccount;
	private String status;
	
	public Transaction(String type, double amount, LocalDate date, Account sourceAccount, Account destinationAccount,
			String status) {
		super();
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.sourceAccount = sourceAccount;
		this.destinationAccount = destinationAccount;
		this.status = status;
	}
	
	
	
   
}
