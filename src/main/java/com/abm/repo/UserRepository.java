package com.abm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abm.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	 
	public User findByEmail(String email);

}
