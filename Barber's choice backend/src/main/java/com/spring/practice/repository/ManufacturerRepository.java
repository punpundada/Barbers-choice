package com.spring.practice.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.practice.entities.Manufacturer;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Integer> {

}
