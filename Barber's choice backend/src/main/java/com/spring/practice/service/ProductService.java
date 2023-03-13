package com.spring.practice.service;

import java.util.List;

import com.spring.practice.entities.Product;
import com.spring.practice.responce.ProductDto;

public interface ProductService {
	
	ProductDto saveProduct(ProductDto productDto);
	List<ProductDto> getAllProducts();
	ProductDto getProductById(int id);
	ProductDto updateProduct(ProductDto productDto, int id);
	void deleteProduct(int id);
	


}
