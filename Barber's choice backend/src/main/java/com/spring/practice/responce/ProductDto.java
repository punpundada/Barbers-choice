package com.spring.practice.responce;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.spring.practice.entities.Brand;
import com.spring.practice.entities.Cart;
import com.spring.practice.entities.Manufacturer;
import com.spring.practice.entities.Product_category;
import com.spring.practice.entities.Product_discount;
import com.spring.practice.entities.Review;



public class ProductDto {
	
	
	private int product_id;
	private String product_name;
	private String product_description;
	private double product_price;
	private LocalDate created_date;
	private LocalDate modified_date;
	private LocalDate Deleted_date;
	
	
	
	

	
	private List<CartDto> cartdto;
	
	
	private ManfactureDto manufacturerDto;
	
	
	
	private BrandDto branddto;
	
	
	
	private Product_categoryDto product_categoryDto;
	
	
	
	private Product_discountDto product_discountDto;
	
	
	
	public List<CartDto> getCartdto() {
		return cartdto;
	}
	public void setCartdto(List<CartDto> cartdto) {
		this.cartdto = cartdto;
	}
	public ManfactureDto getManufacturerDto() {
		return manufacturerDto;
	}
	public void setManufacturerDto(ManfactureDto manufacturerDto) {
		this.manufacturerDto = manufacturerDto;
	}
	public BrandDto getBranddto() {
		return branddto;
	}
	public void setBranddto(BrandDto branddto) {
		this.branddto = branddto;
	}
	public Product_categoryDto getProduct_categoryDto() {
		return product_categoryDto;
	}
	public void setProduct_categoryDto(Product_categoryDto product_categoryDto) {
		this.product_categoryDto = product_categoryDto;
	}
	public Product_discountDto getProduct_discountDto() {
		return product_discountDto;
	}
	public void setProduct_discountDto(Product_discountDto product_discountDto) {
		this.product_discountDto = product_discountDto;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	private List<Review> reviews;
	
	public ProductDto(int product_id, String product_name, String product_description, double product_price,
			LocalDate created_date, LocalDate modified_date, LocalDate deleted_date) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_description = product_description;
		this.product_price = product_price;
		this.created_date = created_date;
		this.modified_date = modified_date;
		Deleted_date = deleted_date;
	}
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	
	

}
