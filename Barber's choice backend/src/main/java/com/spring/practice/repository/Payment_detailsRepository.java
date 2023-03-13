package com.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.practice.entities.Payment_details;

public interface Payment_detailsRepository extends JpaRepository<Payment_details, Integer> {

}
