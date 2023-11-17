package com.abm.service;

import com.abm.entity.Cart;
import com.abm.entity.CartItem;
import com.abm.entity.Product;

import java.util.List;

public interface CartItemService {
    CartItem saveCartItem(CartItem cartItem);

    List<CartItem> getAllCartItems();

    CartItem getCartItemById(Long id);

    void deleteCartItem(Long id);

	CartItem createCartItem(CartItem cartItem);

	CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);
}
