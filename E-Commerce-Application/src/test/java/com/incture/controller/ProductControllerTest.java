package com.incture.controller;

import com.incture.entities.*;
import com.incture.service.ProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddProductToCatalog() {
        Product product = new Product();
        String token = "abc";
        when(productService.addProductToCatalog(token, product)).thenReturn(product);

        ResponseEntity<Product> response = productController.addProductToCatalogHandler(token, product);

        assertEquals(product, response.getBody());
    }

    @Test
    public void testGetProductFromCatalogById() {
        int id = 1;
        Product product = new Product();
        when(productService.getProductFromCatalogById(id)).thenReturn(product);

        ResponseEntity<Product> response = productController.getProductFromCatalogByIdHandler(id);

        assertEquals(product, response.getBody());
    }

    @Test
    public void testDeleteProductFromCatalog() {
        int id = 101;
        String msg = "Product Deleted";
        when(productService.deleteProductFromCatalog(id)).thenReturn(msg);

        ResponseEntity<String> response = productController.deleteProductFromCatalogHandler(id);

        assertEquals(msg, response.getBody());
    }

    @Test
    public void testUpdateProductInCatalog() {
        Product product = new Product();
        when(productService.updateProductIncatalog(product)).thenReturn(product);

        ResponseEntity<Product> response = productController.updateProductInCatalogHandler(product);

        assertEquals(product, response.getBody());
    }

    @Test
    public void testGetAllProducts() {
        List<Product> list = List.of(new Product(), new Product());
        when(productService.getAllProductsIncatalog()).thenReturn(list);

        ResponseEntity<List<Product>> response = productController.getAllProductsHandler();

        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetAllProductsOfSeller() {
        int sellerId = 11;
        List<ProductDTO> dtoList = List.of(new ProductDTO());
        when(productService.getAllProductsOfSeller(sellerId)).thenReturn(dtoList);

        ResponseEntity<List<ProductDTO>> response = productController.getAllProductsOfSellerHandler(sellerId);

        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testGetAllProductsInCategory() {
        String category = "electronics";
        List<ProductDTO> dtoList = List.of(new ProductDTO());

        when(productService.getProductsOfCategory(CategoryEnum.ELECTRONICS)).thenReturn(dtoList);

        ResponseEntity<List<ProductDTO>> response = productController.getAllProductsInCategory(category);

        assertEquals(dtoList, response.getBody());
    }

    @Test
    public void testGetProductsWithStatus() {
        String status = "available";
        List<ProductDTO> dtoList = List.of(new ProductDTO());

        when(productService.getProductsOfStatus(ProductStatus.AVAILABLE)).thenReturn(dtoList);

        ResponseEntity<List<ProductDTO>> response = productController.getProductsWithStatusHandler(status);

        assertEquals(dtoList, response.getBody());
    }

    @Test
    public void testUpdateQuantityOfProduct() {
        int id = 10;
        ProductDTO dto = new ProductDTO();
        Product updatedProduct = new Product();

        when(productService.updateProductQuantityWithId(id, dto)).thenReturn(updatedProduct);

        ResponseEntity<Product> response = productController.updateQuantityOfProduct(id, dto);

        assertEquals(updatedProduct, response.getBody());
    }
}
