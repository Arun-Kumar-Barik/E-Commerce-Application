package com.incture.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.incture.entities.Customer;
import com.incture.entities.CustomerDTO;
import com.incture.entities.Seller;
import com.incture.entities.SellerDTO;
import com.incture.entities.SessionDTO;
import com.incture.entities.UserSession;
import com.incture.service.CustomerService;
import com.incture.service.LoginLogoutService;
import com.incture.service.SellerService;

@RestController
public class LoginController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private LoginLogoutService loginService;
	
	@Autowired
	private SellerService sellerService;

	
	// Handler to register a new customer
	
	@PostMapping(value = "/register/customer", consumes = "application/json")
	public ResponseEntity<Customer> registerAccountHandler(@Valid @RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}
	
	// Handler to login a user
	
	@PostMapping(value = "/login/customer", consumes = "application/json")
	public ResponseEntity<UserSession> loginCustomerHandler(@Valid @RequestBody CustomerDTO customerdto){
		return new ResponseEntity<>(loginService.loginCustomer(customerdto), HttpStatus.ACCEPTED);
	}
	
	
	// Handler to logout a user
	
	@PostMapping(value = "/logout/customer", consumes = "application/json")
	public ResponseEntity<SessionDTO> logoutCustomerHandler(@RequestBody SessionDTO sessionToken){
		return new ResponseEntity<>(loginService.logoutCustomer(sessionToken), HttpStatus.ACCEPTED);
	}
	
	
	
	
	/*********** SELLER REGISTER LOGIN LOGOUT HANDLER ************/
	
	@PostMapping(value = "/register/seller", consumes = "application/json")
	public ResponseEntity<Seller> registerSellerAccountHandler(@Valid @RequestBody Seller seller) {
		return new ResponseEntity<>(sellerService.addSeller(seller), HttpStatus.CREATED);
	}
	
	
	// Handler to login a user
	
	@PostMapping(value = "/login/seller", consumes = "application/json")
	public ResponseEntity<UserSession> loginSellerHandler(@Valid @RequestBody SellerDTO seller){
		return new ResponseEntity<>(loginService.loginSeller(seller), HttpStatus.ACCEPTED);
	}
		
		
	// Handler to logout a user
		
	@PostMapping(value = "/logout/seller", consumes = "application/json")
	public ResponseEntity<SessionDTO> logoutSellerHandler(@RequestBody SessionDTO sessionToken){
		return new ResponseEntity<>(loginService.logoutSeller(sessionToken), HttpStatus.ACCEPTED);
	}
	
}
