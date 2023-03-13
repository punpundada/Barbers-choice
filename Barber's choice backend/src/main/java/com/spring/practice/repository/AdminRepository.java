package com.spring.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.practice.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
