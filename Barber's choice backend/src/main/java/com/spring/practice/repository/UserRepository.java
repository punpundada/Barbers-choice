package com.spring.practice.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.practice.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
