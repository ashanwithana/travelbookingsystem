package com.example.hotelbooking.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

@Entity
@Table(name= "hotels")

public class HotelDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Hid;
    @Column(name ="hotel_name" ,nullable = false,length = 45)
    private String HotelName;

    @Override
    public String toString() {
        return "HotelDetails{" +
                "Hid=" + Hid +
                ", HotelName='" + HotelName + '\'' +
                ", Location='" + Location + '\'' +
                '}';
    }

    @Column(name = "hLocation", nullable = false,length = 45)
    private String Location;

    public HotelDetails(){

    }
    public HotelDetails(String hotelName, String location) {
        HotelName = hotelName;
        Location = location;
    }
    public int getHid() {
        return Hid;
    }

    public void setHid(int hid) {
        Hid = hid;
    }

    public String getHotelName() {
        return HotelName;
    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
