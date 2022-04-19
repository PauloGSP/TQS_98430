package com.lab3.cars;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.lab3.cars.controller.CarController;
import com.lab3.cars.service.CarService;
import com.lab3.cars.models.Car;

@WebMvcTest(CarController.class)
 class ControllerTest {
    



    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarService carManagerService;


    @Test
    void createCar( ) throws Exception {
        Car corsisse = new Car( "Opel", "Corsa" );

        when( carManagerService.save( Mockito.any() )).thenReturn( corsisse );

        mvc.perform(
                post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JU.toJson( corsisse )))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.maker", is("Opel")))
                .andExpect(jsonPath("$.model", is("Corsa")));

        verify(carManagerService, times(1)).save(Mockito.any());
    }


    @Test
    void getAllCarsTest() throws Exception {

        Car c1 = new Car( "Opel", "Corsa" );
        Car c2 = new Car( "Volkswagen", "Golf" );
        Car c3 = new Car( "Renault", "Clio" );

        List<Car> allCars = Arrays.asList(c1, c2, c3);

        when( carManagerService.getAllCars() ).thenReturn( allCars );

        mvc.perform(
            get("/api/cars").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(3)))
            .andExpect(jsonPath("$[0].maker", is(c1.getMaker())))
            .andExpect(jsonPath("$[0].model", is(c1.getModel())))
            .andExpect(jsonPath("$[1].maker", is(c2.getMaker())))
            .andExpect(jsonPath("$[1].model", is(c2.getModel())))
            .andExpect(jsonPath("$[2].maker", is(c3.getMaker())))
            .andExpect(jsonPath("$[2].model", is(c3.getModel())));
            
        verify(carManagerService, times(1)).getAllCars();

    }


    @Test
    void getCarTest() throws Exception {

        Car corsisse = new Car( "Opel", "Corsa" );

        when( carManagerService.getCarDetails( Mockito.any() )).thenReturn( corsisse );

        mvc.perform(
            get("/api/cars/1").contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.maker", is(corsisse.getMaker())))
            .andExpect(jsonPath("$.model", is(corsisse.getModel())));

        verify(carManagerService, times(1)).getCarDetails( Long.valueOf(1) );

    }
    
}