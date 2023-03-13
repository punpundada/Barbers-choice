package com.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.practice.entities.Product_category;

public interface Product_Category_Repository extends JpaRepository<Product_category, Integer>{

}
