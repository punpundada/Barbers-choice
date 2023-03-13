package com.spring.practice.service;

import java.util.List;

import com.spring.practice.entities.Product_category;
import com.spring.practice.responce.Product_categoryDto;

public interface Product_Category_Service {
	Product_categoryDto saveProduct_category(Product_categoryDto product_cat);
	List<Product_categoryDto> getAllAProduct_category();
	Product_categoryDto getProduct_categoryById(int id);
	Product_categoryDto updateProduct_category(Product_categoryDto product_cat, int id);
	void deleteProduct_category(int id);
	
	

}
