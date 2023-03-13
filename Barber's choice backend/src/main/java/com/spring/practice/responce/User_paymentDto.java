package com.spring.practice.responce;

import com.spring.practice.entities.User;

public class User_paymentDto {
	
	
	
	public UserDto getUserdto() {
		return userdto;
	}
	public void setUserdto(UserDto userdto) {
		this.userdto = userdto;
	}
	private int user_payment_id;
	private String provider;
	private UserDto userdto;
	
	public User_paymentDto(int user_payment_id, String provider) {
		super();
		this.user_payment_id = user_payment_id;
		this.provider = provider;
	}
	public User_paymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUser_payment_id() {
		return user_payment_id;
	}
	public void setUser_payment_id(int user_payment_id) {
		this.user_payment_id = user_payment_id;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
	

}
