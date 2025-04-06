package com.incture.controller;

import com.incture.entities.*;
import com.incture.service.CustomerService;
import com.incture.service.LoginLogoutService;
import com.incture.service.SellerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private CustomerService customerService;

    @Mock
    private SellerService sellerService;

    @Mock
    private LoginLogoutService loginService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    // CUSTOMER TESTS

    @Test
    public void testRegisterCustomer() {
        Customer customer = new Customer();
        when(customerService.addCustomer(customer)).thenReturn(customer);

        ResponseEntity<Customer> response = loginController.registerAccountHandler(customer);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    public void testLoginCustomer() {
        CustomerDTO dto = new CustomerDTO();
        UserSession session = new UserSession();
        when(loginService.loginCustomer(dto)).thenReturn(session);

        ResponseEntity<UserSession> response = loginController.loginCustomerHandler(dto);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(session, response.getBody());
    }

    @Test
    public void testLogoutCustomer() {
        SessionDTO dto = new SessionDTO();
        when(loginService.logoutCustomer(dto)).thenReturn(dto);

        ResponseEntity<SessionDTO> response = loginController.logoutCustomerHandler(dto);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(dto, response.getBody());
    }

    // SELLER TESTS

    @Test
    public void testRegisterSeller() {
        Seller seller = new Seller();
        when(sellerService.addSeller(seller)).thenReturn(seller);

        ResponseEntity<Seller> response = loginController.registerSellerAccountHandler(seller);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(seller, response.getBody());
    }

    @Test
    public void testLoginSeller() {
        SellerDTO sellerDTO = new SellerDTO();
        UserSession session = new UserSession();
        when(loginService.loginSeller(sellerDTO)).thenReturn(session);

        ResponseEntity<UserSession> response = loginController.loginSellerHandler(sellerDTO);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(session, response.getBody());
    }

    @Test
    public void testLogoutSeller() {
        SessionDTO dto = new SessionDTO();
        when(loginService.logoutSeller(dto)).thenReturn(dto);

        ResponseEntity<SessionDTO> response = loginController.logoutSellerHandler(dto);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(dto, response.getBody());
    }
}
