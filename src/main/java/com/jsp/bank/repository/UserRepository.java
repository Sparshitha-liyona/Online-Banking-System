package com.jsp.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.bank.entity.User;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);
	
	

}
