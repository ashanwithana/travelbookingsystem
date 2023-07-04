package com.travelbooking.carservice1.service;

import com.travelbooking.carservice1.model.Rental;
import com.travelbooking.carservice1.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;

    @Autowired
    public RentalService(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }
    public Rental saveRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    public void deleteRentalById(Long rId) {
        rentalRepository.deleteById(rId);
    }



}