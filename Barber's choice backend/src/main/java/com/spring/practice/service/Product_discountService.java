package com.spring.practice.service;

import java.util.List;


import com.spring.practice.entities.Product_discount;
import com.spring.practice.responce.Product_discountDto;

public interface Product_discountService {
	

	Product_discountDto saveProduct_discount(Product_discountDto product_discDto);
	List<Product_discountDto> getAllProduct_discount();
	Product_discountDto getProduct_discountById(int id);
	Product_discountDto updateProduct_discount(Product_discountDto product_discDto, int id);
	void deleteProduct_discount(int id);
	

}
