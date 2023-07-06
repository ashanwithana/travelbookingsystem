package com.travelbookingsystem.offers.service;

import com.travelbookingsystem.offers.model.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelbookingsystem.offers.repository.OfferRepository;

import java.util.List;


@Service
public class OfferService {
    private final OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    public Offer getOfferById(Long id) {
        return offerRepository.findById(id).orElse(null);
    }

    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public Offer updateOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    public void deleteOfferById(Long id) {
        offerRepository.deleteById(id);
    }
}

