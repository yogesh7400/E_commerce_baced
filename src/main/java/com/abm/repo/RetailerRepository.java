package com.abm.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abm.entity.Retailer;

public interface RetailerRepository extends JpaRepository<Retailer, Long> {

	//login
	public Optional<Retailer> findByEmailAndPassword(String email, String password);
	
	//register
	@Query("select count(c) from Retailer c where c.email = ?1")
	public Long findIfRetailerExists(String email);
	
}
