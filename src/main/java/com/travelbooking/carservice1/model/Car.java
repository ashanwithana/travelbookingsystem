package com.travelbooking.carservice1.model;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;
    private String carName;
    private String carNumber;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] carImage;
    private int noOfPerson;
    private double pricePerDay;
    private String carType;

    // Default constructor (required by JPA)
    public Car() {}

    // Constructor
    public Car(String carName, String carNumber, String carImage, int noOfPerson, double pricePerDay, String carType) {
        this.carName = carName;
        this.carNumber = carNumber;
        this.carImage = carImage.getBytes();
        this.noOfPerson = noOfPerson;
        this.pricePerDay = pricePerDay;
        this.carType = carType;
    }

    // Getters and Setters
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public byte[] getCarImage() {
        return carImage;
    }

    public void setCarImage(byte[] carImage) {
        this.carImage = carImage;
    }


    public int getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }



}
