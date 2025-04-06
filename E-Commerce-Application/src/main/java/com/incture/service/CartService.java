package com.incture.service;

import java.util.List;

import com.incture.controller.ProductNotFound;
import com.incture.entities.Cart;
import com.incture.entities.CartDTO;
import com.incture.entities.CartItem;
import com.incture.exception.CartItemNotFound;




public interface CartService {
	
	public Cart addProductToCart(CartDTO cart, String token) throws CartItemNotFound;
	public Cart getCartProduct(String token);
	public Cart removeProductFromCart(CartDTO cartDto,String token) throws ProductNotFound;
//	public Cart changeQuantity(Product product,Customer customer,Integer quantity);
	
	public Cart clearCart(String token);
	
}
