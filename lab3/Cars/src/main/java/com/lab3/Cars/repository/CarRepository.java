package com.lab3.Cars.repository;

import java.util.List;

import com.lab3.Cars.models.Car;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CarRepository
 */
public interface CarRepository extends JpaRepository<Car, Integer>{
    public Car findByCarId(Long id);
    public List<Car> findAll();
    
}