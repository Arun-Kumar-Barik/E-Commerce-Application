package com.incture.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
public class Customer {
	
	public Integer getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public LocalDateTime getCreatedOn() {
		return createdOn;
	}



	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}



	public CreditCard getCreditCard() {
		return creditCard;
	}



	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}



	public Map<String, Address> getAddress() {
		return address;
	}



	public void setAddress(Map<String, Address> address) {
		this.address = address;
	}



	public List<Order> getOrders() {
		return orders;
	}



	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}



	public Cart getCustomerCart() {
		return customerCart;
	}



	public void setCustomerCart(Cart customerCart) {
		this.customerCart = customerCart;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull(message = "First Name cannot be NULL")
	private String firstName;
	
	@NotNull(message = "Last Name cannot be NULL")
	private String lastName;
	
	@NotNull(message = "Please enter the mobile Number")
	@Column(unique = true)
	private String mobileNo;
	
	
	@NotNull(message = "Please enter the emaild id")
	@Column(unique = true)
	@Email
	private String emailId;
	
	@NotNull(message = "Please enter the password")
	private String password;
	
	
	private LocalDateTime createdOn;
	
	@Embedded
	private CreditCard creditCard;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "customer_address_mapping",
				joinColumns = {
						@JoinColumn(name = "customer_id", referencedColumnName = "customerId")
				},
				inverseJoinColumns = {
						@JoinColumn(name = "address_id", referencedColumnName = "addressId")
				})
	private Map<String, Address> address = new HashMap<>();
	
	

	
	
//	Establishing Customer - Order relationship
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Order> orders = new ArrayList<>();
	
	
	
//	Establishing Customer - Cart relationship
//	
	@OneToOne(cascade = CascadeType.ALL)
	private Cart customerCart;
	
	
	
}
