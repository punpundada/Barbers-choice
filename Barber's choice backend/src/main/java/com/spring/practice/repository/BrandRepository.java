package com.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.practice.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
