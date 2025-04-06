package com.incture.controller;

import com.incture.entities.Cart;
import com.incture.entities.CartDTO;
import com.incture.service.CartService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

public class CartControllerTest {

    @Mock
    private CartService cartService;

    @InjectMocks
    private CartController cartController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddProductToCart() {
        CartDTO dto = new CartDTO();
        dto.setProductId(1);
        dto.setQuantity(2);

        Cart dummyCart = new Cart();

        when(cartService.addProductToCart(dto, "token123")).thenReturn(dummyCart);

        ResponseEntity<Cart> response = cartController.addProductToCartHander(dto, "token123");

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(dummyCart, response.getBody());
    }

    @Test
    public void testGetCartProduct() {
        Cart dummyCart = new Cart();
        when(cartService.getCartProduct("token123")).thenReturn(dummyCart);

        ResponseEntity<Cart> response = cartController.getCartProductHandler("token123");

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(dummyCart, response.getBody());
    }

    @Test
    public void testRemoveProductFromCart() {
        CartDTO dto = new CartDTO();
        dto.setProductId(1);
        dto.setQuantity(1);

        Cart dummyCart = new Cart();

        when(cartService.removeProductFromCart(dto, "token123")).thenReturn(dummyCart);

        ResponseEntity<Cart> response = cartController.removeProductFromCartHander(dto, "token123");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(dummyCart, response.getBody());
    }

    @Test
    public void testClearCart() {
        Cart dummyCart = new Cart();
        when(cartService.clearCart("token123")).thenReturn(dummyCart);

        ResponseEntity<Cart> response = cartController.clearCartHandler("token123");

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(dummyCart, response.getBody());
    }
}
