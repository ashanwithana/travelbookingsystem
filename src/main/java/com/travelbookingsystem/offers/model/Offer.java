package com.travelbookingsystem.offers.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;
    private String offerName;
    private String offerDescription;
    private String offerImage;
    private double offerPrice;

    public Offer() {
    }

    public Offer(String offerName, String offerDescription, String offerImage, double offerPrice) {
        this.offerName = offerName;
        this.offerDescription = offerDescription;
        this.offerImage = offerImage;
        this.offerPrice = offerPrice;
    }

    public Long getOfferId() {
        return offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public String getOfferImage() {
        return offerImage;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public void setOfferImage(String offerImage) {
        this.offerImage = offerImage;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    // Other methods, if any

    @Override
    public String toString() {
        return "Offer{" +
                "offerId=" + offerId +
                ", offerName='" + offerName + '\'' +
                ", offerDescription='" + offerDescription + '\'' +
                ", offerImage='" + offerImage + '\'' +
                ", offerPrice=" + offerPrice +
                '}';
    }
}
