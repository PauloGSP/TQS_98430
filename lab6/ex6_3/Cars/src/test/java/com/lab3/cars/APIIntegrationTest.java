package com.lab3.cars;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.lab3.cars.models.Car;
import com.lab3.cars.repository.CarRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

@TestPropertySource(locations = "application-integrationtest.properties")
@AutoConfigureTestDatabase 
 class APIIntegrationTest {
    

    @LocalServerPort
    int randomServerPort;

    // a REST client that is test-friendly
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository repository;

    @AfterEach
    public void resetDb() {
        repository.deleteAll();
    }


    @Test
     void whenValidInput_thenCreateCar() {
        Car car = new Car("Opel", "Corsa");
        restTemplate.postForEntity("/api/cars", car, Car.class);


        List<Car> found = repository.findAll();
        assertThat(found).extracting(Car::getModel).containsOnly("Corsa");
    }

    @Test
     void givenCars_whenGetCars_thenStatus200()  {
        createTestCar("Opel", "Corsa"); //deus o tenha ;-;
        createTestCar("Volkswagen", "Golf");

        ResponseEntity<List<Car>> response = restTemplate
                .exchange("/api/cars", HttpMethod.GET, null, new ParameterizedTypeReference<List<Car>>() {
                });

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).extracting(Car::getModel).containsExactly("Corsa", "Golf");

    }


    private void createTestCar(String maker, String model) {
        Car car = new Car(maker, model);
        repository.saveAndFlush(car);
    }

}
