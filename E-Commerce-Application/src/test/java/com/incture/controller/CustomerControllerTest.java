package com.incture.controller;

import com.incture.entities.*;
import com.incture.service.CustomerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());

        when(customerService.getAllCustomers("token123")).thenReturn(customers);

        ResponseEntity<List<Customer>> response = customerController.getAllCustomersHandler("token123");

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(customers, response.getBody());
    }

    @Test
    public void testGetLoggedInCustomerDetails() {
        Customer customer = new Customer();
        when(customerService.getLoggedInCustomerDetails("token123")).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.getLoggedInCustomerDetailsHandler("token123");

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    public void testUpdateCustomer() {
        CustomerUpdateDTO dto = new CustomerUpdateDTO();
        Customer customer = new Customer();

        when(customerService.updateCustomer(dto, "token123")).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.updateCustomerHandler(dto, "token123");

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    public void testUpdateMobileOrEmail() {
        CustomerUpdateDTO dto = new CustomerUpdateDTO();
        Customer customer = new Customer();

        when(customerService.updateCustomerMobileNoOrEmailId(dto, "token123")).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.updateCustomerMobileEmailHandler(dto, "token123");

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    public void testUpdatePassword() {
        CustomerDTO dto = new CustomerDTO();
        SessionDTO session = new SessionDTO();

        when(customerService.updateCustomerPassword(dto, "token123")).thenReturn(session);

        ResponseEntity<SessionDTO> response = customerController.updateCustomerPasswordHandler(dto, "token123");

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(session, response.getBody());
    }

    @Test
    public void testUpdateAddress() {
        Address address = new Address();
        Customer customer = new Customer();

        when(customerService.updateAddress(address, "home", "token123")).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.updateAddressHandler(address, "home", "token123");

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    public void testUpdateCreditCard() {
        CreditCard card = new CreditCard();
        Customer customer = new Customer();

        when(customerService.updateCreditCardDetails("token123", card)).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.updateCreditCardHandler("token123", card);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    public void testDeleteAddress() {
        Customer customer = new Customer();

        when(customerService.deleteAddress("home", "token123")).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.deleteAddressHandler("home", "token123");

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    public void testDeleteCustomer() {
        CustomerDTO dto = new CustomerDTO();
        SessionDTO session = new SessionDTO();

        when(customerService.deleteCustomer(dto, "token123")).thenReturn(session);

        ResponseEntity<SessionDTO> response = customerController.deleteCustomerHandler(dto, "token123");

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(session, response.getBody());
    }

    @Test
    public void testGetCustomerOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());

        when(customerService.getCustomerOrders("token123")).thenReturn(orders);

        ResponseEntity<List<Order>> response = customerController.getCustomerOrdersHandler("token123");

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(orders, response.getBody());
    }
}
