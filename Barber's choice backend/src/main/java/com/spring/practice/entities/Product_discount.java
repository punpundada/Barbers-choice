package com.spring.practice.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Product_discount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_discount_id;
	private String product_discount_name;
	private double product_discount_percentage;
	private boolean product_discount_isActive;
	private LocalDate created_date;
	private LocalDate modified_date;
	private LocalDate Deleted_date;

	@OneToOne(mappedBy = "product_discount",cascade = CascadeType.ALL)
	
	private Product products;

	public int getProduct_discount_id() {
		return product_discount_id;
	}

	public void setProduct_discount_id(int product_discount_id) {
		this.product_discount_id = product_discount_id;
	}

	public String getProduct_discount_name() {
		return product_discount_name;
	}

	public void setProduct_discount_name(String product_discount_name) {
		this.product_discount_name = product_discount_name;
	}

	public double getProduct_discount_percentage() {
		return product_discount_percentage;
	}

	public void setProduct_discount_percentage(double product_discount_percentage) {
		this.product_discount_percentage = product_discount_percentage;
	}

	public boolean isProduct_discount_isActive() {
		return product_discount_isActive;
	}

	public void setProduct_discount_isActive(boolean product_discount_isActive) {
		this.product_discount_isActive = product_discount_isActive;
	}

	public LocalDate getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}

	public LocalDate getModified_date() {
		return modified_date;
	}

	public void setModified_date(LocalDate modified_date) {
		this.modified_date = modified_date;
	}

	public LocalDate getDeleted_date() {
		return Deleted_date;
	}

	public void setDeleted_date(LocalDate deleted_date) {
		Deleted_date = deleted_date;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}
	
	
}
