package com.incture.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class SellerDTO {
	
	
	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@NotNull(message="Please enter your mobile Number")
	private String mobile;
	
	private String password;
	
}
