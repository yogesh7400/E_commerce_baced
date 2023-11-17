package com.abm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abm.entity.Order;
import com.abm.repo.OrderRepository;
import com.abm.service.OrderService;


@Controller
@CrossOrigin
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/orders")
	public List<Order> get(@RequestParam Integer id) {
		return orderService.getOrders(id);
	}
	
	
	
	
	

}
