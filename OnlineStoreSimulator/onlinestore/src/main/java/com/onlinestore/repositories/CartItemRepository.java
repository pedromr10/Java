package com.onlinestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinestore.entities.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
