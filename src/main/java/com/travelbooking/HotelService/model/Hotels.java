package com.travelbooking.HotelService.model;

import jakarta.persistence.*;
@Entity
public class Hotels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hId;

    private String hotelName;
    private String Location;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] hotelImage;
    private double pricePerPerson;
    private String hotelDesc;
    private String hotelType;

    public Hotels(){

    }
    public Hotels(Long hId, String hotelName, String location, byte[] hotelImage, double pricePerPerson, String hotelDesc, String hotelType) {
        this.hId = hId;
        this.hotelName = hotelName;
        Location = location;
        this.hotelImage = hotelImage;
        this.pricePerPerson = pricePerPerson;
        this.hotelDesc = hotelDesc;
        this.hotelType = hotelType;
    }


    public Long gethId() {
        return hId;
    }

    public void sethId(Long hId) {
        this.hId = hId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public byte[] getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(byte[] hotelImage) {
        this.hotelImage = hotelImage;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }

    public void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public String getHotelDesc() {
        return hotelDesc;
    }

    public void setHotelDesc(String hotelDesc) {
        this.hotelDesc = hotelDesc;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

}