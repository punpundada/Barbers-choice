package com.spring.practice.responce;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.spring.practice.entities.Admin;
import com.spring.practice.entities.Cart;
import com.spring.practice.entities.Login;
import com.spring.practice.entities.Review;
import com.spring.practice.entities.User_address;
import com.spring.practice.entities.User_payment;
import com.spring.practice.entities.User_website_feedback;

public class UserDto {
	
	
	private int user_Id;
	
	private String namelast;

	private String namefirst;
	
	private CartDto cartdto;
	
	private List<AdminDto> adminsDto;
	
	private ReviewDto reviewDto;
	
	private List<User_paymentDto> user_paymentsDto;
	
	
	private User_AddressDto user_addressDto;
	
	private User_website_feedbackDto user_web_feedDto;
	
	private LoginDto loginDto;

	
	public LoginDto getLoginDto() {
		return loginDto;
	}

	public void setLoginDto(LoginDto loginDto) {
		this.loginDto = loginDto;
	}

	public CartDto getCartdto() {
		return cartdto;
	}

	public void setCartdto(CartDto cartdto) {
		this.cartdto = cartdto;
	}

	public List<AdminDto> getAdminsDto() {
		return adminsDto;
	}

	public void setAdminsDto(List<AdminDto> adminsDto) {
		this.adminsDto = adminsDto;
	}

	public ReviewDto getReviewDto() {
		return reviewDto;
	}

	public void setReviewDto(ReviewDto reviewDto) {
		this.reviewDto = reviewDto;
	}

	public List<User_paymentDto> getUser_paymentsDto() {
		return user_paymentsDto;
	}

	public void setUser_paymentsDto(List<User_paymentDto> user_paymentsDto) {
		this.user_paymentsDto = user_paymentsDto;
	}



	public User_AddressDto getUser_addressDto() {
		return user_addressDto;
	}

	public void setUser_addressDto(User_AddressDto user_addressDto) {
		this.user_addressDto = user_addressDto;
	}

	public User_website_feedbackDto getUser_web_feedDto() {
		return user_web_feedDto;
	}

	public void setUser_web_feedDto(User_website_feedbackDto user_web_feedDto) {
		this.user_web_feedDto = user_web_feedDto;
	}

	public UserDto(int user_Id, String namelast, String namefirst) {
		super();
		this.user_Id = user_Id;
		this.namelast = namelast;
		this.namefirst = namefirst;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getNamelast() {
		return namelast;
	}

	public void setNamelast(String namelast) {
		this.namelast = namelast;
	}

	public String getNamefirst() {
		return namefirst;
	}

	public void setNamefirst(String namefirst) {
		this.namefirst = namefirst;
	}

	
	
}
