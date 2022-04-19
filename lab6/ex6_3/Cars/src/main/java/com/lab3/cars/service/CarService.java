package com.lab3.cars.service;

import java.util.List;

import com.lab3.cars.models.Car;
import com.lab3.cars.repository.CarRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * CarService
 */
@Service
public class CarService {

    @Autowired 
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