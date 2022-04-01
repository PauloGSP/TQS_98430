package main.java.com.lab3.Cars.repository;

/**
 * CarRepository
 */
public interface CarRepository {
    public Car findByCarId(Long id);
    public List<Car> findAll();
    
}