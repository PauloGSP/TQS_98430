package com.lab3.cars.controller;

import java.util.List;
import com.lab3.cars.models.CarRequest;

import com.lab3.cars.models.Car;
import com.lab3.cars.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
/**
 * CarController
 */

@RestController
@RequestMapping("/api")
 public class CarController {
    @Autowired(required = true)
    private CarService service;

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar (@RequestBody CarRequest car) {
        return new ResponseEntity<>(service.save(new Car(car.getMaker(), car.getModel())), HttpStatus.CREATED);
      }

    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return service.getAllCars();
    }
    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
        Car car = service.getCarDetails(id);
        return new ResponseEntity<>( car, HttpStatus.OK );
    }
}
