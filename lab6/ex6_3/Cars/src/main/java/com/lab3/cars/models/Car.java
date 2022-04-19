package com.lab3.cars.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carId;

    private String maker;
    private String model;

    public Car(){
    }

    public Car( String maker, String model ) {
        
        this.maker = maker;
        this.model = model;
    }

    public Long getCarId() {
        return carId;
    }
    public String getMaker() {
        return maker;
    }
    public String getModel() {
        return model;
    }
    public void setCarId(Long carId) {
        this.carId = carId;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public void setModel(String model) {
        this.model = model;
    }

   

        

    
}
