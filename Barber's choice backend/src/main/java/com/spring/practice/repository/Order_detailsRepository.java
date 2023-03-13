package com.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.practice.entities.Order_details;

public interface Order_detailsRepository extends JpaRepository<Order_details, Integer> {

}
