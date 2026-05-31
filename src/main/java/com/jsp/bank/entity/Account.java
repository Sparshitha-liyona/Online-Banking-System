package com.jsp.bank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String type;
	private long accountNumber;
	private double balance;
	@OneToOne
	@JoinColumn
	@JsonBackReference
	private User user;
	
	public Account(String type, long accountNumber, double balance, User user) {
		super();
		this.type = type;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.user = user;
	}
 
}
