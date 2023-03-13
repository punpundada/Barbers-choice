package com.spring.practice.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_Id;
	@NotEmpty
	@Size(min =3,max=25,message = "Last name should be between 3 and 15")
	private String namelast;
	@NotEmpty
	@Size(min =3,max=25,message = "first name should be between 3 and 15")
	private String namefirst;

	
	
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Cart cart;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Admin> admins;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Review review;
	@
	OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<User_payment> user_payments;
	
	@OneToOne
	@JoinColumn(name = "login_id")
	@JsonIgnore
	private Login login;
	
	
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private User_address user_address;
	
	
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private User_website_feedback user_web_feed;
	
	
	

	public User(int user_Id, String namelast, String namefirst, Cart cart, List<Admin> admins, Review review,
			List<User_payment> user_payments) {
		super();
		this.user_Id = user_Id;
		this.namelast = namelast;
		this.namefirst = namefirst;
		this.cart = cart;
		this.admins = admins;
		this.review = review;
		this.user_payments = user_payments;
	}
	public User() {
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

	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public List<Admin> getAdmins() {
		return admins;
	}
	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}
	public Review getReview() {
		return review;
	}
	public void setReview(Review review) {
		this.review = review;
	}
	public List<User_payment> getUser_payments() {
		return user_payments;
	}
	public void setUser_payments(List<User_payment> user_payments) {
		this.user_payments = user_payments;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	
}
