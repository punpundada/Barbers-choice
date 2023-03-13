package com.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.practice.entities.Cart;
import com.spring.practice.entities.Login;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
