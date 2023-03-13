package com.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.practice.entities.Product_discount;

public interface Product_discountRepository extends JpaRepository<Product_discount, Integer> {

}
