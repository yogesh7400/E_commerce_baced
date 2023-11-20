package com.abm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abm.entity.Order;
import com.abm.repo.OrderRepository;


@Service
public class OrderService {
	
	@Autowired
	private  OrderRepository orderRepository;
	
	public List<Order> getOrders(Integer id) {
		return orderRepository.findByUser(id);
	}

}
