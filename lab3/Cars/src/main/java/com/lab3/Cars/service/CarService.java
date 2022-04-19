package com.lab3.Cars.service;

import java.util.List;

import com.lab3.Cars.models.Car;
import com.lab3.Cars.repository.CarRepository;

import org.springframework.stereotype.Service;

/**
 * CarService
 */
@Service
public class CarService {

    private CarRepository repository;

    public Car save(Car car) {

        return repository.save(car);
    }
    public List<Car> getAllCars(){
        return repository.findAll();
    }

    public Car getCarDetails(Long id){
        return repository.findByCarId(id);
    }

}