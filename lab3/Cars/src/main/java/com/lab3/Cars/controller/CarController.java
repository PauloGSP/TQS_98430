package main.java.com.lab3.Cars.controller;

/**
 * CarController
 */

@RestController
@RequestMapping("/api")
 public class CarController {

    private CarService service;

    @PostMapping("/car")
    public ResponseEntity<Car> createCar(Car car){

    }

    @PostMapping("/cars")
    public List<Cars> getAllCars(){

    }
    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCarById(Long id){

    }
}