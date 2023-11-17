package com.abm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abm.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

	@Query("select u from Order o join o.user u where u.id = ?1")
	List<Order> findByUser(int id);

	
}
