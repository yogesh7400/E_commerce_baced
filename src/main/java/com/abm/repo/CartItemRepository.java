package com.abm.repo;

import com.abm.entity.Cart;
import com.abm.entity.CartItem;
import com.abm.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByUserId(Long userId);

    List<CartItem> findByProductId(Long productId);

	CartItem findByCartAndProductAndSizeAndUserId(Cart cart, Product product, String size, Long userId);
}
