package com.spring.practice.responce;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.spring.practice.entities.Product;
import com.spring.practice.entities.User;

public class ReviewDto {
	
	
	private int review_id;
	private String review;
	
private UserDto userdto;
	
	
	
	public UserDto getUserdto() {
	return userdto;
}
public void setUserdto(UserDto userdto) {
	this.userdto = userdto;
}

public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
	private Product product;
	
	public ReviewDto(int review_id, String review) {
		super();
		this.review_id = review_id;
		this.review = review;
	}
	public ReviewDto() {
		super();
		// TODO Auto-generated constructor stub
	}
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
      
}
