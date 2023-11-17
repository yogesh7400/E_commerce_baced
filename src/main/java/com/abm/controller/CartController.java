package com.abm.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abm.entity.Cart;
import com.abm.entity.CartItem;
import com.abm.entity.User;
import com.abm.exception.ProductException;
import com.abm.request.AddItemRequest;
import com.abm.service.CartServiceImplementation;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	

    private final CartServiceImplementation cartServiceImplementation;

    @Autowired
    public CartController(CartServiceImplementation cartServiceImplementation) {
        this.cartServiceImplementation = cartServiceImplementation;
    }

    @PostMapping("/create/{userId}")
    public Cart createCart(@PathVariable Long userId) {
        User user = new User();
        return cartServiceImplementation.createCart(user);
    }

    @PostMapping("/add-item/{userId}")
    public CartItem addCartItem(@PathVariable Long userId, @RequestBody AddItemRequest req) throws ProductException {
        return cartServiceImplementation.addCartItem(userId, req);
    }


    @GetMapping("/user/{userId}")
    public Cart findUserCart(@PathVariable Long userId) {
        return cartServiceImplementation.findUserCart(userId);
    }
}
