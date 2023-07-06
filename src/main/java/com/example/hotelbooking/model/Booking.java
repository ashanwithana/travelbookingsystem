package com.travelbooking.hotelservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bId;

    public Booking(){

    }
    public Booking(Long bId, Long hId, String hotelName, String arrivalDate, String departureDate, double pricePerDay, int noOfDate,int noOfPerson, String hType, double totalPrice, String fName, String lName, String email, String telephone, String address, String nic) {
        this.bId = bId;
        this.hId = hId;
        this.hotelName = hotelName;
        this.arrivalDate = arrivalDate;
        this.departureDate = departureDate;
        this.pricePerDay = pricePerDay;
        this.noOfDate = noOfDate;
        this.noOfPerson = noOfPerson;
        this.hType = hType;
        this.totalPrice = totalPrice;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
        this.nic = nic;
    }

    private Long hId;
    private String hotelName;
    private String arrivalDate;
    private String departureDate;
    private double pricePerDay;
    private int noOfDate;
    private int noOfPerson;
    private String hType;
    private double totalPrice;

    private String fName;
    private String lName;
    private String email;
    private String telephone;
    private String address;
    private String nic;


    public Long getbId() {
        return bId;
    }

    public int getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(int noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public void setbId(Long bId) {
        this.bId = bId;
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

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getNoOfDate() {
        return noOfDate;
    }

    public void setNoOfDate(int noOfDate) {
        this.noOfDate = noOfDate;
    }

    public String gethType() {
        return hType;
    }

    public void sethType(String hType) {
        this.hType = hType;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

}
