package com.jsp.bank.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.jsp.bank.entity.User;
import com.jsp.bank.repository.UserRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserDao {
	
	private final UserRepository userRepository;
	
	public User save(User user)
	{
		return userRepository.save(user);
	}
	
	public List<User> findAll()
	{
		return userRepository.findAll();
	}
	
	public Optional<User> findByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}
	

}
