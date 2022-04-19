package com.lab3.cars;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.lab3.cars.models.Car;
import com.lab3.cars.repository.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
 class Rep_Test {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    void whenFindCarByExistingId_thenReturnCar() {
        Car c1 = new Car( "Opel", "Corsa" );

        entityManager.persistAndFlush(c1);

        Car fromDb = carRepository.findByCarId( c1.getCarId() );
        assertThat(fromDb).isNotNull();
        assertThat(fromDb.getCarId()).isEqualTo( c1.getCarId() );
    }

    @Test
    void whenInvalidId_thenReturnNull() {
        Car fromDb = carRepository.findByCarId(-111L);
        assertThat(fromDb).isNull();
    }

    @Test
    void givenSetOfEmployees_whenFindAll_thenReturnAllEmployees() {
        Car c1 = new Car( "Opel", "Corsa" );
        Car c2 = new Car( "Volkswagen", "Golf" );
        Car c3 = new Car( "Renault", "Clio" );

        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.persist(c3);
        entityManager.flush();

        List<Car> allCars = carRepository.findAll();

        assertThat(allCars).hasSize(3).extracting(Car::getModel).containsOnly(c1.getModel(), c2.getModel(), c3.getModel());
    }
}
