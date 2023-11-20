package com.abm.service;

import com.abm.entity.Cart;
import com.abm.entity.CartItem;
import com.abm.entity.Product;
import com.abm.repo.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImplementation implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem getCartItemById(Long id) {
        Optional<CartItem> cartItemOptional = cartItemRepository.findById(id);
        return cartItemOptional.orElse(null);
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

	@Override
	public CartItem createCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}
}