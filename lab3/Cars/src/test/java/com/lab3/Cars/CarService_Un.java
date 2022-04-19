package com.lab3.Cars;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lab3.Cars.models.Car;
import com.lab3.Cars.service.CarService;
import com.lab3.Cars.repository.CarRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CarService_Un {
    



    @Mock(lenient = true)
    private CarRepository carRepository;

    @InjectMocks
    private CarService carManagerService;

    @BeforeEach
    public void setUp() {

        Car c1 = new Car("Opel", "Corsa");
        Car c2 = new Car("Volkswagen", "Golf");
        c1.setCarID(1L);
        c2.setCarID(2L);

        List<Car> allCars = Arrays.asList(c1, c2);

        Mockito.when( carRepository.findByCarId( c1.getCarID() ) ).thenReturn( c1 );
        Mockito.when( carRepository.findByCarId( -1L) ).thenReturn( null );

        Mockito.when( carRepository.findAll() ).thenReturn( allCars );

    }


    @Test
    void getAllCarsTest() {

        Car c1 = new Car("Opel", "Corsa");
        Car c2 = new Car("Volkswagen", "Golf");

        List<Car> cars = carManagerService.getAllCars();

        assertThat(cars).hasSize(2).extracting(Car::getMaker).contains( c1.getMaker(), c2.getMaker() );
       
    }


    @Test
    void getCarDetailsTest() {

        Car c1 = carManagerService.getCarDetails( 1L );
        assertThat( c1.getMaker() ).isEqualTo( "Opel" );

        Car car_nf = carManagerService.getCarDetails(-1L);
        assertThat( car_nf ).isNull();
    }
    
    
}