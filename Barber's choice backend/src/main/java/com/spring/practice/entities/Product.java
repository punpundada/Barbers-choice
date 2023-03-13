package com.spring.practice.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	private String product_name;
	private String photo;
	public String getPhoto() {
		return photo;
	}
	public void setPhotos(String photo) {
		this.photo = photo;
	}
	private String product_description;
	private double product_price;
	private LocalDate created_date;
	private LocalDate modified_date;
	private LocalDate Deleted_date;
	
	
	@ManyToMany
	private List<Cart> cart;
	
	@ManyToOne
	private Manufacturer manufacturer;
	
	@ManyToOne
	
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	
	private Product_category product_category;
	
	@OneToOne
	@JoinColumn(name = "discount_id")
	
	private Product_discount product_discount;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	
	private List<Review> reviews;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
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

	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Product_category getProduct_category() {
		return product_category;
	}
	public void setProduct_category(Product_category product_category) {
		this.product_category = product_category;
	}
	public Product_discount getProduct_discount() {
		return product_discount;
	}
	public void setProduct_discount(Product_discount product_discount) {
		this.product_discount = product_discount;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public List<Cart> getCart() {
		return cart;
	}
	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	
	
}
