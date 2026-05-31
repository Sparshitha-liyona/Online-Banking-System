package com.jsp.bank.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long phone;
	private String email;
	private String password;
	private String role;
	@OneToOne(mappedBy = "user" , cascade = CascadeType.ALL)
	@JsonManagedReference
	private Account account;
	
	public User(String name, long phone, String email, String password, String role) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.role = role;
		
	}
	
	

}
