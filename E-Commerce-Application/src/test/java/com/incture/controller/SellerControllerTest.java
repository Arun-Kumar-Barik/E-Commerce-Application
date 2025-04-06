package com.incture.controller;

import com.incture.entities.Seller;
import com.incture.entities.SellerDTO;
import com.incture.entities.SessionDTO;
import com.incture.service.SellerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SellerControllerTest {

    @InjectMocks
    private SellerController sellerController;

    @Mock
    private SellerService sellerService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddSeller() {
        Seller seller = new Seller();
        when(sellerService.addSeller(seller)).thenReturn(seller);

        ResponseEntity<Seller> response = sellerController.addSellerHandler(seller);
        assertEquals(seller, response.getBody());
    }

    @Test
    public void testGetAllSellers() {
        List<Seller> sellerList = Arrays.asList(new Seller(), new Seller());
        when(sellerService.getAllSellers()).thenReturn(sellerList);

        ResponseEntity<List<Seller>> response = sellerController.getAllSellerHandler();
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testGetSellerById() {
        int id = 1;
        Seller seller = new Seller();
        when(sellerService.getSellerById(id)).thenReturn(seller);

        ResponseEntity<Seller> response = sellerController.getSellerByIdHandler(id);
        assertEquals(seller, response.getBody());
    }

    @Test
    public void testGetSellerByMobile() {
        String mobile = "1234567890";
        String token = "abc";
        Seller seller = new Seller();
        when(sellerService.getSellerByMobile(mobile, token)).thenReturn(seller);

        ResponseEntity<Seller> response = sellerController.getSellerByMobileHandler(mobile, token);
        assertEquals(seller, response.getBody());
    }

    @Test
    public void testGetLoggedInSeller() {
        String token = "xyz";
        Seller seller = new Seller();
        when(sellerService.getCurrentlyLoggedInSeller(token)).thenReturn(seller);

        ResponseEntity<Seller> response = sellerController.getLoggedInSellerHandler(token);
        assertEquals(seller, response.getBody());
    }

    @Test
    public void testUpdateSeller() {
        String token = "tok123";
        Seller seller = new Seller();
        when(sellerService.updateSeller(seller, token)).thenReturn(seller);

        ResponseEntity<Seller> response = sellerController.updateSellerHandler(seller, token);
        assertEquals(seller, response.getBody());
    }

    @Test
    public void testUpdateSellerMobile() {
        String token = "mob123";
        SellerDTO dto = new SellerDTO();
        Seller seller = new Seller();
        when(sellerService.updateSellerMobile(dto, token)).thenReturn(seller);

        ResponseEntity<Seller> response = sellerController.updateSellerMobileHandler(dto, token);
        assertEquals(seller, response.getBody());
    }

    @Test
    public void testUpdateSellerPassword() {
        String token = "pass123";
        SellerDTO dto = new SellerDTO();
        SessionDTO sessionDTO = new SessionDTO();

        when(sellerService.updateSellerPassword(dto, token)).thenReturn(sessionDTO);

        ResponseEntity<SessionDTO> response = sellerController.updateSellerPasswordHandler(dto, token);
        assertEquals(sessionDTO, response.getBody());
    }

    @Test
    public void testDeleteSellerById() {
        int id = 7;
        String token = "delete_token";
        Seller seller = new Seller();

        when(sellerService.deleteSellerById(id, token)).thenReturn(seller);

        ResponseEntity<Seller> response = sellerController.deleteSellerByIdHandler(id, token);
        assertEquals(seller, response.getBody());
    }
}
