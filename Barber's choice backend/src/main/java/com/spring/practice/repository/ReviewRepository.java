package com.spring.practice.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.practice.entities.Review;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

}
