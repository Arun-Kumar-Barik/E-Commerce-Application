package com.incture.service;

import com.incture.entities.CartDTO;
import com.incture.entities.CartItem;

public interface CartItemService {
	
	public CartItem createItemforCart(CartDTO cartdto);
	
}
