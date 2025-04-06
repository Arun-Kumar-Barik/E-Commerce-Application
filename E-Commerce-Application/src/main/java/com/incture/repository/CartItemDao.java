package com.incture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.incture.entities.CartItem;

public interface CartItemDao extends JpaRepository<CartItem, Integer>{

}
