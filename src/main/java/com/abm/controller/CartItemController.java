package com.abm.controller;

import com.abm.entity.CartItem;
import com.abm.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartItems")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public CartItem saveCartItem(@RequestBody CartItem cartItem) {
        return cartItemService.saveCartItem(cartItem);
    }

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @GetMapping("/{id}")
    public CartItem getCartItemById(@PathVariable Long id) {
        return cartItemService.getCartItemById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
    }
    
    @PutMapping("/update/{id}")
    public CartItem updateCartItem(@PathVariable Long id, @RequestBody CartItem updatedCartItem) {
        CartItem existingCartItem = cartItemService.getCartItemById(id);

        if (existingCartItem != null) {
            // Update the existing cart item with the new information
            existingCartItem.setCart(updatedCartItem.getCart());
            existingCartItem.setQuantity(updatedCartItem.getQuantity());
           

            return cartItemService.saveCartItem(existingCartItem); 
        } else {
           
            return null; 
        }
    }

   
}
