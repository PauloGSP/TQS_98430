package com.lab3.Cars.models;

public class Car {

    private Long carID;
    private String maker;
    private String model;

    public Car(){
    }

    public Car( String model, String maker ) {
        
        this.model = model;
        this.maker = maker;
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
    public Long getCarID() {
        return carID;
    }
    public String getMaker() {
        return maker;
    }
    public String getModel() {
        return model;
    }
    public void setCarID(Long carID) {
        this.carID = carID;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

        

    
}
