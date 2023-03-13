package com.spring.practice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int review_id;
	private String review;
	
	@OneToOne
	@JoinColumn(name = "User_id")
	
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "Product_id")
	
	private Product product;

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Review(int review_id, String review, User user, Product product) {
		super();
		this.review_id = review_id;
		this.review = review;
		this.user = user;
		this.product = product;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
