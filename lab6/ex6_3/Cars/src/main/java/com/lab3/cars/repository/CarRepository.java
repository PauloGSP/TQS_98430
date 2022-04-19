package com.lab3.cars.repository;

import java.util.List;

import com.lab3.cars.models.Car;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * CarRepository
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
    public Car findByCarId(Long id);
    public List<Car> findAll();
    
}